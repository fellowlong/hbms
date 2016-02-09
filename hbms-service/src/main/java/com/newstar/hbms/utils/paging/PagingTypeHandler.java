package com.newstar.hbms.utils.paging;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by fellowlong on 2014-08-15.
 */
public class PagingTypeHandler extends IntegerTypeHandler {

  public PagingTypeHandler(){}

  private Integer index;

  public PagingTypeHandler(Integer index) {
    this.index = index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  @Override
  public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
    super.setParameter(ps, i, index, JdbcType.INTEGER);
  }
}
