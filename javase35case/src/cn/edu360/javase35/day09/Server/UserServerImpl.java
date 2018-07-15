package cn.edu360.javase35.day09.Server;

import cn.edu360.javase35.day09.Dao.UserDao;
import cn.edu360.javase35.day09.Dao.UserDaoImpl;
import cn.edu360.javase35.day09.bean.User;
import cn.edu360.javase35.day09.bean.UserResult;

public class UserServerImpl implements UserServer{
	   @Override
	    public UserResult login(User user) {
	        UserResult result = new UserResult();

	        UserDao userDao = new UserDaoImpl();
	        User userByName = userDao.getUserByName(user.getUserName());
	        if(userByName!=null){//查找到数据的时候
	            if(user.getPasswd().equals(userByName.getPasswd())){//密码一致
	                result.setResult(true);
	                result.setDesc("登陆成功");
	                return result;
	            }else{
	                result.setResult(false);
	                result.setDesc("密码不匹配");
	                return result;
	            }
	        }else{
	            result.setResult(false);
	            result.setDesc("用户名不存在！");
	            return result;
	        }
	    }

	    /**
	     * 1:查看是否存在此用户
	     * 2：如果不存在，保存数据
	     * @param user
	     * @return
	     */
	    @Override
	    public UserResult register(User user) {
	        UserResult result = new UserResult();
	        UserDao userDao = new UserDaoImpl();
	        User userByName = userDao.getUserByName(user.getUserName());
	        if(userByName!=null){//已经有人注册过了
	            result.setResult(false);
	            result.setDesc("用户名被占用！");
	        }else{//保存数据
	            boolean save = userDao.save(user);
	            if(save){
	                result.setResult(true);
	                result.setDesc("注册成功");
	            }else{
	                result.setResult(false);
	                result.setDesc("未知异常，注册失败");
	            }

	        }
	        return result;
	    }

	    @Override
	    public UserResult updatePasswd(User user) {
	        return null;
	    }

	    @Override
	    public UserResult findPasswd(User user) {
	        return null;
	    }
	 
    

}
