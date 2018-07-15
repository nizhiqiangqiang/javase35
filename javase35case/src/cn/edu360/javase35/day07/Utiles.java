package cn.edu360.javase35.day07;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import ch.hsr.geohash.GeoHash;

public class Utiles {

public static String getGeoHashCode(double lat, double lng) {
	String geoHash = GeoHash.withCharacterPrecision(lat, lng, 8).toBase32();

	return geoHash;
	
}

public static String getJsonByHttpClient(double lat, double lng) {
	HttpClient httpClient = new HttpClient();
	String uri="http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + lng+"&type=010";
	HttpMethod method = new GetMethod(uri);
	try {
		httpClient.executeMethod(method);
		String json = method.getResponseBodyAsString();
		return json;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}

}
