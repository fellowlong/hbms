package com.companyname.hbms.resume.service;

import com.companyname.hbms.candidate.domain.PersonalInfo;

/**
 * Created by fellowlong on 14-5-30.
 */
public interface PersonalInfoService {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public PersonalInfo findById(Long resumeId);

}
