package com.cldt.utils.security;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class DESEncrypt {
	 /**
     * 转换成十六进制字符串
     * @param username
     * @return
     *
     * lee on 2017-08-09 10:54:19
     */
	public static byte[] hex(String key) {
		String f = DigestUtils.md5Hex(key);
		byte[] bkeys = new String(f).getBytes();
		byte[] enk = new byte[24];
		for (int i = 0; i < 24; i++) {
			enk[i] = bkeys[i];
		}
		return enk;
	}
    
    /**
     * 3DES加密
     * @param key 密钥，24位
     * @param srcStr 将加密的字符串
     * @return
     *
     * lee on 2017-08-09 10:51:44
     */
	public static String encode3Des(String key, String srcStr) {
		//byte[] keybyte = hex(key);
		byte[] keybyte = key.getBytes();
		byte[] src = srcStr.getBytes();
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			// 加密
			//DESede/ECB/PKCS5Padding
			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(Cipher.ENCRYPT_MODE, deskey);

			String pwd = Base64.encodeBase64String(c1.doFinal(src));
			return pwd;
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
    
   /**
    * 3DES解密
    * @param key 加密密钥，长度为24字节  
    * @param desStr 解密后的字符串
    * @return
    *
    * lee on 2017-08-09 10:52:54
    */ 
	public static String decode3Des(String key, String desStr) {
		Base64 base64 = new Base64();
//		byte[] keybyte = hex(key);
		byte[] keybyte = key.getBytes();
		byte[] src = base64.decode(desStr);

		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			// 解密
			//DESede/ECB/PKCS5Padding
			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			String pwd = new String(c1.doFinal(src));
			return pwd;
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

    
    /*******************************************************************************************************************
     * 以下为该帮助类的测试代码.
     * 
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args)
        throws UnsupportedEncodingException, IOException {
    	String key = RandomStringUtils.random(24, true, true);
//    	System.out.println("key：" + key);
//		String idcard = "130682199606071234";
//		String encode = encode3Des(key, idcard);
//		System.out.println("原串：" + idcard);
//		System.out.println("加密后的串：" + encode);
//		System.out.println("解密后的串：" + decode3Des(key, encode));
    	
		String srcStr = Base64.encodeBase64String("{\"noncestr\":\"AYEbhMfNTnGqehQxLWrVRmjU\",\"accessToken\":\"gdb-acc-vGrNWT-2ba10947-35a2-422e-a319-38a28280ac60\"}".getBytes());
		String desStr = encode3Des(key, srcStr );
    	String base64 = decode3Des(key, desStr );
    	System.out.println(key);
		System.out.println(desStr);
		System.out.println(new String(Base64.decodeBase64(base64)));

    }
}
