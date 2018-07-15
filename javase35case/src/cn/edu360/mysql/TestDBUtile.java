package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDBUtile {
	public static void main(String[] args) {
		Connection conn = DBUtile.getConn();
		String sql="insert into t_user (name) values(?)";
		PreparedStatement prepareStatement=null ;
		try {
			prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, "55");
			int num = prepareStatement.executeUpdate();
			System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, prepareStatement, conn);
		}
	}

}
