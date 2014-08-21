package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.dao.OriginalResumeDao;
import com.companyname.hbms.resume.domain.OriginalResume;
import com.companyname.hbms.resume.service.OriginalResumeService;

import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class OriginalResumeServiceImpl implements OriginalResumeService {

  private OriginalResumeDao originalResumeDao;

  public void setOriginalResumeDao(OriginalResumeDao originalResumeDao) {
    this.originalResumeDao = originalResumeDao;
  }

  @Override
  public int insert(OriginalResume originalResume) {
    return originalResumeDao.insert(originalResume);
  }

  @Override
  public int update(OriginalResume originalResume) {
    return originalResumeDao.update(originalResume);
  }

  @Override
  public int delete(Long id) {
    return originalResumeDao.delete(id);
  }

  @Override
  public List<OriginalResume> findByBean(OriginalResume originalResume) {
    return originalResumeDao.findByBean(originalResume);
  }
}
