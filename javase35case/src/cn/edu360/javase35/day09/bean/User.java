package cn.edu360.javase35.day09.bean;

public class User {
	   private int id;
	    private String userName;
	    private String passwd;
	    private int age;
	    private String pNum;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getPasswd() {
	        return passwd;
	    }

	    public void setPasswd(String passwd) {
	        this.passwd = passwd;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getpNum() {
	        return pNum;
	    }

	    public void setpNum(String pNum) {
	        this.pNum = pNum;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", userName='" + userName + '\'' +
	                ", passwd='" + passwd + '\'' +
	                ", age=" + age +
	                ", pNum='" + pNum + '\'' +
	                '}';
	    }
	

}
