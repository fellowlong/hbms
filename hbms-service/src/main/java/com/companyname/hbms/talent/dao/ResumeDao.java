package com.companyname.hbms.talent.dao;

import com.companyname.hbms.talent.domain.Resume;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeDao {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int delete(Long resumeId);

  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange);

  public PagingResult<Resume> findMaxByTalentIdsAndBean(Resume resume, PageRange pageRange);

}
