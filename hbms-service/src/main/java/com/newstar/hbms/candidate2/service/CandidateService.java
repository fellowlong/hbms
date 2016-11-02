package com.newstar.hbms.candidate2.service;

import com.newstar.hbms.candidate2.domain.Candidate;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 候选人服务类
 */
public interface CandidateService {

  public int insert(Candidate candidate);

  public int update(Candidate candidate);

  public int disable(Long candidateId);

  public int enable(Long candidateId);

  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange);

  public List<Candidate> findByIds(Long[] ids);


}