package cn.edu360.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.edu360.mysql.UserBean;

/**
 * 
 * @author root
 *
 */
public class TestOtherDBUtiles {
	public static void main(String[] args) {
		//testInsert();
		//testUpdate();
		//testSelect();
		testPool();
	}
	/**
	 * 测试查询
	 */
	private static void testPool(){
		ComboPooledDataSource sourse =new ComboPooledDataSource();
		QueryRunner runner=new QueryRunner(sourse);
		try {
			runner.update("insert into t_user (name,age)values(?,?)", "vv",12);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void testSelect(){
		Connection conn = DBUtile.getConn();
		QueryRunner runner = new QueryRunner();
		String sql = "select * from t_user where id>?";
		
		try {
			// 注意：属性值要跟字段名一致   有set get方法
			List<UserBean> query = runner.query(conn, sql, new BeanListHandler<UserBean>(UserBean.class), 2);
			
			for (UserBean userBean : query) {
				System.out.println(userBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 测试更改
	 */
	private static void testUpdate(){
		Connection conn = DBUtile.getConn();
		//封装了一些插入和查询的操作
		QueryRunner runner = new QueryRunner();
		try {
			int num = runner.update(conn, "update t_user set pNum=? where name=?", "8888888","帅帅");
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
	}
	/**
	 * 测试插入
	 */
	private static void testInsert() {
		Connection conn = DBUtile.getConn();
		//封装了一些插入和查询的操作
		QueryRunner runner = new QueryRunner();
		try {
			
			int num = runner.update(conn, "insert into t_user (name,pNum) values (?,?)", "帅帅","178003948");
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtile.relase(null, null, conn);
		}
	}
}
