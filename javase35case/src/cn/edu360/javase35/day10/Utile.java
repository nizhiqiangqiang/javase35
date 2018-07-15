package cn.edu360.javase35.day10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utile {
	public static String exec(String cmd){
		Runtime runtime = Runtime.getRuntime();
		try {
			Process exec = runtime.exec(cmd);
			InputStream inputStream = exec.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder sb=new StringBuilder();
			String line;
			while((line=br.readLine())!=null){
				sb.append(line+"\n");
			}
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	

}
