package com.newstar.hbms.system.service.impl;

import com.newstar.hbms.system.dao.SequenceDao;
import com.newstar.hbms.system.service.SequenceService;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fellowlong on 2015-01-26.
 */
public class DbSequenceServiceImpl implements SequenceService {

  private Logger logger = Logger.getLogger(getClass());

  private int shardSize;

  private int batchMaxSize = 500;

  private SequenceDao sequenceDao;

  public void setSequenceDao(SequenceDao sequenceDao) {
    this.sequenceDao = sequenceDao;
  }

  @Transactional(rollbackFor = Throwable.class)
  public Long getNextVal(String sequenceName) {
    Long val = null;
    int changeCount = sequenceDao.autoIncrease(sequenceName);
    if (changeCount == 1) {
      val =  sequenceDao.getCurrVal(sequenceName);
    }
    return val;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public Long[] getBatchNextVal(String sequenceName, int count) {
    if (count > batchMaxSize) {
      logger.error("请求ID数量：" + count + "，超过了最大限制："
          + batchMaxSize + "，自动设置成：" + batchMaxSize);
      count = batchMaxSize;
    }
    int increment = shardSize * count;
    int changeCount = sequenceDao.increase(sequenceName, increment);
    Long lastVal = null;
    if (changeCount > 0) {
      lastVal = sequenceDao.getCurrVal(sequenceName);
    }
    Long[] batchVal = null;
    if (lastVal != null) {
      batchVal = new Long[count];
      for (int i = count - 1,j=0; i >= 0; i--,j++) {
        batchVal[j] = lastVal - shardSize * i;
      }
    }
    return batchVal;
  }

  public void setShardSize(int shardSize) {
    this.shardSize = shardSize;
  }

  public void setBatchMaxSize(int batchMaxSize) {
    this.batchMaxSize = batchMaxSize;
  }
}
