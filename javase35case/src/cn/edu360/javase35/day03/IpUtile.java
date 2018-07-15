package cn.edu360.javase35.day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class IpUtile {
	static List<IpBean> list =null;
	static{
		 list=getList();
	}
	public static String[] getArr(List<String> list){
        String[] arr=new String[list.size()];
      for(int i=0;i<list.size();i++){
          arr[i]=list.get(i);
      }
      return arr;
  }

	public static List<String> getTop(Entry<String, Integer> entry ,int n){
		for(int i=0;i<Math.min(n, list.size());i++){
			
		}
		return null;
		
	}
	public static IpBean getProvince(long longIp){
		
		int start=0;
		int end=list.size()-1;
		while(start<=end){
			int middle=(start+end)/2;
			IpBean ipBean = list.get(middle);
			
			if(longIp>=ipBean.getStartDecIp()&&longIp<=ipBean.getEndDecIp()){
				return ipBean;
			}else if(longIp<ipBean.getStartDecIp()){
				end=middle-1;
			}else if(longIp>ipBean.getEndDecIp()){
				start=middle+1;
			}
		}
		return null;
		
	}
	
	public static long strIpToLong(String ip){
		long newIp=0L;
		if(ip==null){
			return newIp;
		}
		String[] split = ip.split("\\.");
		for (int i = 0; i < split.length; i++) {
			long l = Long.parseLong(split[i]);
			newIp |=l<<((3-i)<<3);	
		}
		return newIp;
	}
	public static List<IpBean> getList() {
		List<IpBean> list = new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader("D:/a/ip.txt"));) {
			String line;
			while((line=br.readLine())!=null){
				String[] split = line.split("\\|");
				/*第一个字段是网段的起始IP地址，第二个字段是网段的结束IP地址，
				第三个字段是网段的起始IP地址对应的十进制，第四个字段是网段的结束IP地址对应的十进制，
				第五个字段代表洲，第六个代表国家，第七个代表省，第八个代表城市，*/
				String startIp=split[0];//起始ip
				String endIp=split[1];
				Long startDecIp=Long.parseLong(split[2]);//起始十进制ip
				Long endDecIp=Long.parseLong(split[3]);
				String river=split[4] ;//洲
				String country =split[5];//国家
				String province=split[6] ;//省
				String city=split[7] ;//市
				String district=split[8] ;//区
				String isp=split[9] ;//运营商
				
				IpBean ipBean=new IpBean();
				ipBean.set(startIp, endIp, startDecIp, endDecIp, river, country, province, city, district, isp);
				list.add(ipBean);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
