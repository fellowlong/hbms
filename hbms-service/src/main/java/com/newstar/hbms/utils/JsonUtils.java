package com.newstar.hbms.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.newstar.hbms.basedata.domain.TreeNode;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.ValueNode;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: fellowlong
 * Date: 7/18/12
 * Time: 1:58 PM
 */
public abstract class JsonUtils {

  public static final String defaultDatePattern = "yyyy-MM-dd HH:mm:ss.SSS";

  private static ObjectMapper objectMapper = null;

  static {
    objectMapper = new ObjectMapper();
    //序列化对象时：空对象不会出现在json中
    objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    //反序列化时：忽略未知属性（默认为true，会抛出异常）
    objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.configure(SerializationConfig.Feature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    objectMapper.getSerializationConfig().setDateFormat(dateFormat);
    objectMapper.getDeserializationConfig().setDateFormat(dateFormat);


    SerializeConfig.getGlobalInstance().config(Object.class, SerializerFeature.IgnoreNonFieldGetter, true);
    SerializeConfig.getGlobalInstance().config(Object.class, SerializerFeature.IgnoreErrorGetter, true);
    SerializeConfig.getGlobalInstance().put(Date.class, new SimpleDateFormatSerializer(defaultDatePattern));

  }

  /**
   * 在JSON格式的字符串中获取值，支持路径、数组
   *
   * @param jsonContent
   * @param name
   * @return
   */
  public static String searchValue(String jsonContent, String name) {
    try {
      return searchValue(objectMapper.readTree(jsonContent), name);
    } catch (IOException e) {
      throw new RuntimeException("解析JSON串异常,", e);
    }
  }

  private static String searchValue(JsonNode jsonNode, String name) {
    if (jsonNode == null) {
      return null;
    }
    if (jsonNode instanceof ValueNode) {
      return  jsonNode.asText();
    } else if (jsonNode instanceof ArrayNode) {
      ArrayNode arrayNode = (ArrayNode) jsonNode;
      for (JsonNode node : arrayNode) {
        return searchValue(node, name);
      }
    } else if (jsonNode instanceof ObjectNode) {
      String currentName = name;
      String subName = null;
      if (name.indexOf(".") > -1) {
        currentName = currentName.substring(0, name.indexOf("."));
        subName = name.substring(currentName.length() + 1);
      }
      return searchValue(jsonNode.get(currentName), subName);
    }
    return null;
  }

  /**
   * 将JavaBean实例转换成JSON格式的字符串
   *
   * @param object
   * @return
   */
  public static String beanToJson(Object object, String...datePattern) {
    if (object == null) {
      return null;
    }
    /*//保存原值
    DateFormat oldDateFormat = objectMapper.getSerializationConfig().getDateFormat();
    if (datePattern != null && datePattern.length == 1 && datePattern[0] != null) {
      SimpleDateFormat customerFormat = new SimpleDateFormat(datePattern[0]);
      objectMapper.getSerializationConfig().setDateFormat(customerFormat);
    }
    String returnResult = null;
    try {
      returnResult = objectMapper.writeValueAsString(object);
    } catch (IOException e) {
      throw new RuntimeException(
              "将对象[" + object.getClass().getName() + "]转换成JSON串异常,", e);
    }
    //恢复原值
    objectMapper.getSerializationConfig().setDateFormat(oldDateFormat);

    SerializeConfig.getGlobalInstance().addFilter(TreeNode.class, new PropertyFilter() {
      @Override
      public boolean apply(Object object, String name, Object value) {
        return name.equals("children") ? false : true;
      }

    });*/
    String finalDatePattern = defaultDatePattern;
    if (datePattern != null && datePattern.length == 1 && datePattern[0] != null) {
      finalDatePattern = datePattern[0];
    }
    return JSON.toJSONStringWithDateFormat(object, finalDatePattern);
  }

  /**
   * json字符串转换成Array
   *
   * @param jsonContent
   * @param clazz
   * @return
   */
  public static <T extends Object> T jsonToBean(String jsonContent, Class<T> clazz, String...datePattern) {
    //保存原值
    DateFormat oldDateFormat = objectMapper.getDeserializationConfig().getDateFormat();
    if (datePattern != null && datePattern.length == 1) {
      SimpleDateFormat customerFormat = new SimpleDateFormat(datePattern[0]);
      objectMapper.getDeserializationConfig().setDateFormat(customerFormat);
    }
    T returnResult = null;
    try {
      returnResult = objectMapper.readValue(jsonContent, clazz);
    } catch (IOException e) {
      throw new RuntimeException("JSON转换成Bean异常", e);
    }
    //恢复原值
    objectMapper.getDeserializationConfig().setDateFormat(oldDateFormat);
    return returnResult;
  }

}
