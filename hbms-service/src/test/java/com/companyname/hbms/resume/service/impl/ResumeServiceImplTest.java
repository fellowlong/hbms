package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by fellowlong on 14-5-29.
 */
public class ResumeServiceImplTest extends TestCase {

  private static Long resumeId = null;

  private static String updateBefore = "Zhangsan's Resume";

  private static String updateAfter = "LiSi's Enginner Resume";

  public void testInsert() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setName(updateBefore);
    resumeService.insert(resume);
    resumeId = resume.getResumeId();
    Assert.assertNotNull(resumeId);
  }

  public void testUpdate() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setResumeId(resumeId);
    resume.setName(updateAfter);
    resumeService.update(resume);
    resume = resumeService.findById(resumeId);
    Assert.assertNotSame(updateAfter, resume.getName());
  }

  public void testFindById() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = resumeService.findById(resumeId);
    Assert.assertNotNull(resume);
  }

  public void testDisable() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.disable(resumeId);
    Assert.assertNull(resumeService.findById(resumeId));
  }

  public void testEnable() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.enable(resumeId);
    Assert.assertNotNull(resumeService.findById(resumeId));
  }

}
