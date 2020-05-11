package common.util;

import org.apache.commons.net.ftp.FTPClient;

public class FtpUtil {
	private FTPClient client = new FTPClient();
	
	public FtpUtil(String ip , String id, String pw) {
		try {
			client.setControlEncoding("UTF-8");
			client.connect(ip,22);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void getFileList(String path) {
		
	}
}
