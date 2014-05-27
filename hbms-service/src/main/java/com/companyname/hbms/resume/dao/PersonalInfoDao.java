package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.PersonalInfo;
import com.companyname.hbms.resume.domain.Resume_bak;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface PersonalInfoDao {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public int delete(PersonalInfo personalInfo);

  public int findById(Long resumeId);

}
