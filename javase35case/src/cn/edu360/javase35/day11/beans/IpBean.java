package cn.edu360.javase35.day11.beans;
/**
 * 1.0.1.0|1.0.3.255|16777472|16778239|亚洲|中国|福建|福州||电信|350100|China|CN|119.306239|26.075302
 *	封装IpBean
 */

public class IpBean {
	private long ipStart;//起始十进制ip
	private long ipEnd;//结束十进制ip
	private String province ;//省
	private String city ;//市
	public void set(long ipStart, long ipEnd, String province, String city) {
		
		this.ipStart = ipStart;
		this.ipEnd = ipEnd;
		this.province = province;
		this.city = city;
	}
	public long getIpStart() {
		return ipStart;
	}
	public void setIpStart(long ipStart) {
		this.ipStart = ipStart;
	}
	public long getIpEnd() {
		return ipEnd;
	}
	public void setIpEnd(long ipEnd) {
		this.ipEnd = ipEnd;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "IpBean [ipStart=" + ipStart + ", ipEnd=" + ipEnd + ", province=" + province + ", city=" + city + "]";
	}
	


}
