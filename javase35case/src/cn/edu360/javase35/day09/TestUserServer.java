package cn.edu360.javase35.day09;

import org.junit.Test;

import cn.edu360.javase35.day09.Server.UserServer;
import cn.edu360.javase35.day09.Server.UserServerImpl;
import cn.edu360.javase35.day09.bean.User;
import cn.edu360.javase35.day09.bean.UserResult;

public class TestUserServer {
	@Test
    public void testLogin(){
        User user = new User();
        user.setUserName("钉钉");
        user.setPasswd("1234");
        user.setAge(10);
        user.setpNum("911");
        UserServer userService = new UserServerImpl();
        UserResult login = userService.login(user);
        System.out.println(login);
    }
    @Test
    public void testRegister(){
        User user = new User();
        user.setUserName("钉钉");
        user.setPasswd("123");
        user.setAge(10);
        user.setpNum("911");
        UserServer userService = new UserServerImpl();
        UserResult register = userService.register(user);
        System.out.println(register);
    }
	

}
