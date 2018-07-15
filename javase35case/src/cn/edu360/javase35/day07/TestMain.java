package cn.edu360.javase35.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.edu360.javase35.day07.beans.AddrList;
import cn.edu360.javase35.day07.beans.BikeBean;
import cn.edu360.javase35.day07.beans.ResultBean;

public class TestMain {
	static Map<String, String> map = loadData();
	public static void main(String[] args) {
		
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/bikes.log"));) {
			String line;
			while((line=br.readLine())!=null){
				BikeBean bikeBean = JSON.parseObject(line, BikeBean.class);
				double lng = bikeBean.getLongitude();
				double lat = bikeBean.getLatitude();
				String ret = findAddr(lat, lng);
				System.out.println(ret);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String findAddr(double lat, double lng) {
		String findAddrByLocal = findAddrByLocal(lat,lng);
		if(findAddrByLocal==null){
			findAddrByLocal = findAddrByNet(lat,lng);
		}
		
		return findAddrByLocal;
	}

	private static String findAddrByNet(double lat, double lng) {
		String json = Utiles.getJsonByHttpClient(lat, lng);
		ResultBean resultBean = JSON.parseObject(json, ResultBean.class);
		AddrList[] addrList = resultBean.getAddrList();
		AddrList addrList2 = addrList[0];
		String name = addrList2.getName();
		String admName = addrList2.getAdmName();
		 if(name!=null&&!"".equals(name)&&admName!=null&&!"".equals(admName)){
			 String geoHashCode = Utiles.getGeoHashCode(lat, lng);
			 String ret=geoHashCode+","+admName+","+name;
			 try(BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/thing.txt",true));) {
				bw.write(ret);
				bw.newLine();
				map.put(geoHashCode, ret);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 return ret;
		 }
		return null;
	}

	private static String findAddrByLocal(double lat, double lng) {
		String geoHashCode = Utiles.getGeoHashCode(lat, lng);
		String addr=map.get(geoHashCode);
		return addr;
		
		
		
	}
	public static Map<String,String> loadData(){
		Map<String,String> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("D:/a/reportery.txt"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split(",");
				String hashcode = split[0];
				map.put(hashcode, line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	

}
