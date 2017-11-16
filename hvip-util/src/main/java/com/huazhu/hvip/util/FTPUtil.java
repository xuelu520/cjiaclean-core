/*
 * Copyright (C),2016-2016. 华住酒店管理有限公司
 * FileName: FTPUtil.java
 * Author:   admin
 * Date:     2016-03-08 15:33:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <admin><2016-03-08 15:33:15><version><desc><source>
 *
 */

package com.huazhu.hvip.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {

	private FTPClient client = null;

	private String remoteDir = "/";

	public boolean login(String host, String user, String pwd)
			throws SocketException, IOException {
		return login(host, user, pwd, "/");
	}

	/**
	 * 登陆
	 * 
	 * @param host
	 * @param user
	 * @param pwd
	 * @return
	 * @throws IOException
	 * @throws SocketException
	 */
	public boolean login(String host, String user, String pwd, String remoteDir)
			throws SocketException, IOException {

		client = new FTPClient();

		client.connect(host);
		client.setControlEncoding("UTF-8");
		int reply = client.getReplyCode();
		client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
		client.setConnectTimeout(0);
		if (!FTPReply.isPositiveCompletion(reply)) {
			client.disconnect();
			System.err.println("FTP server refused connection.");
		}

		this.remoteDir = remoteDir;

		return client.login(user, pwd);

	}

	/***
	 * 得到文件名
	 * 
	 * @return
	 */
	public List<String> getNames(boolean deep) {

		List<String> names = new ArrayList<String>();

		if (client != null) {
			names = checkDirectory(names, client, deep);
		}

		return names;
	}

	public List<FTPFile> getFTPFiles() throws IOException {

		List<FTPFile> list = new ArrayList<FTPFile>();
		if (client != null) {
			FTPFile[] files;
			files = client.listFiles(this.remoteDir);
			for (int i = 0; i < files.length; i++) {
				FTPFile file = files[i];
				String name = file.getName();
				if (name.equals(".") || name.equals("..")) {
					continue;
				} else if (file.isFile()) {
					list.add(file);
				}
			}

		}
		return list;
	}

	private List<String> checkDirectory(List<String> names, FTPClient client,
			boolean deep) {

		try {
			System.out.println("---" + client.printWorkingDirectory());
			FTPFile[] files = client.listFiles(client.printWorkingDirectory());
			for (int i = 0; i < files.length; i++) {
				FTPFile file = files[i];
				// System.out.println(file.getTimestamp().getTime().toLocaleString());
				String name = file.getName();
				if (name.equals(".") || name.equals("..")) {
					continue;
				}

				if (deep && file.isDirectory()) {
					// System.out.println(client
					// .printWorkingDirectory());
					if (client.changeWorkingDirectory(client
							.printWorkingDirectory()
							+ "/" + name)) {
						names = checkDirectory(names, client, deep);
					}
					client.changeToParentDirectory();
				} else if (file.isFile()) {
					String d = client.printWorkingDirectory();
					d = (d.equals("/") ? "" : d);
					name = d + "/" + name;
					names.add(name);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;
	}

	/***
	 * 下载数据到指定的目录中
	 * 
	 * @param filename
	 *            ftp端文件名称
	 * @param local
	 *            客户端保存路劲
	 * @return
	 */
	public boolean download(String filename, String local) {
		boolean f = false;
		try {
			File file = new File(local
					+ (filename.startsWith("/") ? filename : "/" + filename));
			File file2 = file.getParentFile();
			if (!file2.exists()) {
				file2.mkdirs();
			}
			file2 = null;

			// System.out.println(file.getParent());

			OutputStream out = new FileOutputStream(file);
			f = client.retrieveFile(this.remoteDir + "/" + filename, out);
			out.close();
			// System.out.println(client.getReplyCode());
			client.logout();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client.isConnected()) {
				try {
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return f;
	}

	public static void main(String[] args) {
		FTPUtil ftpUtil = new FTPUtil();
		try {
			boolean c = ftpUtil.login("127.0.0.1", "aata",
					"123");
			System.out.println(c);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// List<String> list = ftpUtil.getNames(false);
		//
		// for (String string : list) {
		// System.out.println(string);
		// }

		if (ftpUtil.download("20100714.rar", "d:/ftp")) {
			System.out.println("下载成功！");
		}
	}
}
