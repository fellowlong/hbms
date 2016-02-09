package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.dao.SourceResumeDao;
import com.companyname.hbms.resume.domain.SourceResume;
import com.companyname.hbms.resume.service.SourceResumeService;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public class SourceResumeServiceImpl implements SourceResumeService {

  private SourceResumeDao sourceResumeDao;

  public void setSourceResumeDao(SourceResumeDao sourceResumeDao) {
    this.sourceResumeDao = sourceResumeDao;
  }

  @Override
  public int insert(SourceResume sourceResume) {
    return sourceResumeDao.insert(sourceResume);
  }

  @Override
  public int update(SourceResume sourceResume) {
    return sourceResumeDao.update(sourceResume);
  }

  @Override
  public int deleteByIds(Long[] sourceResumeIds) {
    return sourceResumeDao.deleteByIds(sourceResumeIds);
  }

  @Override
  public List<SourceResume> findByIds(Long[] sourceResumeIds) {
    return sourceResumeDao.findByIds(sourceResumeIds);
  }
}
