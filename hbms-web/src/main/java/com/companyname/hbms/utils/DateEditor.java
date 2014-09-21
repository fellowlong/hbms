package com.companyname.hbms.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public void setDatePattern(String datePattern) {
    this.dateFormat = new SimpleDateFormat(datePattern);
  }

  @Override

  public String getAsText() {
    return getValue() == null ? "" : dateFormat.format(getValue());
  }

  @Override

  public void setAsText(String text) throws IllegalArgumentException {

    if (text == null || !text.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
      setValue(null);
    } else {
      Date date = null;
      try {
        date = dateFormat.parse(text);
      } catch (ParseException e) {
        throw new IllegalArgumentException("将字符串:[" + text + "]转换成日期出错", e);
      }
      setValue(date);
    }
  }

}