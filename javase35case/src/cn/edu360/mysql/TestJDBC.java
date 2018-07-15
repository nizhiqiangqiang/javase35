package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class TestJDBC {
	public static void main(String[] args) {
		String url="jdbc:mysql://127.0.0.1:3306/bigdata35?characterEncoding=utf-8&useSSL=false";
		String user="root";
		String password="795411";
		//String sql="delete  from t_user where id=2";
		String sql="select * from t_user where id=3";
		List<UserBean> list=new ArrayList<>();  
		try {
			DriverManager.deregisterDriver(new Driver());
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			//int i = st.executeUpdate(sql);
			ResultSet set = st.executeQuery(sql);
			while(set.next()){
				/*int id = set.getInt(1);
				String name = set.getString(2);
				String pNum = set.getString(3);*/
				int id = set.getInt("id");
				String name = set.getString("name");
				String pNum = set.getString("age");
				UserBean bean=new UserBean();
				bean.setId(id);
				bean.setName(name);
				bean.setpNum(pNum);
				list.add(bean);
			}
		System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
