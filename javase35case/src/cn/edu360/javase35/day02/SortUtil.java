package cn.edu360.javase35.day02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SortUtil {
	public static void sortDate(List<AppBean> list){
		Collections.sort(list, new Comparator<AppBean>() {
			
			@Override
			public int compare(AppBean o1, AppBean o2) {
					try {
						
						String date1 = o1.getDate();
						String date2 = o2.getDate();
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date parse1 = format.parse(date1);
						 Date parse2= format.parse(date2);
						
						 return parse1.before(parse2)?-1:1;
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					return 0;
					
					
			}
		});
	
		
	}

}
