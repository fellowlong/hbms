package com.companyname.hbms.resume.service;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.io.IOException;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface ResumeService {

  public int insertOrUpdate(Resume resume) throws IOException;

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange);


}
