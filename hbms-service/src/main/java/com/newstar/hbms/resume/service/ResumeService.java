package com.newstar.hbms.resume.service;

import com.newstar.hbms.resume.domain.Resume;
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

  public int insertOrUpdate(Resume resume) throws IOException;

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange);

  public List<Resume> findByIds(Long[] ids);


}
