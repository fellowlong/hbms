package com.newstar.hbms.system.service;

/**
 * Created by fellowlong on 2015-01-26.
 */
public interface SequenceService {

  Long getNextVal(String sequenceName);

  Long[] getBatchNextVal(String sequenceName, int count);

}
