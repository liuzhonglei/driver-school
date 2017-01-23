package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.pojo.WeixinQRCode;
import com.medal.weixin.sdk.util.CommonUtil;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Created by xhuji on 2016/10/21.
 */
@Slf4j
public class QRCodeClient {
    /**
     * 创建临时带参二维码
     *
     * @param accessToken 接口访问凭证
     * @param expireSeconds 二维码有效时间，单位为秒，最大不超过1800
     * @param sceneId 场景ID
     * @return WeixinQRCode
     */
    public static WeixinQRCode createTemporaryQRCode(String accessToken, int expireSeconds, int sceneId) {
        WeixinQRCode weixinQRCode = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 需要提交的json数据
        String jsonMsg = "{\"expire_seconds\": %d, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}";
        // 创建临时带参二维码
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", String.format(jsonMsg, expireSeconds, sceneId));

        if (null != jsonObject) {
            try {
                weixinQRCode = new WeixinQRCode();
                weixinQRCode.setTicket(jsonObject.getString("ticket"));
                weixinQRCode.setExpireSeconds(jsonObject.getInt("expire_seconds"));
                log.info("创建临时带参二维码成功 ticket:{} expire_seconds:{}", weixinQRCode.getTicket(), weixinQRCode.getExpireSeconds());
            } catch (Exception e) {
                weixinQRCode = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("创建临时带参二维码失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return weixinQRCode;
    }

    /**
     * 创建永久带参二维码
     *
     * @param accessToken 接口访问凭证
     * @param sceneId 场景ID
     * @return ticket
     */
    public static String createPermanentQRCode(String accessToken, int sceneId) {
        String ticket = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 需要提交的json数据
        String jsonMsg = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}";
        // 创建永久带参二维码
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", String.format(jsonMsg, sceneId));

        if (null != jsonObject) {
            try {
                ticket = jsonObject.getString("ticket");
                log.info("创建永久带参二维码成功 ticket:{}", ticket);
            } catch (Exception e) {
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("创建永久带参二维码失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return ticket;
    }

    /**
     * 根据ticket换取二维码
     *
     * @param ticket 二维码ticket
     * @param savePath 保存路径
     */
    public static String getQRCode(String ticket, String savePath) {
        String filePath = null;
        // 拼接请求地址
        String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
        requestUrl = requestUrl.replace("TICKET", CommonUtil.urlEncodeUTF8(ticket));
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            if (!savePath.endsWith("/")) {
                savePath += "/";
            }
            // 将ticket作为文件名
            filePath = savePath + ticket + ".jpg";

            // 将微信服务器返回的输入流写入文件
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.close();
            bis.close();

            conn.disconnect();
            log.info("根据ticket换取二维码成功，filePath=" + filePath);
        } catch (Exception e) {
            filePath = null;
            log.error("根据ticket换取二维码失败：{}", e);
        }
        return filePath;
    }

}
