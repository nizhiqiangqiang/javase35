package cn.edu360.javase35.day09.Dao;

import cn.edu360.javase35.day09.bean.User;

public interface UserDao {
	 
    boolean save(User user);

    User getUserByName(String userName);

    boolean delete(int id);

    
    boolean update(User user);
	

}
