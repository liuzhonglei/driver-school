package com.drivers.weixin.tool;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xhuji on 2016/11/24.
 */
@Slf4j
public class EmojiTest {
    /**
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     * @param str
     * 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiConvert1(String str)
            throws UnsupportedEncodingException {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch(UnsupportedEncodingException e) {
                log.error("emojiConvert error", e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        log.debug("emojiConvert " + str + " to " + sb.toString()
                + ", len：" + sb.length());
        return sb.toString();
    }


}
