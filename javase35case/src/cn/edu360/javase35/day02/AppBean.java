package cn.edu360.javase35.day02;

public class AppBean {
	private String date;
	private String userName;
	private String appName;
	private String appStore;
	private String minVersion;
	private String maxVersion;
	public void set(String date, String userName, String appName, String appStore, String minVersion,
			String maxVersion) {
		
		this.date = date;
		this.userName = userName;
		this.appName = appName;
		this.appStore = appStore;
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppStore() {
		return appStore;
	}
	public void setAppStore(String appStore) {
		this.appStore = appStore;
	}
	public String getMinVersion() {
		return minVersion;
	}
	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}
	public String getMaxVersion() {
		return maxVersion;
	}
	public void setMaxVersion(String maxVersion) {
		this.maxVersion = maxVersion;
	}
	@Override
	public String toString() {
		return "AppBean [date=" + date + ", userName=" + userName + ", appName=" + appName + ", appStore=" + appStore
				+ ", minVersion=" + minVersion + ", maxVersion=" + maxVersion + "]";
	}
	

}
