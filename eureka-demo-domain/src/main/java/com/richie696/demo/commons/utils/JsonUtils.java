package com.richie696.demo.commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 工具类：JSON转换/序列化工具类
 * @author richie696
 * @version 1.2
 * @since 2017-9-22
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    }

    /**
     * 序列化对象为JSON字符串的方法
     * @param value 待序列化的对象
     * @param prettyPrinter 输出美化后的JSON字符串
     * @return 返回JSON字符串（如果对象转换错误将返回""字符串）
     */
    public static String serialize(Object value, boolean ...prettyPrinter) {
        try {
            if (prettyPrinter != null && prettyPrinter.length > 0 && prettyPrinter[0]) {
                return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(value);
            }
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    /**
     * 反序列化JSON字符串的方法
     * @param content JSON字符串
     * @param valueType 反序列化字符串的类型
     * @param <T> JSON字符串对应的实体类型
     * @return 返回反序列化后的结果
     */
    public static <T> T unserialize(String content, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
