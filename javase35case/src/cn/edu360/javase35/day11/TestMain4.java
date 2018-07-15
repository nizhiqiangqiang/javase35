package cn.edu360.javase35.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.util.Set;

import cn.edu360.javase35.day11.beans.LabelBean;
import cn.edu360.javase35.day11.beans.OrderBean;

/**
 * 问题4.构建每一个用户的用户画像，就是根据用户购买的具体商品，给用户打上一个标签，为将来的商品推荐系统作数据支撑
 */
public class TestMain4 {
	
	public static void main(String[] args) throws IOException, SQLException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		QueryRunner runner = new QueryRunner(pool);
		String sql = "insert into t_shop2 (userId,behavior) values (?,?)";
		
		Map<String,List<String>> newMap=new HashMap<>();
		Map<String, List<String>> mapByName = getMapByName();
		Set<Entry<String, List<String>>> entrySet = mapByName.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			String userId = entry.getKey();
			List<String> name = entry.getValue();
			for (String s : name) {
				
				BufferedReader br1 = new BufferedReader(new FileReader("d:\\data\\label.txt"));
				String line;
				while((line=br1.readLine())!=null){
					String[] split = line.split(" ");
					String key = split[1];
					String behavior = split[2];
					if(s.equals(key)){
						List<String> list = newMap.getOrDefault(userId, new ArrayList<String>());
						list.add(behavior);
						newMap.put(userId, list);
					}
			}
				
			}
			}
		Set<Entry<String, List<String>>> entrySet2 = newMap.entrySet();
		for (Entry<String, List<String>> entry : entrySet2) {
			System.out.println(entry);
			String userId = entry.getKey();
			List<String> behavior = entry.getValue();
			for (int i=0;i<behavior.size();i++) {
				String s = behavior.get(i);
				System.out.println(s);
				
			}
			runner.update(sql, userId, behavior);
			
		}
		
		
		}
		
		
	
	
	
	
	public static Map<String, List<String>> getMapByName() {
		Map<String, List<String>> map = new HashMap<>(); 
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
				String name1 = orderBean.getName();
				
				//把数据存放到map中
				List<String> list = map.getOrDefault(orderBean.getUserId(),new ArrayList<String>());
				list.add(name1);
				
				map.put(orderBean.getUserId(), list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
