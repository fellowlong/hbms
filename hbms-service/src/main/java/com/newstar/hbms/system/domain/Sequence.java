package com.newstar.hbms.system.domain;

/**
 * Created by wangjinsi on 2015-08-10.
 */
public class Sequence {

  private String seqName;
  private Long currentValue;
  private Long increment;

  public String getSeqName() {
    return seqName;
  }

  public void setSeqName(String seqName) {
    this.seqName = seqName;
  }

  public Long getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(Long currentValue) {
    this.currentValue = currentValue;
  }

  public Long getIncrement() {
    return increment;
  }

  public void setIncrement(Long increment) {
    this.increment = increment;
  }

  @Override
  public String toString() {
    return "Sequence{" +
        "seqName='" + seqName + '\'' +
        ", currentValue=" + currentValue +
        ", increment=" + increment +
        '}';
  }
}
