package com.drivers.weixin.util;

/**
 * Created by xhuji on 2016/10/12.
 */
import java.security.MessageDigest;
import java.util.zip.CRC32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SecurityUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

    private SecurityUtils() {
    }

    public static String encode(String s, String k) {
        String ret = "";

        try {
            byte[] e = s.getBytes("UTF-8");
            byte[] bb = ed(e, k, 0, e.length);
            CRC32 zCrc = new CRC32();
            zCrc.update(bb, 0, bb.length);
            long crc = zCrc.getValue();
            byte[] bbb = new byte[bb.length + 4];
            bbb[0] = (byte)((int)crc);
            bbb[1] = (byte)((int)(crc >> 24));
            bbb[2] = (byte)((int)(crc >> 8));
            bbb[3] = (byte)((int)(crc >> 16));
            System.arraycopy(bb, 0, bbb, 4, bb.length);
            ret = bth(bbb);
        } catch (Exception var9) {
            LOGGER.error("加密异常，" + var9.getMessage(), var9);
        }

        return ret;
    }

    public static String decode(String s, String k) {
        String ret = "";

        try {
            byte[] e = htb(s);
            long crc = (long)(e[0] & 255) + ((long)(e[1] & 255) << 24) + ((long)(e[2] & 255) << 8) + ((long)(e[3] & 255) << 16);
            CRC32 zCrc = new CRC32();
            zCrc.update(e, 4, e.length - 4);
            long crc1 = zCrc.getValue();
            if(crc1 == crc) {
                byte[] bb = dd(e, k, 4, e.length - 4);
                ret = new String(bb, "UTF-8");
            }
        } catch (Exception var10) {
            LOGGER.error("解密异常，" + var10.getMessage(), var10);
        }

        return ret;
    }

    private static String bth(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if(src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v).toLowerCase();
                if(hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    private static byte[] htb(String hexString) {
        if(hexString != null && !hexString.equals("")) {
            hexString = hexString.toUpperCase();
            int length = hexString.length() / 2;
            char[] hexChars = hexString.toCharArray();
            byte[] d = new byte[length];

            for(int i = 0; i < length; ++i) {
                int pos = i * 2;
                d[i] = (byte)(charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
            }

            return d;
        } else {
            return null;
        }
    }

    private static byte charToByte(char c) {
        return (byte)"0123456789ABCDEF".indexOf(c);
    }

    private static byte[] dd(byte[] data, String key, int start, int length) {
        byte[] result = new byte[length];
        byte v = 91;

        try {
            int e = key.length();
            byte[] keyChars = key.getBytes("UTF-8");

            for(int i = 0; i < length; ++i) {
                data[i + start] -= keyChars[i % e];
                data[i + start] ^= v;
            }

            System.arraycopy(data, start, result, 0, length);
        } catch (Exception var9) {
            LOGGER.error("dd方法异常，" + var9.getMessage(), var9);
        }

        return result;
    }

    private static byte[] ed(byte[] data, String key, int start, int length) {
        byte[] result = new byte[length];
        byte v = 91;

        try {
            int e = key.length();
            byte[] keyChars = key.getBytes("UTF-8");

            for(int i = 0; i < length; ++i) {
                data[i + start] ^= v;
                data[i + start] += keyChars[i % e];
            }

            System.arraycopy(data, start, result, 0, length);
        } catch (Exception var9) {
            LOGGER.error("ed方法异常，" + var9.getMessage(), var9);
        }

        return result;
    }

    private static String d2(String s, String k) {
        String ret = "";

        try {
            byte[] e = htb(s);
            long crc = (long)(e[0] & 255) + ((long)(e[1] & 255) << 24) + ((long)(e[2] & 255) << 16) + ((long)(e[3] & 255) << 8);
            CRC32 zCrc = new CRC32();
            zCrc.update(e, 4, e.length - 4);
            long crc1 = zCrc.getValue();
            if(crc1 == crc) {
                byte[] bb = dd2(e, k, 4, e.length - 4);
                ret = new String(bb, "UTF-8");
            }
        } catch (Exception var10) {
            LOGGER.error("d2方法异常，" + var10.getMessage(), var10);
        }

        return ret;
    }

    private static byte[] dd2(byte[] data, String key, int start, int length) {
        byte[] result = new byte[length];
        byte v = 91;

        try {
            int e = key.length();
            byte[] keyChars = key.getBytes("UTF-8");

            for(int i = 0; i < length; ++i) {
                data[i + start] = (byte)(data[i + start] - e);
                data[i + start] -= keyChars[i % e];
                data[i + start] ^= v;
            }

            System.arraycopy(data, start, result, 0, length);
        } catch (Exception var9) {
            LOGGER.error("dd2方法异常，" + var9.getMessage(), var9);
        }

        return result;
    }

    public static void main(String[] args) {
        System.err.println(md5("888888"));
    }

    public static String security(String s, String algorithm, String charset) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] e = charset != null && charset.trim().length() > 0?s.getBytes(charset):s.getBytes(GlobalConstants.DEFAULT_CHARSET_OBJ);
            MessageDigest mdInst = MessageDigest.getInstance(algorithm);
            mdInst.update(e);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for(int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return (new String(str)).toLowerCase();
        } catch (Exception var12) {
            LOGGER.error("security方法异常，" + var12.getMessage(), var12);
            return null;
        }
    }

    public static String md5(String s) {
        return security(s, "MD5", (String)null);
    }
}