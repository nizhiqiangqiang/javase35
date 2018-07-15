package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestOtherDBUtile1 {
	public static void main(String[] args) {
		//testSelect();
		//testUpdate();
		//testInsert();
		//testDelete();
		testPool();
	}
	private static void testPool(){
		ComboPooledDataSource sourse =new ComboPooledDataSource();
		QueryRunner runner=new QueryRunner(sourse);
		try {
			runner.update("insert into t_user (name,age) values(?,?)", "rr",12);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void testDelete(){
		Connection conn = DBUtile.getConn();
		QueryRunner runner=new QueryRunner();
		try {
			runner.update(conn, "delete from t_user where id=?",8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
	}
	private static void testSelect(){
		 Connection conn = DBUtile.getConn();
		QueryRunner runner=new QueryRunner();
		String sql="select * from t_user where id>=?";
		try {
			List<UserBean> query = runner.query(conn, sql,new BeanListHandler<UserBean>(UserBean.class),6);
			for (UserBean userBean : query) {
				System.out.println(userBean);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
	}
	private static void testUpdate(){
		Connection conn = DBUtile.getConn();
		QueryRunner runner=new QueryRunner();
		try {
			int update = runner.update(conn, "update t_user set name=?where name=?", "7","佩奇7");
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
	}
	private static void testInsert(){
		Connection conn = DBUtile.getConn();
		QueryRunner runner=new QueryRunner();
		try {
			int update = runner.update(conn, "insert into t_user (name,age)values(?,?)"," h",15);
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
		
	}
}
