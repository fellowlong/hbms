package com.newstar.hbms.support.paging;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

import java.util.List;

/**
 * Created by fellowlong on 2014-08-15.
 */
public class PagingSqlSource implements SqlSource {

  private String sql;
  private List<ParameterMapping> parameterMappings;
  private Configuration configuration;

  public PagingSqlSource(Configuration configuration, String sql) {
    this(configuration, sql, null);
  }

  public PagingSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
    this.sql = sql;
    this.parameterMappings = parameterMappings;
    this.configuration = configuration;
  }
  @Override
  public BoundSql getBoundSql(Object parameterObject) {
    return new PagingBoundSql(configuration, sql, parameterMappings, parameterObject);
  }
}
