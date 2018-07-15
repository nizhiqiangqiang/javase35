package cn.edu360.javase35.day05;

public class HttpBean {
	private String phone ;//手机号
	private String url ;//请求的url
	private int upData ;//上行流量
	private int lowData ;//下行流量
	
	public void set(String phone, String url, int upData, int lowData) {
		
		this.phone = phone;
		this.url = url;
		this.upData = upData;
		this.lowData = lowData;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUpData() {
		return upData;
	}
	public void setUpData(int upData) {
		this.upData = upData;
	}
	public int getLowData() {
		return lowData;
	}
	public void setLowData(int lowData) {
		this.lowData = lowData;
	}
	@Override
	public String toString() {
		return "HttpBean [phone=" + phone + ", url=" + url + ", upData=" + upData + ", lowData=" + lowData + "]";
	}
	

}
