package cn.edu360.javase35.day03;

public class IpBean {
	/*第一个字段是网段的起始IP地址，第二个字段是网段的结束IP地址，
	第三个字段是网段的起始IP地址对应的十进制，第四个字段是网段的结束IP地址对应的十进制，
	第五个字段代表洲，第六个代表国家，第七个代表省，第八个代表城市，*/
	private String startIp;//起始ip
	private String endIp;
	private Long startDecIp;//起始十进制ip
	private Long endDecIp;
	private String river ;//洲
	private String country ;//国家
	private String province ;//省
	private String city ;//市
	private String district ;//区
	private String isp ;//运营商
	public void set(String startIp, String endIp, Long startDecIp, Long endDecIp, String river, String country,
			String province, String city, String district, String isp) {
		this.startIp = startIp;
		this.endIp = endIp;
		this.startDecIp = startDecIp;
		this.endDecIp = endDecIp;
		this.river = river;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.isp = isp;
	}
	public String getStartIp() {
		return startIp;
	}
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	public String getEndIp() {
		return endIp;
	}
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	public Long getStartDecIp() {
		return startDecIp;
	}
	public void setStartDecIp(Long startDecIp) {
		this.startDecIp = startDecIp;
	}
	public Long getEndDecIp() {
		return endDecIp;
	}
	public void setEndDecIp(Long endDecIp) {
		this.endDecIp = endDecIp;
	}
	public String getRiver() {
		return river;
	}
	public void setRiver(String river) {
		this.river = river;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	@Override
	public String toString() {
		return "IpBean [startIp=" + startIp + ", endIp=" + endIp + ", startDecIp=" + startDecIp + ", endDecIp="
				+ endDecIp + ", river=" + river + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", district=" + district + ", isp=" + isp + "]";
	}
	
	
}
