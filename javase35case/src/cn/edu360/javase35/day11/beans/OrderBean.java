package cn.edu360.javase35.day11.beans;
/**
 * 封装OrderBean
 * 
 *
 */
public class OrderBean {
	//A 202.106.196.115 手机 iPhone8 8000
	private String userId;	//用户ID 
	private String ip;		//ip地址 
	private String type;	//商品分类
	private String name;	//购买明细   
	private double price;	//商品金额
	
	public void set(String userId, String ip, String type, String name, double price) {
	
		this.userId = userId;
		this.ip = ip;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderBean [userId=" + userId + ", ip=" + ip + ", type=" + type + ", name=" + name + ", price=" + price
				+ "]";
	}
	
	

}
