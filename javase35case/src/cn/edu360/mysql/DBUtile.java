package cn.edu360.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装jdbc
 * @author root
 *
 */
public class DBUtile {
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
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
	
	/**
	 * 加载配置文件
	 */
	@SuppressWarnings("static-access")
	private static void loadData(){
		//读取文件获取输入流
		InputStream stream = DBUtile.class.getClassLoader().getSystemResourceAsStream("mysql.properties");
		//创建properties对象
		Properties p = new Properties();
		try {
			p.load(stream);
			String classDriver = p.getProperty("classDriver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			Class.forName(classDriver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
