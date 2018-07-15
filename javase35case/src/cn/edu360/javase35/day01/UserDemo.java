package cn.edu360.javase35.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UserDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = getMap();
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		});
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/a.txt"));) {
			for(int i=0;i<Math.min(3,list.size());i++){
				System.out.println(list.get(i));
				bw.write(list.get(i).toString());
				bw.newLine();
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}

	private static Map<String,Integer> getMap() {
		Map<String,Integer>map=new HashMap<>();
		
		try(BufferedReader br=new BufferedReader(new FileReader("d:\\a\\好友.txt"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split(":");
				String userName=split[0];
				int length= split[1].split(",").length;
				map.put(userName,  length);
			}
			//System.out.println(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
