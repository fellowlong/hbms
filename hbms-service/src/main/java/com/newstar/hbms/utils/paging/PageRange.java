package com.newstar.hbms.utils.paging;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-12.
 */
public class PageRange implements Serializable {

  private int pageSize;

  private int pageNum;

  public PageRange(){}

  public PageRange(int pageNum, int pageSize) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
  }


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

  public int getStartIndex() {
    return pageNum <= 1 ? 1 : (pageNum - 1) * pageSize + 1;
  }

  public int getEndIndex() {
    return pageNum * pageSize;
  }
}
