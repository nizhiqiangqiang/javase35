package cn.edu360.javase35.day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest2 {
	public static void main(String[] args) {
		Map<String, List<String>> map = getMap();
		Set<String> keySet = map.keySet();
		 ArrayList<String> list = new ArrayList<>(keySet);
		 try(BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/b.txt"));) {
			 for(int i=0;i<list.size()-1;i++){
				 String keyi = list.get(i);
				 List<String> listi= map.get(keyi);
				 for(int j=i+1;j<list.size();j++){
					 String keyj = list.get(j);
					 List<String> listj = map.get(keyj);
					 ArrayList<String> listjp = new ArrayList<String>(listj);
					 listjp.retainAll(listi);
					 if(listjp!=null&&listjp.size()>0){
						 System.out.println(keyi+"和"+keyj+"的共同好友："+listjp);
						 String str=keyi+"和"+keyj+"的共同好友："+listjp;
						 bw.write(str);
						 bw.newLine();
					 }
					 
				 }
			 }
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	}

	private static Map<String,List<String>> getMap() {
		Map<String,List<String>> map=new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader("D:/a/好友.txt"));) {
			
			String line=null;
			while((line=br.readLine())!=null){
				String[] split = line.split(":");
				String userName = split[0];
				String[] split2 = split[1].split(",");
				List<String> list = Arrays.asList(split2);
				ArrayList<String> newList = new ArrayList<>(list);
				map.put(userName, newList);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
