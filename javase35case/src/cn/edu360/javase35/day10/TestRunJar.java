package cn.edu360.javase35.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRunJar {
	public static void main(String[] args) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String command="java -jar d:/a/wc.jar ";
	
			Process exec = runtime.exec(command);
			InputStream inputStream = exec.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			String line=null;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		
	}

}
