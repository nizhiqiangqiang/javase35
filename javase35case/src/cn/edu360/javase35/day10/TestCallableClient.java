package cn.edu360.javase35.day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.FutureTask;

public class TestCallableClient {
	public static void main(String[] args) throws Exception {
		Map<String,Integer> map=new HashMap<>();
		String ip="localhost";
		String serverPath="d:/wc.jar";
		String localPath="d:/a/wc.jar";
		String cmd="java -jar d:/a/wc.jar";
		
		CallableClient callable = new CallableClient(ip, serverPath, localPath, cmd);
		FutureTask<String> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		
		//第二台服务器
		String ip2 = "localhost";
		String serverPath2 = "d:/wc.jar";
		String localPath2 = "d:/a/wc.jar";
		String cmd2 = "java -jar d:/wc.jar";
		
		CallableClient callable2 = new CallableClient(ip2, serverPath2, localPath2, cmd2);
		FutureTask<String> futureTask2 = new FutureTask<>(callable2);
		new Thread(futureTask2).start();
		String ret1 = futureTask.get();
		String ret2 = futureTask2.get();
		String ret=ret1+ret2;
		String[] split = ret.split("\n");
		for (String kv : split) {
			String[] split2 = kv.split("=");
			if(split2.length==0){
				System.out.println("发现一个有问题的数据");
			}
			if(split2.length>1){
				Integer orDefault = map.getOrDefault(split2[0], 0);
				orDefault=orDefault+Integer.parseInt(split2[1]);
				map.put(split2[0], orDefault);
			}
			
		}
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry);
			
		}
		
	}

}
