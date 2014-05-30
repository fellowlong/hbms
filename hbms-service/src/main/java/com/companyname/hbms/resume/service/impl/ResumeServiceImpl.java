package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.dao.ResumeDao;
import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangjinsi on 14-5-29.
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
  public int delete(Long resumeId) {
    return resumeDao.delete(resumeId);
  }

  @Override
  public int findById(Long resumeId) {
    return 0;
  }

}
