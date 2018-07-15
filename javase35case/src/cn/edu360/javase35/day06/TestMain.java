package cn.edu360.javase35.day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
	public static void main(String[] args) {
		Map<String, List<SessionBean>> map = getMap();
		Map<String,List<SessionBean>> sessionmap=new HashMap<>();
		Set<Entry<String, List<SessionBean>>> entrySet = map.entrySet();
		for (Entry<String, List<SessionBean>> entry : entrySet) {
			//System.out.println(entry);
			List<SessionBean> value = entry.getValue();
			sortByDate(value);
			
		}
		makeSessionId(map);
		for (Entry<String, List<SessionBean>> entry : entrySet) {
			System.out.println(entry);
		}
		Set<Entry<String, List<SessionBean>>> entrySet2 = map.entrySet();
		for (Entry<String, List<SessionBean>> entry : entrySet2) {
			List<SessionBean> value = entry.getValue();
			for (SessionBean sessionBean : value) {
				List<SessionBean> list = sessionmap.getOrDefault(sessionBean.getSessionId(), new ArrayList<>());
				list.add(sessionBean);
				sessionmap.put(sessionBean.getSessionId(), list);				
			}
		}
		
		
		/*Set<Entry<String, List<SessionBean>>> entrySet3 = sessionmap.entrySet();
		for (Entry<String, List<SessionBean>> entry : entrySet3) {
			List<SessionBean> list = entry.getValue();
			SessionBean first = list.get(0);	
			SessionBean last = list.get(list.size()-1);
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ret=entry.getKey()+"\t"+format.format(first.getDate())+"\t"+format.format(last.getDate())+"\t"+first.getUrl()+"\t"+last.getUrl()+"\t"+(last.getDate().getTime()-first.getDate().getTime())/1000;
			System.out.println(ret);
			
			
		}*/
	}

	

	private static void makeSessionId(Map<String, List<SessionBean>> map) {
		Set<Entry<String,List<SessionBean>>> entrySet = map.entrySet();
		for (Entry<String, List<SessionBean>> entry : entrySet) {
			List<SessionBean> list = entry.getValue();
			//如果list只有一条数据
			if(list.size()==1){
				String uuid = UUID.randomUUID().toString();
				SessionBean sessionBean = list.get(0);
				sessionBean.setSessionId(uuid);
				sessionBean.setNum(1);
			}
			for(int i=0;i<list.size()-1;i++){//如果有多个数据
				SessionBean bean1 = list.get(i);
				SessionBean bean2 = list.get(i+1);
				if(sameSession(bean1,bean2)){//同一个session
					if(bean1.getSessionId()!=null){//前一个有值的时候
						bean2.setSessionId(bean1.getSessionId());
						bean2.setNum(bean1.getNum()+1);
					}else{
						String uuid = UUID.randomUUID().toString();
						bean1.setSessionId(uuid);
						bean1.setNum(1);
						bean2.setSessionId(uuid);
						bean2.setNum(2);
					}
				}else{
					if(bean1.getSessionId()!=null){
						String uuid = UUID.randomUUID().toString();
						bean2.setSessionId(uuid);
						bean2.setNum(1);
					}else{
						String uuid1 = UUID.randomUUID().toString();
						bean1.setSessionId(uuid1);
						bean1.setNum(1);
						String uuid2 = UUID.randomUUID().toString();
						bean2.setSessionId(uuid2);
						bean2.setNum(1);
					}
				}
				
			}
			
			
		}
		
	}



	private static boolean sameSession(SessionBean bean1, SessionBean bean2) {
		long time1 = bean1.getDate().getTime();
		long time2 = bean2.getDate().getTime();
		
		if(time2-time1<=(1000*60*30)){
			return true;
		}
		return false;
	}



	private static void sortByDate(List<SessionBean> value) {
		Collections.sort(value, new Comparator<SessionBean>() {

			@Override
			public int compare(SessionBean o1, SessionBean o2) {
				// TODO Auto-generated method stub
				return o1.getDate().before(o2.getDate())?-1:1;
			}
		});
		
	}

	private static Map<String,List<SessionBean>> getMap() {
		Map<String,List<SessionBean>> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/access.log.fensi"));) {
			String line=null;
			while((line=br.readLine())!=null){
				//System.out.println(line); 
				String ipRegex = "(\\d+\\.){3}\\d+";
				String dateRegex = "\\[.+\\d+\\]";
				String urlRegex = "(POST|GET){1}\\s(\\S)*\\s";
				String ip = getdataByRegex(ipRegex,line);
				String date = getdataByRegex(dateRegex,line);
				String url = getdataByRegex(urlRegex,line);
				if(url!=null&&ip!=null&&date!=null){
					SessionBean bean=new SessionBean();
					bean.set(null, ip, parseDate(date), url, 0);
					List<SessionBean> list = map.getOrDefault(ip,new ArrayList<SessionBean>());
					list.add(bean);
					map.put(ip, list);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	private static Date parseDate(String date) {
		String substring = date.substring(1, date.length()-1);
		
		SimpleDateFormat format=new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss",Locale.US);
		try {
			return format.parse(substring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	private static String getdataByRegex(String Regex, String line) {
		Pattern pattern = Pattern.compile(Regex);
		Matcher matcher = pattern.matcher(line);
		while(matcher.find()){
			return matcher.group();
		}
		return line;
		
	}

}
