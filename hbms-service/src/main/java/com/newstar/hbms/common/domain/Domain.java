package com.newstar.hbms.common.domain;

import java.io.Serializable;

/**
 * Created by fellowlong on 2014/10/12.
 */
public class Domain implements Serializable {

  public enum CRUD {
    CREATE,READ,UPDATE,DELETE
  }

  private CRUD crud;

  public CRUD getCrud() {
    return crud;
  }

  public void setCrud(CRUD crud) {
    this.crud = crud;
  }
}
