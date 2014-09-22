package com.companyname.hbms.candidate.service;

import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

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

  public List<Candidate> findByBean(Candidate candidate);


}
