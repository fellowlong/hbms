package com.newstar.hbms.search.dao;

import com.newstar.hbms.search.domain.TempCandidate;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2017/3/23.
 */
public interface TempCandidateDao {

    public int insert(TempCandidate tempCandidate);

    public int update(TempCandidate tempCandidate);

    public int disableByIds(Long[] tempCandidateIds);

    public PagingResult<TempCandidate> findByBean(TempCandidate tempCandidate, PageRange pageRange);

    public List<TempCandidate> findByIds(Long[] ids);

}
