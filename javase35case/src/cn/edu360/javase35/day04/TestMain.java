package cn.edu360.javase35.day04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class TestMain {
	public static void main(String[] args) {
		 Map<String, Integer> question4Map = getQuestion4Map();
		 Set<Entry<String, Integer>> entrySet = question4Map.entrySet();
		 for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry);
		}
		}
		
	public static void getQuestion5Map(){
		 Map<String, List<Movie>> mapByMovie = getMapByMovie();
		 Set<Entry<String, List<Movie>>> entrySet = mapByMovie.entrySet();
		 for (Entry<String, List<Movie>> entry : entrySet) {
			 String movie = entry.getKey();
			 List<Movie> value = entry.getValue();
			 
			
		}
		 
	}
	public static Map<String,Integer>  getQuestion4Map(){
		Map<String,Integer> map=new HashMap<>();
		Map<String, List<Movie>> mapByMovie = getMapByMovie();
		Set<Entry<String, List<Movie>>> entrySet = mapByMovie.entrySet();
		for (Entry<String, List<Movie>> entry : entrySet) {
			String movie = entry.getKey();
			List<Movie> values = entry.getValue();
			
			map.put(movie,values.size());	
		}
		return map;
		
	}
	public static void getQuestion3Map(){
		Map<String, Double> question2Map = getQuestion2Map();
		ArrayList<Entry<String, Double>> list = SortUtils.sortMapByAvgRateDesc(question2Map);
		for(int i=0;i<3;i++){
			Entry<String, Double> entry = list.get(i);
			System.out.println(entry);
		}
		
	}
	public static Map<String,Double> getQuestion2Map(){
		Map<String,Double> map2=new HashMap<>();
		Map<String, List<Movie>> mapByUid = getMapByUid();
		Set<Entry<String, List<Movie>>> entrySet = mapByUid.entrySet();
		for (Entry<String, List<Movie>> entry : entrySet) {
			String uid = entry.getKey();
			List<Movie> values = entry.getValue();
			Double sum = 0.0;
			for (Movie movie : values) {
				Double rate = movie.getRate();
				sum+=rate;
			}
			map2.put(uid, sum/values.size());
			
		}
		return map2;
	}
	
	public static Map<String,List<Double>> getQuestion1Map(){
		Map<String,List<Double>> map1 =new HashMap<>();
		Map<String, List<Movie>> mapByUid = getMapByUid();
		Set<Entry<String, List<Movie>>> entrySet = mapByUid.entrySet();
		for (Entry<String, List<Movie>> entry : entrySet) {
			String uid = entry.getKey();
			List<Movie> values = entry.getValue();
			if(values.size()>2){
				List<Double>list = new ArrayList<>();
				for(int i=0;i<3;i++){
					Movie movie = values.get(i);
					Double rate = movie.getRate();
					list.add(rate);
				}
				map1.put(uid, list);
			}
			
		}
		return map1;

	}
	public static Map<String, List<Movie>> getMapByUid(){
		Map<String, List<Movie>> map = new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/rating.txt"));){
			String line;
			while((line=br.readLine())!=null){
				Movie m = JSON.parseObject(line, Movie.class);
				int uid = m.getUid();
				List<Movie> list = map.getOrDefault(uid+"",new ArrayList<Movie>());
				list.add(m);
				SortUtils.sortListByRateDesc(list);
				map.put(uid+"", list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	public static Map<String,List<Movie>> getMapByMovie(){
		Map<String,List<Movie>> map=new HashMap<>();
		try(BufferedReader br=new BufferedReader(new FileReader("d:/a/movie.txt"));) {
			String line;
			while((line=br.readLine())!=null){
				Movie m = JSON.parseObject(line, Movie.class);
				String movie = m.getMovie();
				List<Movie> list = map.getOrDefault(movie, new ArrayList<Movie>());
				list.add(m);
				map.put(movie, list);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
