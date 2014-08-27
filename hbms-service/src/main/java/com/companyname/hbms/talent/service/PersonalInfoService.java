package com.companyname.hbms.talent.service;

import com.companyname.hbms.talent.domain.PersonalInfo;

/**
 * Created by fellowlong on 14-5-30.
 */
public interface PersonalInfoService {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public PersonalInfo findById(Long resumeId);

}
