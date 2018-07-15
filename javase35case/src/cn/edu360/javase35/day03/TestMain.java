package cn.edu360.javase35.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu360.mysql.DBUtile;
import cn.edu360.mysql.UserBean;

public class TestMain {
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/access.log"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split("\\|");
				String ip = split[1];
				long ip1 = IpUtile.strIpToLong(ip);
				IpBean ipBean = IpUtile.getProvince(ip1);
				String province = ipBean.getProvince();
				Integer count = map.getOrDefault(province, 0);
				count++;
				map.put(province, count);	
			}
			Set<Entry<String, Integer>> entrySet = map.entrySet();
			ArrayList<Entry<String, Integer>> list = new ArrayList<>(entrySet);
			Collections.sort(list, new Comparator<Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					return o2.getValue()-o1.getValue();
				}
			});
		
		
		
			
			ComboPooledDataSource sourse=new ComboPooledDataSource();
				QueryRunner runner=new QueryRunner(sourse);
				for (Entry<String, Integer> entry : list) {
					runner.update("insert into t_user (name,age) values (?,?)", entry.getKey(),entry.getValue());
				}
				
				
			
			
	
				
				
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
