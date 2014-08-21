package com.companyname.hbms.mvc;

import org.springframework.context.MessageSource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 消息容器
 */
public class MessageCollector {

  private MessageSource messageSource;

  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  /**
   * 普通消息
   */
  private Map<String, Object> infos = new HashMap<String, Object>(0);

  /**
   * 警告消息
   */
  private Map<String, Object> warnings = new HashMap<String, Object>(0);

  /**
   * 错误消息
   */
  private Map<String, Object> errors = new HashMap<String, Object>(0);

  public void addInfo(String name, String messageKey, Object[] parameters, Locale locale) {
    String message = this.messageSource.getMessage(messageKey, parameters, locale);
    this.infos.put(name, message);
  }

  public void addInfo(String name, Object message) {
    this.infos.put(name, message);
  }

  public void addInfoAll(Map<String, Object> infoMap) {
    this.infos.putAll(infoMap);
  }

  public void addError(String name, String messageKey, Object[] parameters, Locale locale) {
    String message = this.messageSource.getMessage(messageKey, parameters, locale);
    this.errors.put(name, message);
  }

  public void addError(String name, Object message) {
    this.errors.put(name, message);
  }

  public void addErrorAll(Map<String, Object> errorMap) {
    this.errors.putAll(errorMap);
  }

  public void addWarning(String name, String messageKey, Object[] parameters, Locale locale) {
    String message = this.messageSource.getMessage(messageKey, parameters, locale);
    this.warnings.put(name, message);
  }

  public void addWarning(String name, Object message) {
    this.warnings.put(name, message);
  }

  public void addWarningAll(Map<String, Object> warningMap) {
    this.warnings.putAll(warningMap);
  }

  public Map<String, Object> getInfos() {
    return infos;
  }

  public Map<String, Object> getWarnings() {
    return warnings;
  }

  public Map<String, Object> getErrors() {
    return errors;
  }

  public Map<String, Object> getAll() {
    Map<String, Object> messages = new HashMap<String, Object>();
    messages.putAll(infos);
    messages.putAll(warnings);
    messages.putAll(errors);
    return messages;
  }

  public void clear() {
    this.infos.clear();
    this.warnings.clear();
    this.errors.clear();
  }

}
