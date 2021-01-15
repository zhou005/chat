package cn.edu.hcnu.util;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    /**����MD5���м���
     * @param str  �����ܵ��ַ���
     * @return  ���ܺ���ַ���
     * @throws NoSuchAlgorithmException  û�����ֲ�����ϢժҪ���㷨
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //ȷ�����㷽��
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //���ܺ���ַ���
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
    /**�ж��û������Ƿ���ȷ
     * @param newpasswd  �û����������
     * @param oldpasswd  ���ݿ��д洢�����룭���û������ժҪ
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(encoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}