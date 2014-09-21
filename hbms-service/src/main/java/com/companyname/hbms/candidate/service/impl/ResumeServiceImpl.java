package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.dao.ResumeDao;
import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  @Override
  public int insert(Resume resume) {
    return resumeDao.insert(resume);
  }

  @Override
  public int update(Resume resume) {
    return resumeDao.update(resume);
  }

  @Override
  public int delete(Long id) {
    return resumeDao.delete(id);
  }

  @Override
  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange) {
    return resumeDao.findByBean(resume, pageRange);
  }
}
