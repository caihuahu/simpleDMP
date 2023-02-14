package com.wzq.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5是一种加密算法，用来将明文密码字符串加密为密文密码字符串
 * <p>
 * 在数据库中保存的是密文密码字符串
 * <p>
 * // TODO 设计为接口，实现更多的加密算法
 *
 * @author wzq
 * @create 2023-02-13 16:20
 */
public class MD5 {

    /**
     * @param strSrc
     * @return
     */
    public static String encrypt(String strSrc) {
        try {
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            byte[] bytes = strSrc.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            bytes = md.digest();
            int j = bytes.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (byte b : bytes) {
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("MD5加密出错！！+" + e);
        }
    }
}
