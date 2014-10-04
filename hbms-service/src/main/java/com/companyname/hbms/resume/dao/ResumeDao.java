package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeDao {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange);

  public List<Resume> findByIds(Long[] ids);

  public PagingResult<Resume> findMaxByCandidateIdsAndBean(Resume resume, PageRange pageRange);

}
