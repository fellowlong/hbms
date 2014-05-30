package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.dao.PersonalInfoDao;
import com.companyname.hbms.resume.domain.PersonalInfo;
import com.companyname.hbms.resume.service.PersonalInfoService;

/**
 * Created by fellowlong on 14-5-30.
 */
public class PersonalInfoServiceImpl implements PersonalInfoService {

  private PersonalInfoDao personalInfoDao;

  public void setPersonalInfoDao(PersonalInfoDao personalInfoDao) {
    this.personalInfoDao = personalInfoDao;
  }

  @Override
  public int insert(PersonalInfo personalInfo) {
    return personalInfoDao.insert(personalInfo);
  }

  @Override
  public int update(PersonalInfo personalInfo) {
    return personalInfoDao.update(personalInfo);
  }

  @Override
  public PersonalInfo findById(Long resumeId) {
    return personalInfoDao.findById(resumeId);
  }
}
