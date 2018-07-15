package cn.edu360.javase35.day05;

public class TelBean {
	private String prefix ;
	private String phone ;
	private String province ;
	private String city ;
	private String isp ;

	
	
	

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	@Override
	public String toString() {
		return "TelBean [prefix=" + prefix + ", phone=" + phone + ", province=" + province + ", city=" + city + ", isp="
				+ isp + "]";
	}

	public void set(String prefix, String phone, String province, String city, String isp) {
		
		this.prefix = prefix;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.isp = isp;
	}

	
	
	
}
