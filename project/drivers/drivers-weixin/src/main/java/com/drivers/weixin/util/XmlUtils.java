package com.drivers.weixin.util;

import com.medal.common.utils.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/19 下午3:11
 */
@Slf4j
public class XmlUtils {

    public static String object2Xml(Object obj){
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xStream.processAnnotations(obj.getClass());
        StringWriter sw = new StringWriter();
        xStream.marshal(obj, new CompactWriter(sw));
        String xml = StringUtil.replace(sw.toString(),"__","_");
        return xml;
    }

    public static <T>T xml2Object(String xml,Class<T> clazz){
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xStream.processAnnotations(clazz);
        return clazz.cast(xStream.fromXML(xml));
    }

    /** <一句话功能简述>
     * <功能详细描述>request转字符串
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String parseRequst(HttpServletRequest request){
        String body = "";
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(true){
                String info = br.readLine();
                if(info == null){
                    break;
                }
                if(body == null || "".equals(body)){
                    body = info;
                }else{
                    body += info;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    /**
     * 转XMLmap
     * @author
     * @param xmlBytes
     * @param charset
     * @return
     * @throws Exception
     */
    public static Map<String, String> toMap(byte[] xmlBytes, String charset) throws Exception{
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
        source.setEncoding(charset);
        Document doc = reader.read(source);
        Map<String, String> params = XmlUtils.toMap(doc.getRootElement());
        return params;
    }

    /**
     * 转MAP
     * @author
     * @param element
     * @return
     */
    public static Map<String, String> toMap(Element element){
        Map<String, String> rest = new HashMap<String, String>();
        List<Element> els = element.elements();
        for(Element el : els){
            rest.put(el.getName().toLowerCase(), el.getTextTrim());
        }
        return rest;
    }

    /**
     * Collect post form data
     * @param req
     * @return
     */
    public static Map<String, Object> parseXStream2Map(Object obj){
        Map<String, Object> paramMap = new HashMap<>();
        List<Field> fieldList = new ArrayList<Field>();
        allClassFields(fieldList, obj.getClass());
        for(Field field: fieldList) {
            field.setAccessible(true);
            try {
                if (field.get(obj) != null) {
                    XStreamAlias xStreamAlias = field.getAnnotation(XStreamAlias.class);

                    if (xStreamAlias!=null) {
                        paramMap.put(xStreamAlias.value(), field.get(obj));
                    }
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(),e);
            }
        }
        return paramMap;
    }


    /**
     * Get all fields including inherited from super class
     * @param fieldList
     * @param clazz
     */
    @SuppressWarnings("rawtypes")
    public static void allClassFields(List<Field> fieldList, Class clazz) {
        if (clazz == null) {
            return;
        } else if (clazz.getSuperclass() != null){
            allClassFields(fieldList, clazz.getSuperclass());
        }
        fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
    }
}
