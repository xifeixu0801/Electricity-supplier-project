/**
 * 
 */
package com.neuedu.shop.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author 徐习飞
 * @date 2020年5月8日上午10:32:29
 */
public class CommonsUtil {
	private CommonsUtil() {
	}

	/**
	 * 非常简单的md5加密方法
	 */
	public static String transformToMD5(String password) {
		// 生成一个MD5加密摘要
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
//			md.update(password.getBytes());
			// 创建BigInteger对象
			// digest()确定返回MD5的Hash值，返回值为8位字符串
			// BigInteger将8位的字符串转换为16位的十六进制数
			//
//			return new BigInteger(1, md.digest()).toString(16);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return null;
		byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException var7) {
            throw new RuntimeException("MD5 should be supported?", var7);
        } catch (UnsupportedEncodingException var8) {
            throw new RuntimeException("UTF-8 should be supported?", var8);
        }
 
        StringBuilder hex = new StringBuilder(hash.length * 2);
        byte[] var6 = hash;
        int var5 = hash.length;
 
        for(int var4 = 0; var4 < var5; ++var4) {
            byte b = var6[var4];
            if((b & 255) < 16) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 255));
        }
 
        return hex.toString();


	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			System.out.println(CommonsUtil.transformToMD5(new Random().nextInt(999999) + "").length());
		}

	}
	
	
	/**
	 * 文件上传相关静态方法（本地拷贝、上传服务器、存储到服务器）
	 * 
	 */
	
	public static void fileCypeToLocal(String srcPath,String destPath) {
		// 创建源文件
		File src = new File(srcPath);
		File dest = new File(destPath);
		try {
			// 进行本地拷贝	
			Files.copy(src.toPath(), dest.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
