package cn.edu360.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtile1 {
	private static String url;
	private static String username;
	private static String password;
	static{
		//只加载一次，节省资源
		loadData();
	}
	public static void main(String[] args) {
		System.out.println(url);
	}
	/**
	 * 释放资源
	 */
	public static void relase(ResultSet res,Statement sta,Connection conn){
		//关闭是有序的     先打开的资源后关闭
		if(res!=null){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(sta!=null){
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@SuppressWarnings("static-access")
	private static void loadData(){
		InputStream stream = DBUtile.class.getClassLoader().getSystemResourceAsStream("mysql.properties");
		Properties p=new Properties();
		try {
			p.load(stream);
			
			String classDriver = p.getProperty("classDriver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			Class.forName(classDriver);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
