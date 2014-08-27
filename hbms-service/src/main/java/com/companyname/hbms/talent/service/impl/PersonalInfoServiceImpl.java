package com.companyname.hbms.talent.service.impl;

import com.companyname.hbms.talent.dao.PersonalInfoDao;
import com.companyname.hbms.talent.domain.PersonalInfo;
import com.companyname.hbms.talent.service.PersonalInfoService;

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
