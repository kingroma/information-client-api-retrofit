package common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpUtil {
	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;

	public void init(String ip, String id, String pw) {
		// JSch ��ü ����
		JSch jsch = new JSch();
		try {
			// ���ǰ�ü ���� ( user , host, port )
			session = jsch.getSession(id, ip);

			// password ����
			session.setPassword(pw);

			// ���ǰ��� �������� ����
			java.util.Properties config = new java.util.Properties(); // ȣ��Ʈ ���� �˻����� �ʴ´�.

			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config); // ���� session.connect();
			session.connect();

			// sftp ä�� ����
			channel = session.openChannel("sftp");
			channel.connect();
		} catch (JSchException e) {
			e.printStackTrace();
		}
		channelSftp = (ChannelSftp) channel;
	}

	public void setText(String dir, String fileNm, String text) {
		InputStream is = new ByteArrayInputStream(text.getBytes());
		if ( text != null ) {
			text = text.trim();
		}
		
		try {
			// ������ �����ͼ� inputStream�� �ְ� �����θ� ã�� put
			channelSftp.cd(dir);
			channelSftp.put(is, fileNm);
		} catch (SftpException se) {
			se.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	// ���� ���� ���ε�
//	private void upload(String dir, File file) {
//		FileInputStream in = null;
//		try {
//			// ������ �����ͼ� inputStream�� �ְ� �����θ� ã�� put
//			in = new FileInputStream(file);
//			channelSftp.cd(dir);
//			channelSftp.put(in, file.getName());
//		} catch (SftpException se) {
//			se.printStackTrace();
//		} catch (FileNotFoundException fe) {
//			fe.printStackTrace();
//		} finally {
//			try {
//				in.close();
//			} catch (IOException ioe) {
//				ioe.printStackTrace();
//			}
//		}
//	}

	public String getText(String dir, String fileNm) {
		StringBuilder sb = new StringBuilder();
		InputStream in = null;

		try {
			// ���Ž���� inputStream�� �����͸� ����
			channelSftp.cd(dir);
			in = channelSftp.get(fileNm);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (SftpException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( in != null )
					in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString().trim();
	}

	// ���� ���� �ٿ�ε�
//	public InputStream download(String dir, String fileNm) {
//		InputStream in = null;
//		try {
//			// ���Ž���� inputStream�� �����͸� ����
//			channelSftp.cd(dir);
//			in = channelSftp.get(fileNm);
//		} catch (SftpException se) {
//			se.printStackTrace();
//		}
//		return in;
//	}

	// ���ϼ����� ���� ����
	public void disconnect() {
		channelSftp.quit();
		session.disconnect();
	}

}
