package cn.edu360.javase35.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMain1 {
	public static void main(String[] args) {
		Map<String, List<String>> map = getMap();
		ArrayList<AppBean> appList = new ArrayList<>();
		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			String key = entry.getKey();
			List<String> list = entry.getValue();
			if(list.size()>1){
				String minVersion = list.get(0);
				String maxVersion = list.get(list.size()-1);
				String[] split = key.split(",");
				String date = split[0];
				String userName = split[1];
				String appName = split[2];
				String appStore = split[3];
				AppBean appBean=new AppBean();
				appBean.set(date, userName, appName, appStore, minVersion, maxVersion);
				appList.add(appBean);
				
			}
			
		}
		Collections.sort(appList, new Comparator<AppBean>() {

			@Override
			public int compare(AppBean o1, AppBean o2) {
				
				try {
					String date1 = o1.getDate();
					String date2 = o2.getDate();
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date parse1= format.parse(date1);
					Date parse2 = format.parse(date2);				
					return parse1.before(parse2)?-1:1 ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		});
		for (AppBean appBean : appList) {
			System.out.println(appBean);
			
		}
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/n.txt"));
			bw.write(appList.toString());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Map<String,List<String>> getMap() {
		Map<String,List<String>> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/app.txt"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split(",");
				String date = split[0];
				String userName = split[1];
				String appName = split[2];
				String appStore = split[3];
				String verson=split[5];
				String key=date+","+userName+","+appName+","+appStore;
				List<String> list = map.getOrDefault(key, new ArrayList<String>());
				list.add(verson);
				Collections.sort(list, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return o1.compareTo(o2);
					}
				});
				map.put(key, list);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
