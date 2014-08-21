package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.dao.ResumeDao;
import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.paging.PagingParameter;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fellowlong on 14-5-29.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insert(Resume resume) {
    return resumeDao.insert(resume);
  }

  @Override
  public int update(Resume resume) {
    return resumeDao.update(resume);
  }

  @Override
  public int disable(Long resumeId) {
    return resumeDao.disable(resumeId);
  }

  @Override
  public int enable(Long resumeId) {
    return resumeDao.enable(resumeId);
  }

  @Override
  public PagingResult<Resume> findByBean(PagingParameter resumePage) {
    return resumeDao.findByBean(resumePage);
  }

}
