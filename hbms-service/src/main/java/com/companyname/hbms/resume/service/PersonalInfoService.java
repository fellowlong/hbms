package com.companyname.hbms.resume.service;

import com.companyname.hbms.resume.domain.PersonalInfo;

/**
 * Created by wangjinsi on 14-5-30.
 */
public interface PersonalInfoService {

  public int insert(PersonalInfo personalInfo);

  public int update(PersonalInfo personalInfo);

  public PersonalInfo findById(Long resumeId);

}
