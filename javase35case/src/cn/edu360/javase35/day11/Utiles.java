package cn.edu360.javase35.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import cn.edu360.javase35.day11.beans.IpBean;

public class Utiles {
	static List<IpBean> list = null;
	static {
		 
		list = getIpList();
	}

	// 转换IP地址到十进制

	public static Long strIpToLongIP(String ip){
		Long newIp = 0L ;
		if(ip==null){
			return newIp;
		}
		String[] split = ip.split("\\.");
		for (int i = 0; i <=3 ; i++) {
			long l = Long.parseLong(split[i]);
			newIp |= l<<((3-i)<<3);
		}
		return newIp;
	}

	// 加载IP到集合
	
	//
	public  static 	List<IpBean> getIpList() {
		List<IpBean> list=new ArrayList<>();
		//1.读取ip.txt文件
		try(BufferedReader br=new BufferedReader(new FileReader("d:/data/ip.txt") );) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split("\\|");
				long ipStart = Long.parseLong(split[2]);
				long ipEnd = Long.parseLong(split[3]);
				String province = split[6];
				String city = split[7];
				IpBean ipBean = new IpBean();
				ipBean.set(ipStart, ipEnd, province, city);
				list.add(ipBean);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
/**
 * 二分查找
 *
 */
	public static IpBean bySearch(long newIp) {
		int start = 0 ;
		int end = list.size()-1 ;
		int middle ;
		while (start<=end) {
			middle = (start+end)/2 ;
			IpBean ipBean= list.get(middle);
	if(newIp>=ipBean.getIpStart()&&newIp<=ipBean.getIpEnd()){
				return ipBean;
			}
			if(newIp>ipBean.getIpEnd()){
				start = middle+1 ;
			}
			if(newIp<ipBean.getIpStart()){
				end = middle -1 ;
			}
		}
		return null;
	}



}