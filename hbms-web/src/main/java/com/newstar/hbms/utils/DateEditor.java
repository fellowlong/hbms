package com.newstar.hbms.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateEditor extends PropertyEditorSupport {

  public static Pattern  dayPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
  public static Pattern datePattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$");
  public static Pattern timePattern = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");

  public static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
  public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  public static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

  public DateEditor() {
  }

  public DateEditor(String datePattern) {
    setDatePattern(datePattern);
  }

  public DateEditor(Object source, String datePattern) {
    super(source);
    setDatePattern(datePattern);
  }

  public void setDatePattern(String datePattern) {
    this.dateFormat = new SimpleDateFormat(datePattern);
  }

  @Override

  public String getAsText() {
    return getValue() == null ? "" : dateFormat.format(getValue());
  }

  @Override

  public void setAsText(String text) throws IllegalArgumentException {

    if (text == null || text.isEmpty()) {
      setValue(null);
    } else {
      Date date = null;
      try {
        if (dayPattern.matcher(text).matches()) {
          date = dayFormat.parse(text);
        } else if (datePattern.matcher(text).matches()) {
          date = dateFormat.parse(text);
        } else if (timePattern.matcher(text).matches()) {
          date = timeFormat.parse(text);
        } else {
          throw new IllegalArgumentException("无效的日期格式：" + text);
        }
      } catch (ParseException e) {
        throw new IllegalArgumentException("将字符串:[" + text + "]转换成日期出错", e);
      }
      setValue(date);
    }
  }

}