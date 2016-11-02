package com.newstar.hbms.system.dao;

import com.newstar.hbms.system.domain.Sequence;

import java.util.List;

/**
 * User: wangjinsi
 * Date: 1/25/13
 * Time: 3:24 PM
 */
public interface SequenceDao {

  int autoIncrease(String sequenceName);

  int increase(String sequenceName, int increment);

  Long getCurrVal(String sequenceName);

  List<Sequence> getAllSequences();

}
