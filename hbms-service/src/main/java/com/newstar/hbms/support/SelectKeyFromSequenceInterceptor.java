package com.newstar.hbms.support;

import com.newstar.hbms.common.service.SequenceService;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * Created by wangjinsi on 2015-08-28.
 */
@Intercepts(
    {@Signature(type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})}
)
public class SelectKeyFromSequenceInterceptor implements Interceptor {

  private String sequencePrefix = "sequence";

  private SequenceService sequenceService;

  public void setSequencePrefix(String sequencePrefix) {
    this.sequencePrefix = sequencePrefix;
  }

  public void setSequenceService(SequenceService sequenceService) {
    this.sequenceService = sequenceService;
  }

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object result = null;
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    if (mappedStatement.getId().endsWith(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
      Object parameter = invocation.getArgs()[1];
      BoundSql boundSql = mappedStatement.getBoundSql(parameter);
      if (boundSql != null
          && boundSql.getSql() != null
          && boundSql.getSql().toLowerCase().startsWith(sequencePrefix.toLowerCase())) {
        String sequenceName = boundSql.getSql().substring(sequencePrefix.length() + 1);
        if (sequenceName != null && !sequenceName.isEmpty()) {
          Long id = sequenceService.getNextVal(sequenceName);
          if (id != null) {
            result = Arrays.asList(new Long[]{id});
          }
        }
      } else {
        result = invocation.proceed();
      }
    } else {
       result = invocation.proceed();
    }
    return result;
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {

  }
}
