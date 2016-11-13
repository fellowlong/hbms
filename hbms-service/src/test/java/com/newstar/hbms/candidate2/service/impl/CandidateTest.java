//package com.newstar.hbms.candidate2.service.impl;
//
//import com.newstar.hbms.candidate.domain.*;
//import com.newstar.hbms.candidate.service.CandidateService;
//import com.newstar.hbms.support.paging.PageRange;
//import com.newstar.hbms.support.paging.PagingResult;
//import common.TestUtils;
//import junit.framework.Assert;
//import junit.framework.TestCase;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//*
// * Created by fellowlong on 2014-08-07.
//
//
//public class CandidateTest extends TestCase {
//
//  private static Long resumeId = null;
////
////  public void testInsertCandidate() {
////    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
////    Candidate candidate2 = new Candidate();
////    candidate2.setName("Zhangsan's Candidate");
////    candidateService.insert(candidate2);
////    candidateId = candidate2.getId();
////    Assert.assertNotNull(candidateId);
////  }
//
//  public void testInsertResume() throws IOException {
//    CandidateService resumeService = TestUtils.getApplicationContext().getBean(CandidateService.class);
//    Candidate candidate = new Candidate();
//    //candidate.setId();
//    candidate.setName("张三");
//    candidate.setSex(1L);
//    candidate.setTelephone("1234567899");
//    candidate.setAge(23);
//    candidate.setEmail("aa@qq.com");
//    candidate.setDegree(1L);
//    candidate.setWorkYears(3);
//    candidate.setMarital(1L);
//    candidate.setLocation(1L);
//    candidate.setIndustry(1L);
//    candidate.setCurrentCompany(1L);
//    candidate.setCurrentPosition(1L);
//    candidate.setCurrentAnnualSalary(3.2);
//    List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
//    WorkExperience workExperience1 = new WorkExperience();
//    workExperience1.setCompany("公司1");
//    workExperience1.setStartDate("2012-9");
//    workExperience1.setEndDate("2014-9");
//    workExperience1.setPosition("开发工程师");
//    workExperience1.setPosition("负责XX系统开发系统");
//    workExperience1.setIndustry("计算机软件");
//    workExperience1.setCandidate(candidate);
//    WorkExperience workExperience2 = new WorkExperience();
//    workExperience2.setCompany("公司2");
//    workExperience2.setStartDate("2010-9");
//    workExperience2.setEndDate("2013-9");
//    workExperience2.setPosition("职业顾问");
//    workExperience2.setPosition("负责医疗行业人才招聘");
//    workExperience2.setIndustry("人力资源");
//    workExperience2.setCandidate(candidate);
//    workExperiences.add(workExperience1);
//    workExperiences.add(workExperience2);
//    candidate.setWorkExperiences(workExperiences);
//    List<EducationExperience> educationExperiences = new ArrayList<EducationExperience>();
//    EducationExperience educationExperience1 = new EducationExperience();
//    educationExperience1.setSchool("北京大学");
//    educationExperience1.setStartDate("2010-9");
//    educationExperience1.setEndDate("2014-9");
//    educationExperience1.setDegree("本科");
//    educationExperience1.setCandidate(candidate);
//    EducationExperience educationExperience2 = new EducationExperience();
//    educationExperience2.setSchool("清华大学");
//    educationExperience2.setStartDate("2010-9");
//    educationExperience2.setEndDate("2013-9");
//    educationExperience2.setDegree("研究生");
//    educationExperience2.setCandidate(candidate);
//    educationExperiences.add(educationExperience1);
//    educationExperiences.add(educationExperience2);
//    candidate.setEducationExperiences(educationExperiences);
//    List<LanguageAbility> languageAbilities = new ArrayList<LanguageAbility>();
//    LanguageAbility languageAbility1 = new LanguageAbility();
//    languageAbility1.setName("英文");
//    languageAbility1.setReadAndWrite("流利");
//    languageAbility1.setListenAndSpeaking("一般");
//    languageAbility1.setCandidate(candidate);
//    LanguageAbility languageAbility2 = new LanguageAbility();
//    languageAbility2.setName("俄语");
//    languageAbility2.setReadAndWrite("流利");
//    languageAbility2.setListenAndSpeaking("一般");
//    languageAbility2.setCandidate(candidate);
//    languageAbilities.add(languageAbility1);
//    languageAbilities.add(languageAbility2);
//    candidate.setLanguageAbilities(languageAbilities);
//    List<Certificate> certificates = new ArrayList<Certificate>();
//    Certificate certificate1 = new Certificate();
//    certificate1.setName("软件工程师");
//    certificate1.setAcquireDate("2010-9");
//    certificate1.setCandidate(candidate);
//    Certificate certificate2 = new Certificate();
//    certificate2.setName("职业工程师");
//    certificate2.setAcquireDate("2010-9");
//    certificate2.setCandidate(candidate);
//    certificates.add(certificate1);
//    certificates.add(certificate2);
//    candidate.setCertificates(certificates);
//    candidate.setOther("XX参加了XX活动，得到了XX奖");
//    List<ProjectExperience> projectExperiences = new ArrayList<ProjectExperience>();
//    ProjectExperience projectExperience1 = new ProjectExperience();
//    projectExperience1.setName("XX项目");
//    projectExperience1.setStartDate("2010-9");
//    projectExperience1.setEndDate("2014-9");
//    projectExperience1.setIsIt(Boolean.TRUE);
//    projectExperience1.setSoftwareEnvironment("Java");
//    projectExperience1.setHardwareEnvironment("PCServer");
//    projectExperience1.setDevelopTool("InteljjIdea");
//    projectExperience1.setProjectDescription("XX信息管理");
//    projectExperience1.setResponsibility("XX模块开发");
//    projectExperience1.setCandidate(candidate);
//    ProjectExperience projectExperience2 = new ProjectExperience();
//    projectExperience2.setName("XX1项目");
//    projectExperience2.setStartDate("2011-9");
//    projectExperience2.setEndDate("2012-9");
//    projectExperience2.setIsIt(Boolean.FALSE);
//    projectExperience2.setProjectDescription("XX工程项目");
//    projectExperience2.setResponsibility("XX管理");
//    projectExperience2.setCandidate(candidate);
//    projectExperiences.add(projectExperience1);
//    projectExperiences.add(projectExperience2);
//    candidate.setProjectExperiences(projectExperiences);
//    candidate.setKeyword("XXX");
//    //candidate.setOriginalResumeText();
//    candidate.setLanguage(1L);
//    //candidate.setYn();
//    //candidate.setCreateTime();
//    //candidate.setCreateUser();
//    //candidate.setUpdateTime();
//    //candidate.setUpdateUser();
//    resumeService.insertOrUpdate(candidate);
//    resumeId = candidate.getId();
//    Assert.assertNotNull(resumeId);
//  }
//
//
//  public void testResumeFindByResumeId() {
//    CandidateService resumeService = TestUtils.getApplicationContext().getBean(CandidateService.class);
//    Candidate candidate = new Candidate();
//    candidate.setId(resumeId);
//    PagingResult<Candidate> resumes = resumeService.findByBean(candidate, new PageRange(1, 1));
//    Assert.assertEquals(resumeId, resumes.getRecords().get(0).getId());
//  }
//
//  public void testUpdateResume() throws IOException {
//    CandidateService resumeService = TestUtils.getApplicationContext().getBean(CandidateService.class);
//    Candidate candidate = resumeService.findByIds(new Long[]{resumeId}).get(0);
//    String newName = candidate.getName() + System.currentTimeMillis();
//    candidate.setName(newName);
//    resumeService.insertOrUpdate(candidate);
//    Candidate candidate2 = new Candidate();
//    candidate2.setId(resumeId);
//    candidate = resumeService.findByIds(new Long[]{resumeId}).get(0);
//    Assert.assertEquals(newName, candidate.getName());
//  }
//
//  public void testDeleteResume() {
//    CandidateService resumeService = TestUtils.getApplicationContext().getBean(CandidateService.class);
//    resumeService.deleteByIds(new Long[]{resumeId});
//    Candidate candidate = new Candidate();
//    candidate.setId(resumeId);
//    PagingResult<Candidate> resumes = resumeService.findByBean(candidate, new PageRange(1, 1));
//    Assert.assertTrue(resumes.getRecords().get(0).getYn() == false);
//  }
//
//}
