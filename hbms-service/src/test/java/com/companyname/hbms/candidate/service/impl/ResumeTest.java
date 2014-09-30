package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.candidate.service.CandidateService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.IOException;

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
    resume.setName("my original candidate");
    resume.setCandidateId(candidateId);
    resume.setKeyword("my");
    resume.setLanguageId(1L);
    resume.setAttachUri("/resume/");
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
    String name = "my original candidate " + System.currentTimeMillis();
    Resume resume = new Resume();
    resume.setId(resumeId);
    resume.setName(name);
    resume.setKeyword("my + 1");
    resume.setAttachUri("my candidate attachment name + 1");
    resume.setLanguageId(2L);
    resumeService.insertOrUpdate(resume);
    Resume resume2 = new Resume();
    resume2.setId(resumeId);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, new PageRange(1, 1));
    Assert.assertEquals(name, resumes.getRecords().get(0).getName());
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
