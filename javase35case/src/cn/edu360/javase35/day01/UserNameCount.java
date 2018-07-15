package cn.edu360.javase35.day01;

public class UserNameCount {
	private String UserName;
	private int length ;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "UserNameCount [UserName=" + UserName + ", length=" + length + "]";
	}
	
	

}
