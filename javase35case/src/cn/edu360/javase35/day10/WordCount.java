package cn.edu360.javase35.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/TestMain.java"));) {
			String line;
			while((line=br.readLine())!=null){
				Pattern compile = Pattern.compile("\\b\\w+\\b");
				Matcher matcher = compile.matcher(line);
				while(matcher.find()){
					String group = matcher.group();
					//System.out.println(group);
					Integer orDefault = map.getOrDefault(group, 0);
					orDefault++;
					map.put(group, orDefault);
				}
				
			}
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			for (Entry<String, Integer> entry : entrySet) {
				System.out.println(entry);			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
