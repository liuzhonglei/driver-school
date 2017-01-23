package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.pojo.*;
import com.medal.weixin.sdk.util.CommonUtil;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 高级接口工具类
 *
 * Created by xhuji on 2016/10/20.
 */
@Slf4j
public class AdvancedClient {

	/**
	 * 获取网页授权凭证
	 *
	 * @param appId 公众账号的唯一标识
	 * @param appSecret 公众账号的密钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		log.debug("appId:{},appSecret:{},code:{}",appId,appSecret,code);
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// 获取网页授权凭证
		JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 刷新网页授权凭证
	 *
	 * @param appId 公众账号的唯一标识
	 * @param refreshToken
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
		// 刷新网页授权凭证
		JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("刷新网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 通过网页授权获取用户信息
	 *
	 * @param accessToken 网页授权接口调用凭证
	 * @param openId 用户标识
	 * @return SNSUserInfo
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				// 昵称
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// 性别（1是男性，2是女性，0是未知）
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				snsUserInfo.setCity(jsonObject.getString("city"));
				// 用户头像
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// 用户特权信息
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;
	}

//	public static void main(String args[]) {
//		// 获取接口访问凭证
//		String accessToken = TokenClient.getToken("APPID", "APPSECRET").getAccessToken();
//
//		/**
//		 * 发送客服消息（文本消息）
//		 */
//		// 组装文本客服消息
//		String jsonTextMsg = CustomMessageUtil.makeTextCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", "点击查看<a href=\"http://blog.csdn.net/lyq8479\">柳峰的博客</a>");
//		// 发送客服消息
//		sendCustomMessage(accessToken, jsonTextMsg);
//
//		/**
//		 * 发送客服消息（图文消息）
//		 */
//		Article article1 = new Article();
//		article1.setTitle("微信上也能斗地主");
//		article1.setDescription("");
//		article1.setPicUrl("http://www.egouji.com/xiaoq/game/doudizhu_big.png");
//		article1.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Doudizhu/doudizhu.htm");
//		Article article2 = new Article();
//		article2.setTitle("傲气雄鹰\n80后不得不玩的经典游戏");
//		article2.setDescription("");
//		article2.setPicUrl("http://www.egouji.com/xiaoq/game/aoqixiongying.png");
//		article2.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Plane/aoqixiongying.html");
//		List<Article> list = new ArrayList<Article>();
//		list.add(article1);
//		list.add(article2);
//		// 组装图文客服消息
//		String jsonNewsMsg = CustomMessageUtil.makeNewsCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", list);
//		// 发送客服消息
//		sendCustomMessage(accessToken, jsonNewsMsg);
//
//		/**
//		 * 创建临时二维码
//		 */
//		WeixinQRCode weixinQRCode = createTemporaryQRCode(accessToken, 900, 111111);
//		// 临时二维码的ticket
//		System.out.println(weixinQRCode.getTicket());
//		// 临时二维码的有效时间
//		System.out.println(weixinQRCode.getExpireSeconds());
//
//		/**
//		 * 根据ticket换取二维码
//		 */
//		String ticket = "gQEg7zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2lIVVJ3VmJsTzFsQ0ZuQ0Y1bG5WAAIEW35+UgMEAAAAAA==";
//		String savePath = "G:/download";
//		// 根据ticket换取二维码
//		getQRCode(ticket, savePath);
//
//		/**
//		 * 获取用户信息
//		 */
//		WeixinUserInfo user = getUserInfo(accessToken, "oEdzejiHCDqafJbz4WNJtWTMbDcE");
//		System.out.println("OpenID：" + user.getOpenId());
//		System.out.println("关注状态：" + user.getSubscribe());
//		System.out.println("关注时间：" + user.getSubscribeTime());
//		System.out.println("昵称：" + user.getNickname());
//		System.out.println("性别：" + user.getSex());
//		System.out.println("国家：" + user.getCountry());
//		System.out.println("省份：" + user.getProvince());
//		System.out.println("城市：" + user.getCity());
//		System.out.println("语言：" + user.getLanguage());
//		System.out.println("头像：" + user.getHeadImgUrl());
//
//		/**
//		 * 获取关注者列表
//		 */
//		WeixinUserList weixinUserList = getUserList(accessToken, "");
//		System.out.println("总关注用户数：" + weixinUserList.getTotal());
//		System.out.println("本次获取用户数：" + weixinUserList.getCount());
//		System.out.println("OpenID列表：" + weixinUserList.getOpenIdList().toString());
//		System.out.println("next_openid：" + weixinUserList.getNextOpenId());
//
//		/**
//		 * 查询分组
//		 */
//		List<WeixinGroup> groupList = getGroups(accessToken);
//		// 循环输出各分组信息
//		for (WeixinGroup group : groupList) {
//			System.out.println(String.format("ID：%d 名称：%s 用户数：%d", group.getId(), group.getName(), group.getCount()));
//		}
//
//		/**
//		 * 创建分组
//		 */
//		WeixinGroup group = createGroup(accessToken, "公司员工");
//		System.out.println(String.format("成功创建分组：%s id：%d", group.getName(), group.getId()));
//
//		/**
//		 * 修改分组名
//		 */
//		updateGroup(accessToken, 100, "同事");
//
//		/**
//		 * 移动用户分组
//		 */
//		updateMemberGroup(accessToken, "oEdzejiHCDqafJbz4WNJtWTMbDcE", 100);
//
//		/**
//		 * 上传多媒体文件
//		 */
//		WeixinMedia weixinMedia = uploadMedia(accessToken, "voice", "http://localhost:8080/weixinmpapi/test.mp3");
//		System.out.println(weixinMedia.getMediaId());
//		System.out.println(weixinMedia.getType());
//		System.out.println(weixinMedia.getCreatedAt());
//
//		/**
//		 * 下载多媒体文件
//		 */
//		getMedia(accessToken, "N7xWhOGYSLWUMPzVcGnxKFbhXeD_lLT5sXxyxDGEsCzWIB2CcUijSeQOYjWLMpcn", "G:/download");
//	}
}
