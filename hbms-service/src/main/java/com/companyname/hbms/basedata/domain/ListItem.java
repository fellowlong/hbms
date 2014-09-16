package com.companyname.hbms.basedata.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-04.
 */
public class ListItem implements Serializable {

  /**
   * 编号，主键
   */
  private Long id;

  /**
   * 值
   */
  private String value;

  /**
   * 类型
   */
  private Long typeId;

  /**
   * 类型
   */
  private ListItem type;

  /**
   * 包含的列表项
   */
  private List<ListItem> items;

  public ListItem() {

  }

  public ListItem(Long id, String value, Long typeId) {
    this.id = id;
    this.value = value;
    this.typeId = typeId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Long getTypeId() {
    return typeId;
  }

  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  public ListItem getType() {
    return type;
  }

  public void setType(ListItem type) {
    this.type = type;
  }

  public List<ListItem> getItems() {
    return items;
  }

  public void setItems(List<ListItem> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "ListItem{" +
      "id=" + id +
      ", value='" + value + '\'' +
      ", typeId=" + typeId +
      '}';
  }
}


