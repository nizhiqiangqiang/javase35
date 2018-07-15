package cn.edu360.javase35.day07.beans;

import java.util.Arrays;

/**
 * {"queryLocation":[41.083778,113.983896],"addrList":[{"type":"poi","status":1,"name":"华艺幼儿园","id":"ANB01390PN2H",
 * "admCode":"130725","admName":"河北省,张家口市,尚义县,","addr":"","nearestPoint":[113.98263,41.08359],"distance":127.279}]}
 *
 */
public class ResultBean {
	private String[] queryLocation;
	private AddrList[] addrList;
	public String[] getQueryLocation() {
		return queryLocation;
	}
	public void setQueryLocation(String[] queryLocation) {
		this.queryLocation = queryLocation;
	}
	public AddrList[] getAddrList() {
		return addrList;
	}
	public void setAddrList(AddrList[] addrList) {
		this.addrList = addrList;
	}
	@Override
	public String toString() {
		return "ResultBean [queryLocation=" + Arrays.toString(queryLocation) + ", addrList=" + Arrays.toString(addrList)
				+ "]";
	}
	

}
