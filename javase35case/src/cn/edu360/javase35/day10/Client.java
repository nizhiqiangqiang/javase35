package cn.edu360.javase35.day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	private static final String KEY="天王盖地虎";	
	private static final String VALUE="小鸡炖蘑菇";
	public static void main(String[] args) {
		try {
			Socket s=new Socket("localhost",9999);
			OutputStream out = s.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(KEY);
			oos.flush();
			InputStream in = s.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(in);
			String value =(String)ois.readObject();
			if(VALUE.equals(value)){
				oos.writeObject("d:/wc.jar");
				oos.flush();
				FileInputStream input = new FileInputStream("d:/a/wc.jar");
				byte[]b=new byte[1024];
				int len=0;
				while((len=input.read(b))!=-1){
					oos.write(b,0,len);
				}
				oos.flush();
				input.close();
				
				oos.writeObject("java -jar d:/wc.jar");
				oos.flush();
				
				String ret = (String)ois.readObject();
				System.out.println(ret);
				
				
			}else{
				
				System.out.println("凉凉");
				
			}
			s.shutdownInput();
			s.shutdownOutput();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
