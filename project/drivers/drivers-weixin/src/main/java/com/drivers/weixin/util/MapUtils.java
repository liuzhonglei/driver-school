package com.drivers.weixin.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/4 下午4:19
 */
@Slf4j
public class MapUtils {

    public static TreeMap<String, Object> map2ObjectTreeMap(Map<String, String> map) {
        TreeMap<String,Object> treeMap = new TreeMap<>();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            treeMap.put(entry.getKey(),entry.getValue());
        }
        return treeMap;
    }

    public static TreeMap<String, String> map2StringTreeMap(Map<String, Object> map) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            treeMap.put(entry.getKey(),String.valueOf(entry.getValue()));
        }
        return treeMap;
    }

    public static Map<String, String> toStringTreeMap(Object obj) {
        Map<String,Object> newMap = toMap(obj,new TreeMap<String,Object>(),true);
        Map<String,String> treeMap = new TreeMap<>();
        for (Map.Entry<String,Object> entry : newMap.entrySet()) {
            treeMap.put(entry.getKey(),String.valueOf(entry.getValue()));
        }
        return treeMap;
    }

    public static Map<String, Object> toMap(Object obj,Map<String,Object> map,boolean isFilterNull) {
        if(obj == null) {
            return null;
        } else {
            try {
                BeanInfo e = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = e.getPropertyDescriptors();
                PropertyDescriptor[] var4 = propertyDescriptors;
                int var5 = propertyDescriptors.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    PropertyDescriptor property = var4[var6];
                    String key = property.getName();
                    if(!key.equals("class")) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj, new Object[0]);
                        if(isFilterNull && value == null){
                            continue;
                        }
                        map.put(key, value);
                    }
                }
            } catch (Exception var11) {
                System.out.println("transBean2Map Error " + var11);
            }
            return map;
        }
    }

    /**
     * 将TreeMap中所有参数按升序转换成字符串，格式：key1=value1&key2=value2
     *
     * @param map
     * @return
     */
    public static String treeMap2ascString(TreeMap<String, Object> map) {
        return treeMap2ascString(map, null);
    }
    /**
     * 将TreeMap中所有参数按升序转换成字符串，格式：key1=value1&key2=value2
     *
     * @param map
     * @param charset 编码，为空则不编码
     * @return
     */
    public static String treeMap2ascString(TreeMap<String, Object> map, String charset) {
        return treeMap2ascString(map, charset, '&');
    }
    /**
     * 将TreeMap中所有参数按升序转换成字符串
     * @param map
     * @param charset 编码，为空则不编码
     * @param link 连接符
     * @return
     */
    public static String treeMap2ascString(TreeMap<String, Object> map, String charset,Character link) {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Object> entry = iter.next();
                String value="";
                if (entry.getValue()!=null) {
                    value=entry.getValue().toString();
                }
                sb.append(entry.getKey() + "=" + (StringUtils.isNotBlank(charset) ? URLEncoder.encode(value, charset) : value) + (link!=null?link:""));
            }
            if(link!=null){
                sb = sb.length() > 0 && sb.charAt(sb.length() - 1) == link ? sb.deleteCharAt(sb.length() - 1) : sb;
            }
        } catch (Exception e) {
            log.error("map2String error", e);
        }
        return sb.toString();
    }

    public static <T>T mapToObject(Map<String, Object> map, Class<T> beanClass) {
        if (map == null){
            return null;
        }
        T obj = null;
        try {
            obj = beanClass.newInstance();
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
