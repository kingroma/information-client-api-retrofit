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
		// JSch 객체 생성
		JSch jsch = new JSch();
		try {
			// 세션객체 생성 ( user , host, port )
			session = jsch.getSession(id, ip);

			// password 설정
			session.setPassword(pw);

			// 세션관련 설정정보 설정
			java.util.Properties config = new java.util.Properties(); // 호스트 정보 검사하지 않는다.

			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config); // 접속 session.connect();
			session.connect();

			// sftp 채널 접속
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
			// 파일을 가져와서 inputStream에 넣고 저장경로를 찾아 put
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

	// 단일 파일 업로드
//	private void upload(String dir, File file) {
//		FileInputStream in = null;
//		try {
//			// 파일을 가져와서 inputStream에 넣고 저장경로를 찾아 put
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
			// 경로탐색후 inputStream에 데이터를 넣음
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

	// 단일 파일 다운로드
//	public InputStream download(String dir, String fileNm) {
//		InputStream in = null;
//		try {
//			// 경로탐색후 inputStream에 데이터를 넣음
//			channelSftp.cd(dir);
//			in = channelSftp.get(fileNm);
//		} catch (SftpException se) {
//			se.printStackTrace();
//		}
//		return in;
//	}

	// 파일서버와 세션 종료
	public void disconnect() {
		channelSftp.quit();
		session.disconnect();
	}

}
