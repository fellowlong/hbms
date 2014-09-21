//package com.companyname.hbms.candidate.service.impl;
//
//import com.companyname.hbms.candidate.domain.PersonalInfo;
//import com.companyname.hbms.candidate.domain.Resume;
//import com.companyname.hbms.candidate.service.PersonalInfoService;
//import com.companyname.hbms.candidate.service.CandidateService;
//import common.TestUtils;
//import junit.framework.Assert;
//import junit.framework.TestCase;
//
///**
// * Created by fellowlong on 14-5-29.
// */
//public class PersonalInfoServiceImplTest extends TestCase {
//
//  private static Long resumeId = null;
//
//  private static String keywordUpdateBefore = "Application Software Enginner";
//
//  private static String keywordUpdateAfter = "Application Software Ach";
//
//  public void testInsertResume() {
//    CandidateService resumeService = TestUtils.getApplicationContext().getBean(CandidateService.class);
//    Resume resume = new Resume();
//    resume.setName("Zhangsan's Resume");
//    resumeService.insert(resume);
//    resumeId = resume.getId();
//    Assert.assertNotNull(resumeId);
//  }
//
//  public void testInsertPersonalInfo() {
//    PersonalInfoService personalInfoService = TestUtils.getApplicationContext().getBean(PersonalInfoService.class);
//    PersonalInfo personalInfo = new PersonalInfo();
//    personalInfo.setResumeId(resumeId);
//    personalInfo.setName("Zhang San");
//    personalInfo.setSex(Boolean.FALSE);
//    personalInfo.setKeyword(keywordUpdateBefore);
//    personalInfoService.insert(personalInfo);
//    personalInfo = personalInfoService.findById(resumeId);
//    Assert.assertEquals(keywordUpdateBefore, personalInfo.getKeyword());
//  }
//
//  public void testUpdatePersonalInfo() {
//    PersonalInfoService personalInfoService = TestUtils.getApplicationContext().getBean(PersonalInfoService.class);
//    PersonalInfo personalInfo = new PersonalInfo();
//    personalInfo.setResumeId(resumeId);
//    personalInfo.setName("Zhang San");
//    personalInfo.setSex(Boolean.FALSE);
//    personalInfo.setKeyword(keywordUpdateAfter);
//    personalInfoService.update(personalInfo);
//    personalInfo = personalInfoService.findById(resumeId);
//    Assert.assertEquals(keywordUpdateAfter, personalInfo.getKeyword());
//  }
//
//
//
//}
