package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.OriginalResume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface OriginalResumeDao {

  public int insert(OriginalResume originalResume);

  public int update(OriginalResume originalResume);

  public int delete(Long id);

  public List<OriginalResume> findByBean(OriginalResume originalResume);

}
