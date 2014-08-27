package com.companyname.hbms.talent.dao;

import com.companyname.hbms.talent.domain.PersonalInfo;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface PersonalInfoDao {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public PersonalInfo findById(Long resumeId);

}
