package cn.edu360.javase35.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu360.javase35.day11.beans.IpBean;
/**
 * 问题1.计算出各个省的成交量总额（结果保存到文件或者数据库中）

 *
 */
public class TestMain1 {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		QueryRunner runner = new QueryRunner(pool);
		String sql = "insert into t_shop (province,price) values (?,?)";
		
			Map<String,Double> map=new HashMap<>();
			//1.读取order.log文件
			try(BufferedReader br=new BufferedReader(new FileReader("d:/data/order.log"));) {
				String line;
				while((line=br.readLine())!=null){
					//System.out.println(line);
					String[] split = line.split(" ");
					long ip = Utiles.strIpToLongIP(split[1]);
					String price = split[4];
					IpBean ipBean = Utiles.bySearch(ip);
					String province = ipBean.getProvince();
					Double orDefault = map.getOrDefault(province, 0.0);
					orDefault=orDefault+Double.parseDouble(price);
					map.put(province, orDefault);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Set<Entry<String, Double>> entrySet = map.entrySet();
			for (Entry<String, Double> entry : entrySet) {
				String province = entry.getKey();
				Double price = entry.getValue();
				runner.update(sql, province,price);
			}
			
		}
		
		
	

	
	

	
	

}
