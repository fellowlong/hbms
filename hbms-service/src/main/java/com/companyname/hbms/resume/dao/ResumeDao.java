package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.Resume_bak;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeDao {

  public int save(Resume_bak resume);

  public int update(Resume_bak resume);

  public int delete(Resume_bak resume);

  public int findById(Long resumeId);

}
