package com.newstar.hbms.resume.dao;

import com.newstar.hbms.resume.domain.SourceResume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface SourceResumeDao {

  public int insert(SourceResume sourceResume);

  public int update(SourceResume sourceResume);

  public int deleteByIds(Long[] sourceResumeIds);

  public List<SourceResume> findByIds(Long[] sourceResumeIds);

}
