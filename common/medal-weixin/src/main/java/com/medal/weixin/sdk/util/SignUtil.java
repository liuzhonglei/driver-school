package com.medal.weixin.sdk.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 请求校验工具类
 * Created by xhuji on 2016/9/2.
 */
@Component
public class SignUtil {

    /**
     * 验证微信签名
     * 加密/校验流程：
     *   1. 将token、timestamp、nonce三个参数进行字典排序
     *   2. 将三个参数字符串拼接成一个字符串并进行sha1加密
     *   3. 用signatrue与生成的加密字符串进行对比，来识别是否来自微信
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return
     */
    public static boolean checkSignature(String token,String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典排序
        String[] paramArr = new String[] { token, timestamp, nonce };
        Arrays.sort(paramArr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < paramArr.length; i++) {
            content.append(paramArr[i]);
        }
        String ciphertext = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            ciphertext = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
    }

//    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
//        StringBuffer sb = new StringBuffer();
//        Set es = parameters.entrySet();
//        Iterator it = es.iterator();
//        while(it.hasNext()) {
//            Map.Entry entry = (Map.Entry)it.next();
//            String k = (String)entry.getKey();
//            Object v = entry.getValue();
//            if(null != v && !"".equals(v)
//                    && !"sign".equals(k) && !"key".equals(k)) {
//                sb.append(k + "=" + v + "&");
//            }
//        }
//        sb.append("key=" + ConfigUtil.API_KEY);
//        //System.out.println("sign xml ====== "+sb.toString());
//        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
//        return sign;
//    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }



}
