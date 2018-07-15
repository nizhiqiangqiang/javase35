package cn.edu360.javase35.day10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

public class CallableClient implements Callable<String>{
	private static final String KEY="天王盖地虎";	
	private static final String VALUE="小鸡炖蘑菇";
	private String ip;
	private String serverPath;
	private String localPath;
	private String cmd;
	
	

	public CallableClient() {
		super();
	}


	public CallableClient(String ip, String serverPath, String localPath, String cmd) {
		super();
		this.ip = ip;
		this.serverPath = serverPath;
		this.localPath = localPath;
		this.cmd = cmd;
	}


	@Override
	public String call() throws Exception {
		String ret=null;
		try {
			Socket s=new Socket(ip,9999);
			OutputStream out = s.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(KEY);
			oos.flush();
			InputStream in = s.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(in);
			String value =(String)ois.readObject();
			if(VALUE.equals(value)){
				oos.writeObject(serverPath);
				oos.flush();
				FileInputStream input = new FileInputStream(localPath);
				byte[]b=new byte[1024];
				int len=0;
				while((len=input.read(b))!=-1){
					oos.write(b,0,len);
				}
				oos.flush();
				input.close();
				
				oos.writeObject(cmd);
				oos.flush();
				
				ret = (String)ois.readObject();
				//System.out.println(ret);
				
				
			}else{
				
				System.out.println("凉凉");
				
			}
			s.shutdownInput();
			s.shutdownOutput();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ret;
	}

	

}
