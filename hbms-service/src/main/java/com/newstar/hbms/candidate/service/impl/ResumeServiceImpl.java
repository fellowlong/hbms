package com.newstar.hbms.candidate.service.impl;

import com.newstar.hbms.candidate.dao.ResumeDao;
import com.newstar.hbms.candidate.domain.Resume;
import com.newstar.hbms.candidate.service.SourceResumeService;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public class ResumeServiceImpl implements SourceResumeService {

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
  public int deleteByIds(Long[] sourceResumeIds) {
    return resumeDao.deleteByIds(sourceResumeIds);
  }

  @Override
  public List<Resume> findByIds(Long[] sourceResumeIds) {
    return resumeDao.findByIds(sourceResumeIds);
  }
}
