package com.newstar.hbms.candidate.service;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.io.IOException;
import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface CandidateService {

  public int insertOrUpdate(Candidate candidate) throws IOException;

  public int disableByIds(Long[] resumeIds);

  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange);

  public List<Candidate> findByIds(Long[] ids);

}
