package com.newstar.hbms.support.paging;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-12.
 */
public class PagingResult<T> implements Serializable {

  private int pageSize;

  private int pageNum;

  private List<T> records;

  private int recordTotal;

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public List<T> getRecords() {
    return records;
  }

  public void setRecords(List<T> records) {
    this.records = records;
  }

  public int getRecordTotal() {
    return recordTotal;
  }

  public int getPageTotal() {
    return (recordTotal + pageSize - 1) / pageSize;
  }

  public void setRecordTotal(int recordTotal) {
    this.recordTotal = recordTotal;
  }

  public int getStartIndex() {
    return pageNum <= 1 ? 1 : (pageNum - 1) * pageSize + 1;
  }

  public int getEndIndex() {
    return pageNum * pageSize;
  }


  @Override
  public String toString() {
    return "Page{" +
      "pageSize=" + pageSize +
      ", pageNum=" + pageNum +
      ", startIndex=" + getStartIndex() +
      ", endIndex=" + getEndIndex() +
      ", pageTotal=" + getPageTotal() +
      ", recordTotal=" + recordTotal +
      ", records=" + (records == null ? "" : Arrays.toString(records.toArray())) +
      '}';
  }
}
