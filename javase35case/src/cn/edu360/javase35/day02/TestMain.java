package cn.edu360.javase35.day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class TestMain{
	public static void main(String[] args) {
		Map<String, List<String>> map = getMap();
		ArrayList<AppBean> appList = new ArrayList<>();
		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			String key = entry.getKey();
			List<String> list = entry.getValue();
			Collections.sort(list,new Comparator<String>() {
			@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
				if(list.size()>1){
						String minVersion=list.get(0);
						String maxVersion=list.get(list.size()-1);
						String[] split = key.split(",");
						String date = split[0];
						String userName = split[1];
						String appName = split[2];
						String appStore = split[3];
						
						AppBean bean=new AppBean();
						bean.set(date, userName, appName, appStore, minVersion, maxVersion);
						appList.add(bean);
					}			
		}
		SortUtil.sortDate(appList);	
		
		try (BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/m.txt"));){
			for (AppBean entry : appList) {
				System.out.println(entry);
				bw.write(entry.toString());
				bw.newLine();
			}
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
				String key=split[0]+","+split[1]+","+split[2]+","+split[3];
				String version=split[5];
				List<String> list = map.getOrDefault(key, new ArrayList<String>());
				list.add(version);
				map.put(key, list);
				/*if(map.containsKey(key)){
					List<String> list = map.get(key);
					list.add(version);
				}else{
					List<String> list=new ArrayList<>();
					list.add(version);
					map.put(key, list);					
				}
			*/
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
