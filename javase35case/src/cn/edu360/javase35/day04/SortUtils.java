package cn.edu360.javase35.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortUtils {
	public static void sortListByRateDesc(List<Movie> list){
		Collections.sort(list, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				// TODO Auto-generated method stub
				return o2.getRate().compareTo(o1.getRate());
			}
		});
	}
	public static ArrayList<Entry<String, Double>> sortMapByAvgRateDesc(Map<String,Double>map){
		Set<Entry<String, Double>> entrySet = map.entrySet();
		ArrayList<Entry<String, Double>> list = new ArrayList<>(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
		
	}
	public static void sortListByCount(List<Movie> values) {

		Collections.sort(values, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
	}

}
