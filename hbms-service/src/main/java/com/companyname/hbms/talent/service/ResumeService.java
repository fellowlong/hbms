package com.companyname.hbms.talent.service;

import com.companyname.hbms.talent.domain.Resume;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface ResumeService {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int delete(Long resumeId);

  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange);


}
