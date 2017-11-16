package com.huazhu.hvip.thirdparty.utils;

import com.huazhu.hvip.util.DateUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Date;

public class DesUtil {
	/** 加密、解密key. */
	private static final String PASSWORD_CRYPT_KEY = "20160629";
	/** 加密算法,可用 DES,DESede,Blowfish. */
	private final static String ALGORITHM = "DES";

	public static void main(String[] args) throws Exception {
		String md5Password = "U-HMALL-20160824";
		String str = DesUtil.encrypt(md5Password, PASSWORD_CRYPT_KEY);
		System.out.println("str: " + str);
		//str: 79DC25AE458DBD502462CBC3ED953897C00EBCA9A3E889F223DE4B9144FE17F4
	}

	public static String getEncryptData(String data) {
		return null;
		//return PmsWebApi.PMS_WEB_API_USER + "-" + data;
	}

	/**
	 * 对数据进行DES加密.
	 *
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public final static String encrypt(String data, String cryptKey) {
		String result = "";
		try {
			//byte[] iv1 = DateUtil.getFormatDate(DateUtil.DATE_FORMATE_YYYYMMDD).getBytes("US-ASCII");



			byte[] iv1 = DateUtil.toString(new Date(), DateUtil.DATE_FORMATE_YYYYMMDD).getBytes("US-ASCII");
			//byte[] iv1 = "YYYYMMDD".getBytes("US-ASCII");

			DESKeySpec dks = new DESKeySpec(cryptKey.getBytes("US-ASCII"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			SecretKey securekey = keyFactory.generateSecret(dks);
			IvParameterSpec iv = new IvParameterSpec(iv1);

			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
			result = byte2hex(cipher.doFinal(data.getBytes("UTF-8")));
		} catch (Exception e) {
		}
		return result;
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}
}