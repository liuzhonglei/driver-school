package com.drivers.weixin.util;

/**
 * Created by xhuji on 2016/10/13.
 */
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medal.common.utils.StringUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public static <T> T toObj(String jsonStr, Class<T> clazz) throws IOException, JsonParseException, JsonMappingException {
        return mapper.readValue(jsonStr, clazz);
    }

    public static <T> List<T> toObjList(String jsonStr, TypeReference<List<T>> typeReference) throws IOException, JsonParseException, JsonMappingException {
        return (List)mapper.readValue(jsonStr, typeReference);
    }

    public static String toForamtJson(Object obj) throws JsonProcessingException {
        String json = toJson(obj);
        return StringUtil.isNotBlank(json)?format(json):json;
    }

    public static String format(String jsonStr) {
        int level = 0;
        StringBuilder jsonForMatStr = new StringBuilder();

        for(int i = 0; i < jsonStr.length(); ++i) {
            char c = jsonStr.charAt(i);
            if(level > 0 && 10 == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }

            switch(c) {
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '[':
                case '{':
                    jsonForMatStr.append(c + "\n");
                    ++level;
                    break;
                case ']':
                case '}':
                    jsonForMatStr.append("\n");
                    --level;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
            }
        }

        return jsonForMatStr.toString();
    }

    private static String getLevelStr(int level) {
        StringBuilder levelStr = new StringBuilder();

        for(int levelI = 0; levelI < level; ++levelI) {
            levelStr.append("\t");
        }

        return levelStr.toString();
    }

    public static void main(String[] args) throws Exception {
        String rs = "{\"trade\":[{\"age\":30}],\"tradeItem\":[{\"name\":\"fw\"}]}";
        Map m = (Map)toObj(rs, Map.class);
        System.err.println(m);
        System.err.println(m.keySet());
        System.err.println(m.values());
    }

    public static class Name {
        String name;

        public Name() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
