package cn.edu360.javase35.day07.test;

import ch.hsr.geohash.GeoHash;

public class TestGeoHash {
	public static void main(String[] args) {
		String hash = GeoHash.withCharacterPrecision(41.083778, 113.983896,8).toBase32();
		System.out.println(hash);
	}
	

}
