package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.PersonalInfo;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface PersonalInfoDao {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public PersonalInfo findById(Long resumeId);

}
