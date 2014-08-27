package com.companyname.hbms.talent.service.impl;

import com.companyname.hbms.talent.domain.Resume;
import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.talent.service.ResumeService;
import com.companyname.hbms.talent.service.TalentService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeTest extends TestCase {

  private static Long talentId = null;
  private static Long resumeId = null;

  public void testInsertTalent() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    Talent talent = new Talent();
    talent.setName("Zhangsan's Resume");
    talentService.insert(talent);
    talentId = talent.getId();
    Assert.assertNotNull(talentId);
  }

  public void testInsertResume() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setName("my original talent");
    resume.setTalentId(talentId);
    resume.setKeyword("my");
    resume.setLanguageId(1L);
    resume.setPath("/resume/");
    resumeService.insert(resume);
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

  public void testUpdateResume() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    String name = "my original talent " + System.currentTimeMillis();
    Resume resume = new Resume();
    resume.setId(resumeId);
    resume.setName(name);
    resume.setKeyword("my + 1");
    resume.setPath("my talent attachment name + 1");
    resume.setLanguageId(2L);
    resume.setType(2L);
    resumeService.update(resume);
    Resume resume2 = new Resume();
    resume2.setId(resumeId);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, new PageRange(1, 1));
    Assert.assertEquals(name, resumes.getRecords().get(0).getName());
  }

  public void testDeleteResume() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.delete(resumeId);
    Resume resume = new Resume();
    resume.setId(resumeId);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, new PageRange(1, 1));
    Assert.assertTrue(resumes.getRecords().get(0).getYn() == false);
  }

}
