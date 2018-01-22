package com.newstar.hbms.mvc;

import java.io.Serializable;

/**
 * Created by fellowlong on 2016/3/2.
 */
public class JsonResult implements Serializable {

  private boolean success = false;

  private Object data;

  private String errorMessage;

  private String successMessage;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getSuccessMessage() {
    return successMessage;
  }

  public void setSuccessMessage(String successMessage) {
    this.successMessage = successMessage;
  }

  @Override
  public String toString() {
    return "JsonResult{" +
        "success=" + success +
        ", data=" + data +
        ", errorMessage='" + errorMessage + '\'' +
        ", successMessage='" + successMessage + '\'' +
        '}';
  }
}
