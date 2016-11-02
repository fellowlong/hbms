package com.newstar.hbms.candidate.dao;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface CandidateDao {

  public int insert(Candidate candidate);

  public int update(Candidate candidate);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange);

  public List<Candidate> findByIds(Long[] ids);

  public PagingResult<Candidate> findMaxByCandidateIdsAndBean(Candidate candidate, PageRange pageRange);

}
