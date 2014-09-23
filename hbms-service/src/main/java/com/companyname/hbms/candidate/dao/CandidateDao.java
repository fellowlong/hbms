package com.companyname.hbms.candidate.dao;

import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface CandidateDao {

  public int insert(Candidate candidate);

  public int update(Candidate candidate);

  public int disable(Long candidateId);

  public int enable(Long candidateId);

  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange);

}
