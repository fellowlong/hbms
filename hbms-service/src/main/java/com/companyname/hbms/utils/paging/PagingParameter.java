package com.companyname.hbms.utils.paging;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-12.
 */
public class PagingParameter implements Serializable {

  private int pageSize;

  private int pageNum;

  private Object parameter;

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public Object getParameter() {
    return parameter;
  }

  public void setParameter(Object parameter) {
    this.parameter = parameter;
  }

  public int getStartIndex() {
    return pageNum <= 1 ? 1 : (pageNum - 1) * pageSize + 1;
  }

  public int getEndIndex() {
    return pageNum * pageSize;
  }
}
