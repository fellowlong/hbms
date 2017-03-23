package com.newstar.hbms.search.service.impl;

import com.newstar.hbms.search.dao.TempCandidateDao;
import com.newstar.hbms.search.domain.TempCandidate;
import com.newstar.hbms.search.service.TempCandidateService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-07-28.
 */
public class TempCandidateServiceImpl implements TempCandidateService {

  private TempCandidateDao tempCandidateDao;

  public void setTempCandidateDao(TempCandidateDao tempCandidateDao) {
    this.tempCandidateDao = tempCandidateDao;
  }

  @Override
  public int insertOrUpdate(TempCandidate tempCandidate) {
    if (tempCandidate.getId() == null) {
      return tempCandidateDao.insert(tempCandidate);
    } else {
      return tempCandidateDao.update(tempCandidate);
    }
  }

  @Override
  public int disableByIds(Long[] tempCandidateIds) {
    return tempCandidateDao.disableByIds(tempCandidateIds);
  }

  public PagingResult<TempCandidate> findByBean(TempCandidate tempCandidate, PageRange pageRange) {
    return tempCandidateDao.findByBean(tempCandidate, pageRange);
  }


  public List<TempCandidate> findByIds(Long[] ids){
    return tempCandidateDao.findByIds(ids);
  }

}
