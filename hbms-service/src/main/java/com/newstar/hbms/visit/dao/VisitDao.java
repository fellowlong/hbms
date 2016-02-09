package com.newstar.hbms.visit.dao;

import com.newstar.hbms.visit.domain.Visit;

/**
 * Created by fellowlong on 14-6-5.
 */
public interface VisitDao {

  public int insert(Visit visit);

  public int delete(Long visitId);

  public int update(Visit visit);

  public int findByBean(Visit visit);

}
