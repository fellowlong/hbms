package com.companyname.hbms.visit.service.impl;

import com.companyname.hbms.visit.dao.VisitDao;
import com.companyname.hbms.visit.domain.Visit;
import com.companyname.hbms.visit.service.VisitService;

/**
 * Created by fellowlong on 2014-07-28.
 */
public class VisitServiceImpl implements VisitService {

  private VisitDao visitDao;

  public void setVisitDao(VisitDao visitDao) {
    this.visitDao = visitDao;
  }

  @Override
  public int insert(Visit visit) {
    return visitDao.insert(visit);
  }

  @Override
  public int delete(Long visitId) {
    return visitDao.delete(visitId);
  }

  @Override
  public int update(Visit visit) {
    return visitDao.update(visit);
  }

  @Override
  public int findByBean(Visit visit) {
    return visitDao.findByBean(visit);
  }
}
