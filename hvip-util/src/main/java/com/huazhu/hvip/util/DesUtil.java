package com.huazhu.hvip.util;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES算法类
 * @author Povol
 */
public class DesUtil {  
	   private static byte[] iv1 = { (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };

    	public static String decrypt(String decryptString, String decryptKey)
    			throws Exception {
    	decryptKey = decryptKey.substring(0,8);
    	iv1= decryptKey.getBytes();
    	IvParameterSpec iv = new IvParameterSpec(iv1);
    	SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
    	Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    	cipher.init(Cipher.DECRYPT_MODE, key, iv);

    	return new String(cipher.doFinal(Base64Decoder.decodeToBytes(decryptString)));
    	}

    	public static String encrypt(String encryptString, String encryptKey)
    			throws Exception {
    	encryptKey = encryptKey.substring(0,8);
    	iv1= encryptKey.getBytes();
    	IvParameterSpec iv = new IvParameterSpec(iv1);
    	DESKeySpec dks = new DESKeySpec(encryptKey.getBytes());
    	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    	SecretKey key = keyFactory.generateSecret(dks);
    	Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    	cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    	return Base64Encoder.encode(cipher.doFinal(encryptString.getBytes()));
    	}
    
    public static void main(String[] args){
    
    	try {
    		String inStr="oaMuDjl6Osx-UWaaWZmLRsSmjmT4";
        	String key="3!#dexr*&(%ed".substring(0,8);
        	System.out.println(key);
			String encodeStr = DesUtil.encrypt(inStr, key);
			String decodeStr = DesUtil.decrypt(encodeStr, key);

			System.out.println(encodeStr);
			
			System.out.println(decodeStr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}  