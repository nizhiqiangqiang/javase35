package cn.edu360.mysql;

public class UserBean {
	private int id;
	private String name;
	private String pNum;
	
	public void set(int id, String name, String pNum) {

		this.id = id;
		this.name = name;
		this.pNum = pNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", pNum=" + pNum + "]";
	}
	

}
