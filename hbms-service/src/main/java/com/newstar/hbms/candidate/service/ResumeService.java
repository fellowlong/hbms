package com.newstar.hbms.candidate.service;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.io.IOException;
import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface ResumeService {

  public int insertOrUpdate(Candidate candidate) throws IOException;

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange);

  public List<Candidate> findByIds(Long[] ids);


}
