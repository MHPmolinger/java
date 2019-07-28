package cn.zdxy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class WebUtils {

	public static String md5(String username,long expiresTime,String password){
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			String info=username+":"+expiresTime+":"+password;
			byte[] md5=md.digest(info.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
	}
}
