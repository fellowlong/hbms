package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.candidate.service.CandidateService;
import com.companyname.hbms.resume.domain.*;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeTest extends TestCase {

  private static Long candidateId = null;
  private static Long resumeId = null;

  public void testInsertCandidate() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    Candidate candidate = new Candidate();
    candidate.setName("Zhangsan's Resume");
    candidateService.insert(candidate);
    candidateId = candidate.getId();
    Assert.assertNotNull(candidateId);
  }

  public void testInsertResume() throws IOException {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    //resume.setId();
    resume.setName("张三");
    resume.setSex("男性");
    resume.setTelephone("1234567899");
    resume.setAge(23);
    resume.setEmail("aa@qq.com");
    resume.setEducation("大专");
    resume.setWorkYears("3年");
    resume.setMarital("已婚");
    resume.setLocation("居住地");
    resume.setIndustry("行业");
    resume.setCompany("公司");
    resume.setPosition("职位");
    resume.setSalary("薪资");
    resume.setSelfEvaluation("个人评价");
    List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
    WorkExperience workExperience1 = new WorkExperience();
    workExperience1.setCompany("公司1");
    workExperience1.setStartDate("2012-9");
    workExperience1.setEndDate("2014-9");
    workExperience1.setPosition("开发工程师");
    workExperience1.setPosition("负责XX系统开发系统");
    workExperience1.setIndustry("计算机软件");
    workExperience1.setResume(resume);
    WorkExperience workExperience2 = new WorkExperience();
    workExperience2.setCompany("公司2");
    workExperience2.setStartDate("2010-9");
    workExperience2.setEndDate("2013-9");
    workExperience2.setPosition("职业顾问");
    workExperience2.setPosition("负责医疗行业人才招聘");
    workExperience2.setIndustry("人力资源");
    workExperience2.setResume(resume);
    workExperiences.add(workExperience1);
    workExperiences.add(workExperience2);
    resume.setWorkExperiences(workExperiences);
    List<EducationExperience> educationExperiences = new ArrayList<EducationExperience>();
    EducationExperience educationExperience1 = new EducationExperience();
    educationExperience1.setSchool("北京大学");
    educationExperience1.setStartDate("2010-9");
    educationExperience1.setEndDate("2014-9");
    educationExperience1.setDegree("本科");
    educationExperience1.setResume(resume);
    EducationExperience educationExperience2 = new EducationExperience();
    educationExperience2.setSchool("清华大学");
    educationExperience2.setStartDate("2010-9");
    educationExperience2.setEndDate("2013-9");
    educationExperience2.setDegree("研究生");
    educationExperience2.setResume(resume);
    educationExperiences.add(educationExperience1);
    educationExperiences.add(educationExperience2);
    resume.setEducationExperiences(educationExperiences);
    List<LanguageAbility> languageAbilities = new ArrayList<LanguageAbility>();
    LanguageAbility languageAbility1 = new LanguageAbility();
    languageAbility1.setName("英文");
    languageAbility1.setReadAndWrite("流利");
    languageAbility1.setListenAndSpeaking("一般");
    languageAbility1.setResume(resume);
    LanguageAbility languageAbility2 = new LanguageAbility();
    languageAbility2.setName("俄语");
    languageAbility2.setReadAndWrite("流利");
    languageAbility2.setListenAndSpeaking("一般");
    languageAbility2.setResume(resume);
    languageAbilities.add(languageAbility1);
    languageAbilities.add(languageAbility2);
    resume.setLanguageAbilities(languageAbilities);
    List<Certificate> certificates = new ArrayList<Certificate>();
    Certificate certificate1 = new Certificate();
    certificate1.setName("软件工程师");
    certificate1.setAcquireDate("2010-9");
    certificate1.setResume(resume);
    Certificate certificate2 = new Certificate();
    certificate2.setName("职业工程师");
    certificate2.setAcquireDate("2010-9");
    certificate2.setResume(resume);
    certificates.add(certificate1);
    certificates.add(certificate2);
    resume.setCertificates(certificates);
    resume.setOther("XX参加了XX活动，得到了XX奖");
    List<ProjectExperience> projectExperiences = new ArrayList<ProjectExperience>();
    ProjectExperience projectExperience1 = new ProjectExperience();
    projectExperience1.setName("XX项目");
    projectExperience1.setStartDate("2010-9");
    projectExperience1.setEndDate("2014-9");
    projectExperience1.setIsIt(Boolean.TRUE);
    projectExperience1.setSoftwareEnvironment("Java");
    projectExperience1.setHardwareEnvironment("PCServer");
    projectExperience1.setDevelopTool("InteljjIdea");
    projectExperience1.setProjectDescription("XX信息管理");
    projectExperience1.setResponsibility("XX模块开发");
    projectExperience1.setResume(resume);
    ProjectExperience projectExperience2 = new ProjectExperience();
    projectExperience2.setName("XX1项目");
    projectExperience2.setStartDate("2011-9");
    projectExperience2.setEndDate("2012-9");
    projectExperience2.setIsIt(Boolean.FALSE);
    projectExperience2.setProjectDescription("XX工程项目");
    projectExperience2.setResponsibility("XX管理");
    projectExperience2.setResume(resume);
    projectExperiences.add(projectExperience1);
    projectExperiences.add(projectExperience2);
    resume.setProjectExperiences(projectExperiences);
    resume.setKeyword("XXX");
    resume.setOriginalResumeUri("/xx.doc");
    resume.setOriginalResumeInputStream(new FileInputStream("c:\\cd\\黄奇.docx"));
    //resume.setOriginalResumeText();
    resume.setLanguage("中文");
    //resume.setYn();
    //resume.setCreateTime();
    //resume.setCreateUser();
    //resume.setUpdateTime();
    //resume.setUpdateUser();
    resumeService.insertOrUpdate(resume);
    resumeId = resume.getId();
    Assert.assertNotNull(resumeId);
  }


  public void testResumeFindByResumeId() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setId(resumeId);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, new PageRange(1, 1));
    Assert.assertEquals(resumeId, resumes.getRecords().get(0).getId());
  }

  public void testUpdateResume() throws IOException {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = resumeService.findByIds(new Long[]{resumeId}).get(0);
    String oldName = resume.getName();
    resume.setName(resume.getName() + System.currentTimeMillis());
    resumeService.insertOrUpdate(resume);
    Resume resume2 = new Resume();
    resume2.setId(resumeId);
    resume = resumeService.findByIds(new Long[]{resumeId}).get(0);
    Assert.assertEquals(oldName, resume.getName());
  }

  public void testDeleteResume() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.deleteByIds(new Long[]{resumeId});
    Resume resume = new Resume();
    resume.setId(resumeId);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, new PageRange(1, 1));
    Assert.assertTrue(resumes.getRecords().get(0).getYn() == false);
  }

}
