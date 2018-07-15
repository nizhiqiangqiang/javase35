package cn.edu360.javase35.day09.Server;

import cn.edu360.javase35.day09.bean.User;
import cn.edu360.javase35.day09.bean.UserResult;

public interface UserServer {
	UserResult login(User user);

	   
    UserResult register(User user);

   
    UserResult updatePasswd(User user);

    UserResult findPasswd(User user);

}
