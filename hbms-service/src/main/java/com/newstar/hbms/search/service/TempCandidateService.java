package com.newstar.hbms.search.service;

import com.newstar.hbms.search.domain.TempCandidate;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 14-6-5.
 */
public interface TempCandidateService {

  public int insertOrUpdate(TempCandidate tempCandidate);

  public int disableByIds(Long[] tempCandidateIds);

  public PagingResult<TempCandidate> findByBean(TempCandidate tempCandidate, PageRange pageRange);

  public List<TempCandidate> findByIds(Long[] ids);

}
