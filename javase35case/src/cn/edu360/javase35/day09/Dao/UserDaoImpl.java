package cn.edu360.javase35.day09.Dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu360.javase35.day09.Utiles.MyDbUtile;
import cn.edu360.javase35.day09.bean.User;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean save(User user) {
		String sql = "insert into t_user values(?,?,?,?,?)";
        QueryRunner runner = MyDbUtile.getRunner();
        try {
            runner.update(sql,null,user.getUserName(),user.getPasswd(),user.getAge(),user.getpNum());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public User getUserByName(String userName) {
		 String sql = "select * from t_user where userName=?";
	        QueryRunner runner = MyDbUtile.getRunner();
	        try {
	            User query = runner.query(sql, new BeanHandler<User>(User.class), userName);
	            return query;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
