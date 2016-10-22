package com.newstar.hbms.resume.service;

import com.newstar.hbms.resume.domain.SourceResume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface SourceResumeSearchService {

  public int insert(SourceResume sourceResume);

  public int deleteByIds(Long[] sourceResumeIds);

  public List<SourceResume> findByIds(Long[] sourceResumeIds);


}
