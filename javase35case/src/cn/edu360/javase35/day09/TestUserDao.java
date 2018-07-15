package cn.edu360.javase35.day09;

import org.junit.Test;

import cn.edu360.javase35.day09.Dao.UserDao;
import cn.edu360.javase35.day09.Dao.UserDaoImpl;
import cn.edu360.javase35.day09.bean.User;

public class TestUserDao {
	@Test
	public void testSave(){
        User user = new User();
        user.setUserName("鹏鹏");
        user.setPasswd("123");
        user.setAge(18);
        user.setpNum("110120119");

        UserDao userDao = new UserDaoImpl();
        boolean save = userDao.save(user);
        System.out.println(save);
    }

    @Test
    public void testGetUserByName(){
        UserDao userDao = new UserDaoImpl();
        User name = userDao.getUserByName("鹏鹏");
        System.out.println(name);
    }


}
