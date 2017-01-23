package com.drivers.weixin.util;

/**
 * Created by xhuji on 2016/10/12.
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public final class Utils {
    private static NumberFormat format = new DecimalFormat("0.00");
    public static final String SyncSqlTemplate = "and ( %s > FROM_UNIXTIME(%s) or ( %s = FROM_UNIXTIME(%s) and %s>%d ))";

    private Utils() {
    }

    public static boolean isNotNull(Object... args) {
        Object[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Object arg = var1[var3];
            if(arg == null) {
                return false;
            }
        }

        return true;
    }

    public static String numberFormat(Object source) {
        return format.format(source);
    }

    public static String numberFormat(Object source, String pattern) {
        return (new DecimalFormat(pattern)).format(source);
    }

    public static String getPkid() {
        String strTimes = "" + System.currentTimeMillis();
        Random r = new Random();
        String strNum = "" + r.nextInt();
        if(strNum != null && strNum.indexOf("-") != -1) {
            strNum = strNum.replace("-", "");
        }

        return strTimes + strNum;
    }

    public static boolean isMobile(String mobile) {
        String pattern = "(^((\\+86)|(86))?(1)\\d{10}$)|(^((\\+886)|(886))?(09)\\d{8}$)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    public static String getString(String value) {
        return value != null && !value.equals("") && !"null".equals(value) && !"Null".equals(value) && !"unknown".equals(value) && !"Unknow".equals(value)?value:"";
    }

    public static String getCouponsNumber() {
        Calendar c = Calendar.getInstance();
        int month = c.get(2);
        int date = c.get(5);
        String strDate = new String(date + "");
        if(date < 10) {
            strDate = "0" + date;
        }

        int randomNum = (int)(Math.random() * 9000.0D + 1000.0D);
        return month + strDate + randomNum;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

    public static String handleIntParam(String str) {
        return !StringUtils.isBlank(str) && !"null".equalsIgnoreCase(str)?str.replaceAll("\'", ""):null;
    }

    public static String openUri(String uri, Map<String, String> header) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(3000));
        httpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(5000));
        HttpPost httpGet = new HttpPost(uri);
        Iterator it = header.keySet().iterator();

        while(it.hasNext()) {
            String httpResponse = (String)it.next();
            httpGet.addHeader(httpResponse, (String)header.get(httpResponse));
        }

        HttpResponse httpResponse1 = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse1.getEntity());
    }

    public static String openUri(String uri, Map<String, String> header, Integer connectionTimeout, Integer soTimeout) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(connectionTimeout.intValue() * 1000));
        httpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(soTimeout.intValue() * 1000));
        HttpPost httpGet = new HttpPost(uri);
        Iterator it = header.keySet().iterator();

        while(it.hasNext()) {
            String httpResponse = (String)it.next();
            httpGet.addHeader(httpResponse, (String)header.get(httpResponse));
        }

        HttpResponse httpResponse1 = httpClient.execute(httpGet);
        return EntityUtils.toString(httpResponse1.getEntity());
    }

    public static String httpPost(String uri, Map<String, Object> params) throws IOException {
        Form form = Form.form();
        Iterator var3 = params.entrySet().iterator();

        while(var3.hasNext()) {
            Entry entry = (Entry)var3.next();
            if(entry.getValue() != null) {
                form.add((String)entry.getKey(), entry.getValue().toString());
            }
        }

        return Request.Post(uri).bodyForm(form.build()).execute().returnContent().asString();
    }

    public static String getSign(String orderType, String orderId, String type, String reason, String key) {
        return getSign(orderType, orderId, type, reason, key, (String)null);
    }

    public static String getSign(String orderType, String orderId, String type, String reason, String key, String isSync) {
        TreeMap templateMap = new TreeMap();
        if(StringUtils.isNotBlank(orderType)) {
            templateMap.put("orderType", orderType);
        }

        if(StringUtils.isNotBlank(orderId)) {
            templateMap.put("orderId", orderId);
        }

        if(StringUtils.isNotBlank(type)) {
            templateMap.put("type", type);
        }

        if(StringUtils.isNotBlank(reason)) {
            templateMap.put("reason", reason);
        }

        if(StringUtils.isNotBlank(isSync)) {
            templateMap.put("isSync", isSync);
        }

        StringBuilder templateParam = new StringBuilder();
        Iterator template = templateMap.entrySet().iterator();

        while(template.hasNext()) {
            Entry e = (Entry)template.next();
            templateParam.append((String)e.getKey() + "=" + (String)e.getValue() + "&");
        }

        templateParam = templateParam.length() > 0 && templateParam.charAt(templateParam.length() - 1) == 38?templateParam.deleteCharAt(templateParam.length() - 1):templateParam;
        String template1 = templateParam.toString() + "&key=" + key;
        return SecurityUtils.md5(template1).toUpperCase();
    }

    public static String refundSign(String orderType, long orderId, Long userId, String key) {
        TreeMap templateMap = new TreeMap();
        templateMap.put("orderId", String.valueOf(orderId));
        templateMap.put("orderType", orderType);
        templateMap.put("userId", String.valueOf(userId));
        StringBuilder templateParam = new StringBuilder();
        Iterator template = templateMap.entrySet().iterator();

        while(template.hasNext()) {
            Entry e = (Entry)template.next();
            templateParam.append((String)e.getKey() + "=" + (String)e.getValue() + "&");
        }

        String template1 = templateParam.toString() + "key=" + key;
        return SecurityUtils.md5(template1);
    }

    public static String queryString(SortedMap<String, Object> params, String key) {
        return queryString(params, key, false);
    }

    public static String queryString(SortedMap<String, Object> params, String key, boolean isEcoding) {
        return queryString(params, "key", key, isEcoding);
    }

    public static String queryString(SortedMap<String, Object> params) {
        return queryString(params, (String)null, "", false);
    }

    public static String queryString(SortedMap<String, Object> params, String keyName, String keyValue, boolean isEcoding) {
        StringBuilder templateParam = new StringBuilder();
        int i = 0;
        int size = params.size();
        String charset = "UTF-8";
        Iterator var9 = params.entrySet().iterator();

        while(true) {
            do {
                if(!var9.hasNext()) {
                    if(StringUtils.isNotBlank(keyValue)) {
                        templateParam.append(keyName).append("=").append(keyValue);
                    }

                    return templateParam.toString();
                }

                Entry e = (Entry)var9.next();
                ++i;
                String name = (String)e.getKey();
                Object obj = e.getValue();
                String value;
                if(null == obj) {
                    value = "";
                } else {
                    value = "" + obj;
                }

                if(isEcoding) {
                    name = encode(name, charset);
                    value = encode(value, charset);
                }

                templateParam.append(name).append("=").append(value);
            } while(i >= size && StringUtils.isBlank(keyValue));

            templateParam.append("&");
        }
    }

    public static String toCh5QueryString(SortedMap<String, Object> params, String key) {
        String queryString = queryString(params, "token", key, false);
        String sign = getSign(queryString);
        params.put("sign", sign);
        return queryString(params, (String)null, true);
    }

    public static Map<String, Object> toCh5(SortedMap<String, Object> params, String key) {
        String queryString = queryString(params, "token", key, false);
        String sign = getSign(queryString);
        params.put("sign", sign);
        return params;
    }

    public static Map<String, Object> toCh5(Map<String, Object> params, String key) {
        TreeMap sortedParams = new TreeMap(params);
        return toCh5((SortedMap)sortedParams, key);
    }

    public static String toCh5QueryString(Map<String, Object> params, String key) {
        TreeMap sortedParams = new TreeMap(params);
        return toCh5QueryString((SortedMap)sortedParams, key);
    }

    private static String encode(String content, String charset) {
        if(content == null) {
            return null;
        } else {
            try {
                return URLEncoder.encode(content, charset != null?charset:HTTP.DEF_CONTENT_CHARSET.name());
            } catch (UnsupportedEncodingException var3) {
                throw new IllegalArgumentException(var3);
            }
        }
    }

    public static String sign4CH5New(int vender, String platform, String deviceId, String version, String content, String key, long timestamp) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("vender", Integer.valueOf(vender));
        treeMap.put("platform", platform);
        treeMap.put("device_id", deviceId);
        treeMap.put("version", version);
        treeMap.put("timestamp", Long.valueOf(timestamp));
        treeMap.put("content", content);
        StringBuilder sb = new StringBuilder();
        Iterator iter = treeMap.entrySet().iterator();

        while(iter.hasNext()) {
            Entry entry = (Entry)iter.next();
            sb.append((String)entry.getKey() + "=" + entry.getValue() + '&');
        }

        sb = sb.length() > 0 && sb.charAt(sb.length() - 1) == 38?sb.deleteCharAt(sb.length() - 1):sb;
        return SecurityUtils.md5(String.format("%s&key=%s", new Object[]{sb.toString(), key})).toLowerCase();
    }

    public static String getSign(String queryString) {
        return SecurityUtils.md5(queryString);
    }

    public static String buildModifyDatetimeSql(String field, String param) {
        if(10 < param.length() && -1 == param.lastIndexOf(46)) {
            param = param.substring(0, 10) + "." + param.substring(10);
        }

        return "  and " + field + " > FROM_UNIXTIME(" + param + ")";
    }

    public static String buildSyncSql(String field, String param, String idField, Long lastId) {
        if(10 < param.length() && -1 == param.lastIndexOf(46)) {
            param = param.substring(0, 10) + "." + param.substring(10);
        }

        return String.format("and ( %s > FROM_UNIXTIME(%s) or ( %s = FROM_UNIXTIME(%s) and %s>%d ))", new Object[]{field, param, field, param, idField, lastId});
    }
}