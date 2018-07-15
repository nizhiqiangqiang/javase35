package cn.edu360.javase35.day06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionBean {
	private String sessionId;
	private String ip;
	private Date date;
	private String url;
	private int num;
	public void set(String sessionId, String ip, Date date, String url, int num) {
		
		this.sessionId = sessionId;
		this.ip = ip;
		this.date = date;
		this.url = url;
		this.num = num;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "SessionBean [sessionId=" + sessionId + ", ip=" + ip + ", date=" + format.format(date) + ", url=" + url + ", num=" + num
				+ "]";
	}
	
	

}
