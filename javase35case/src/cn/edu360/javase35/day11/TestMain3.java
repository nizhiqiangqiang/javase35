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
import cn.edu360.javase35.day11.beans.OrderBean;

/**
 * 问题3.计算每个商品分类的成交总额，并按照从高到低排序（结果保存到文件中）
 *
 */
public class TestMain3 {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		QueryRunner runner = new QueryRunner(pool);
		String sql = "insert into t_shop (province,price) values (?,?)";
		Map<String, Double> mapByType = getMapByType();
		
		Set<Entry<String, Double>> entrySet = mapByType.entrySet();
		List<Entry<String, Double>> arrayList = new ArrayList<>(entrySet);

		Collections.sort(arrayList, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue()>0?1:-1;
			}
		});
		for (Entry<String, Double> entry : arrayList) {
			System.out.println(entry);
			String province = entry.getKey();
			Double price = entry.getValue();
			runner.update(sql, province,price);
		}
		
	}
	/**
	 * 按商品分类进行分组
	 * @return
	 */
	public static Map<String, Double> getMapByType() {
		Map<String, Double> map = new HashMap<>(); 
		//读取数据
		try (BufferedReader br = new BufferedReader(new FileReader("d:\\data\\order.log"));){
			String line =null;
			while((line = br.readLine())!=null){
				String[] split = line.split(" ");
				String userId = split[0];
				String ip = split[1];
				String type = split[2];
				String name = split[3];
				double price = Double.parseDouble(split[4]);
				OrderBean orderBean = new OrderBean();
				orderBean.set(userId, ip, type, name, price);
				
				//把数据存放到map中
				 Double orDefault = map.getOrDefault(orderBean.getType(), 0.0);
				 orDefault=orDefault+price;
				map.put(orderBean.getType(), orDefault);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
