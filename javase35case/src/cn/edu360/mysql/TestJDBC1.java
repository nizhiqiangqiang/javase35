package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class TestJDBC1 {
	public static void main(String[] args) {
		testPreSelect("aa");
	}

	private static void testPreSelect(String name) {
		List<UserBean> list =new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/bigdata35?characterEncoding=utf-8&useSSL=false";
		String user="root";
		String password="795411";
		try {
			//DriverManager.deregisterDriver(new Driver());
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql="select * from t_user where name=?";
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, name);
			ResultSet result= prepareStatement.executeQuery();
			while(result.next()){
				int id = result.getInt("id");
				String t_name = result.getString("name");
				//String pNum = result.getString("pNum");
				System.out.println(id+"\t"+t_name+"\t");
			}
			result.close();
			prepareStatement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
