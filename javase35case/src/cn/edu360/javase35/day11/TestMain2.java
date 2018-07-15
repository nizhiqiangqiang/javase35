package cn.edu360.javase35.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.util.Set;

import cn.edu360.javase35.day11.beans.IpBean;

/**
 * 问题2.计算每个省城市成交量的top3（结果保存到文件或数据库中）
 *
 */
public class TestMain2 {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		QueryRunner runner = new QueryRunner(pool);
		String sql = "insert into t_shop1 (city,price) values (?,?)";
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
				String city = ipBean.getCity();
				
				Double orDefault = map.getOrDefault(city, 0.0);
				orDefault=orDefault+Double.parseDouble(price);
				map.put(city,orDefault);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Entry<String, Double>> entrySet = map.entrySet();
		ArrayList<Entry<String, Double>> list = new ArrayList<>(entrySet);
		//排序
		Collections.sort(list, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue()>0?1:-1;
			}
		});
		//top3
		for(int i=0;i<Math.min(3, list.size());i++){
			Entry<String, Double> entry = list.get(i);
			String city = entry.getKey();
			Double price = entry.getValue();
			runner.update(sql,city,price);
		}
		
		
	}

}
