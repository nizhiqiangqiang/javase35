package cn.edu360.javase35.day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMain {
	public static void main(String[] args) {
		Map<String, TelBean> telMap = getTelMap();
		Map<String,Integer> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/http.log"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split("\\s");
				String phone = split[0];
				String url = split[1];
				String upData = split[2];
				String lowData = split[3];
				String phone7 = phone.substring(0, 7);
				TelBean telBean = telMap.get(phone7);
				String province = telBean.getProvince();
				
				Integer sum = map.getOrDefault(province, 0);
				sum=sum+Integer.parseInt(upData)+Integer.parseInt(lowData);
				map.put(province, sum);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		
		SortUtile.sort(list);
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry);
		}

			
		}
	

	private static Map<String,TelBean> getTelMap() {
		Map<String,TelBean> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/手机号段规则.txt"));) {
			String line;
			br.readLine();
			while((line=br.readLine())!=null){
				String[] split = line.split("\\s");
				String prefix=split[0];
				String phone=split[1] ;
				String province=split[2] ;
				String city=split[3] ;
				String isp=split[4] ;
				
				TelBean telBean=new TelBean();
				telBean.set(prefix, phone, province, city, isp);
				map.put(phone, telBean);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	private static Map<String,Integer> getHttpMap() {
		Map<String,Integer> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/http.log"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split(" ");
				int upData = Integer.parseInt(split[1]);
				int lowData = Integer.parseInt(split[2]);
				String[] split2 = split[0].split("\t");
				String phone = split2[0];
				String url = split2[1];
				HttpBean hb=new HttpBean();
				hb.set(phone, url, upData, lowData);
				int data=hb.getUpData()+hb.getLowData();
				
				Integer list = map.getOrDefault(url, 0);
				list+=data;
				map.put(url, list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
		
	}

}
