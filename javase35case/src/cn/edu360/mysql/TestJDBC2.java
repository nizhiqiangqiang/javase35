package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class TestJDBC2 {
	public static void main(String[] args) throws SQLException {
		testPreSelect("aa");
	}
	private static void testPreSelect(String name) throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/bigdata35?characterEncoding=utf-8&useSSL=false";
		String user="root";
		String password="795411";
		new Driver();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql="select * from t_user where name=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()){
				int id = executeQuery.getInt("id");
				String name1= executeQuery.getString("name");
				System.out.println(id+"----"+name1);
				
			}
			executeQuery.close();
			prepareStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
