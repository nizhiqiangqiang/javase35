package cn.edu360.javase35.day07.beans;
/**
 * "addrList":[{"type":"poi","status":1,"name":"华艺幼儿园","id":"ANB01390PN2H","admCode":"130725",
 * "admName":"河北省,张家口市,尚义县,","addr":"","nearestPoint":[113.98263,41.08359],"distance":127.279}]

 */
public class AddrList {
	
	private int status;
	private String name;
	private String admName;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	@Override
	public String toString() {
		return "addrList [status=" + status + ", name=" + name + ", admName=" + admName + "]";
	}
	
	

}
