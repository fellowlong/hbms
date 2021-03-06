package com.newstar.hbms.support.paging;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014-08-12.
 */
public class PageRange implements Serializable {

  private int pageSize = 10;

  private int pageNum = 1;

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
