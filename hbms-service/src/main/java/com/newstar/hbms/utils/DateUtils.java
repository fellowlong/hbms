package com.newstar.hbms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fellowlong on 2014-09-29.
 */
public abstract class DateUtils {


  private static Map<String, SimpleDateFormat> datePatterns = new ConcurrentHashMap<String, SimpleDateFormat>(){
    @Override
    public SimpleDateFormat get(Object key) {
      SimpleDateFormat dateFormat = super.get(key);
      if (dateFormat == null) {
        dateFormat = new SimpleDateFormat(key.toString());
        SimpleDateFormat oldDateFormat = putIfAbsent(key.toString(), dateFormat);
        if (oldDateFormat != null) {
          dateFormat = oldDateFormat;
        }
      }
      return dateFormat;
    }
  };

  public static String dateFormat(Date date, String datePattern) {
    try {
      return datePatterns.get(datePattern).format(date);
    } catch (Exception e) {
      throw new RuntimeException("日期格式化失败：[" + date + "] > [" + datePattern + "]", e);
    }
  }

  public static Date dateFormat(String date, String datePattern) {
    try {
      return datePatterns.get(datePattern).parse(date);
    } catch (ParseException e) {
      throw new RuntimeException("日期格式解析失败：[" + date + "] > [" + datePattern + "]");
    }
  }
}
