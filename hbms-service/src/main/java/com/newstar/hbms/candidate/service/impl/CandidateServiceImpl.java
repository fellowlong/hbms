package com.newstar.hbms.candidate.service.impl;

import com.newstar.hbms.candidate.dao.CandidateDao;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fellowlong on 14-5-29.
 */
public class CandidateServiceImpl implements CandidateService {

  private CandidateDao candidateDao;

  public void setCandidateDao(CandidateDao candidateDao) {
    this.candidateDao = candidateDao;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insert(Candidate candidate) {
    return candidateDao.insert(candidate);
  }

  @Override
  public int update(Candidate candidate) {
    return candidateDao.update(candidate);
  }

  @Override
  public int disable(Long candidateId) {
    return candidateDao.disable(candidateId);
  }

  @Override
  public int enable(Long candidateId) {
    return candidateDao.enable(candidateId);
  }

  @Override
  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange) {
    return candidateDao.findByBean(candidate, pageRange);
  }

  @Override
  public List<Candidate> findByIds(Long[] ids) {
    return candidateDao.findByIds(ids);
  }


}
