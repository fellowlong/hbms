package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.utils.paging.PagingParameter;
import com.companyname.hbms.utils.paging.PagingResult;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeDao {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int disable(Long resumeId);

  public int enable(Long resumeId);

  public PagingResult<Resume> findByBean(PagingParameter resumePage);

}
