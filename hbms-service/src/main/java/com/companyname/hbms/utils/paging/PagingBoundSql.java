package com.companyname.hbms.utils.paging;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;

import java.util.List;

/**
 * Created by fellowlong on 2014-08-15.
 */
public class PagingBoundSql extends BoundSql {

  public PagingBoundSql(Configuration configuration, String sql, List<ParameterMapping> parameterMappings, Object parameterObject) {
    super(configuration, sql, parameterMappings, parameterObject);
  }

  @Override
  public boolean hasAdditionalParameter(String name) {
    if (name != null && name.equals(PagingPlugin.PAGING_FLAG)) {
      return true;
    } else {
      return super.hasAdditionalParameter(name);
    }
  }

  @Override
  public Object getAdditionalParameter(String name) {
    if (name != null && name.equals(PagingPlugin.PAGING_FLAG)) {
      return null;
    } else {
      return super.getAdditionalParameter(name);
    }
  }
}
