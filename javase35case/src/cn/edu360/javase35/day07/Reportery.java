package cn.edu360.javase35.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Reportery {
	public static void main(String[] args) {
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/a/bj-poi-1.csv"),"gbk"));
				BufferedWriter bw=new BufferedWriter(new FileWriter("d:/a/reportery.txt"))){
			br.readLine();
			String line;
			while((line=br.readLine())!=null){
				try {
					String[] split = line.split(",");
					String addr = split[0];
					double lng = Double.parseDouble(split[2]);
					double lat = Double.parseDouble(split[3]);
					String province = split[5];
					String district = split[7];
					String geoHashCode = Utiles.getGeoHashCode(lat,lng);
					String ret=geoHashCode+","+province+","+province+","+district+","+addr;
					System.out.println(ret);
					bw.write(ret);
					bw.newLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
				
				
			}
			bw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
