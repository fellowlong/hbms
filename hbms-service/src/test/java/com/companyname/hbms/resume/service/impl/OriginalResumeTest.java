package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.domain.OriginalResume;
import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.OriginalResumeService;
import com.companyname.hbms.resume.service.ResumeService;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class OriginalResumeTest extends TestCase {

  private static Long resumeId = null;
  private static Long originalResumeId = null;

  public void testInsertResume() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setName("Zhangsan's Resume");
    resumeService.insert(resume);
    resumeId = resume.getId();
    Assert.assertNotNull(resumeId);
  }

  public void testInsertOriginalResume() {
    OriginalResumeService originalResumeService = TestUtils.getApplicationContext().getBean(OriginalResumeService.class);
    OriginalResume originalResume = new OriginalResume();
    originalResume.setName("my original resume");
    originalResume.setResumeId(resumeId);
    originalResume.setKeyword("my");
    originalResume.setAttachmentName("my resume attachment name");
    originalResume.setAttachmentPath("/resume/aa/my.docx");
    originalResumeService.insert(originalResume);
    originalResumeId = originalResume.getId();
    Assert.assertNotNull(originalResumeId);
  }


  public void testOriginalResumeFindByResumeId() {
    OriginalResumeService originalResumeService = TestUtils.getApplicationContext().getBean(OriginalResumeService.class);
    OriginalResume originalResume = new OriginalResume();
    originalResume.setResumeId(resumeId);
    List<OriginalResume> originalResumes = originalResumeService.findByBean(originalResume);
    Assert.assertEquals(originalResumeId, originalResumes.get(0).getId());
  }

  public void testUpdateOriginalResume() {
    OriginalResumeService originalResumeService = TestUtils.getApplicationContext().getBean(OriginalResumeService.class);
    String name = "my original resume " + System.currentTimeMillis();
    OriginalResume originalResume = new OriginalResume();
    originalResume.setId(originalResumeId);
    originalResume.setName(name);
    originalResume.setResumeId(resumeId);
    originalResume.setKeyword("my + 1");
    originalResume.setAttachmentName("my resume attachment name + 1");
    originalResume.setAttachmentPath("/resume/aa/my.docx + 1");
    originalResumeService.update(originalResume);
    OriginalResume originalResume2 = new OriginalResume();
    originalResume2.setId(originalResumeId);
    List<OriginalResume> originalResumes = originalResumeService.findByBean(originalResume2);
    Assert.assertEquals(name, originalResumes.get(0).getName());
  }

  public void testDeleteOriginalResume() {
    OriginalResumeService originalResumeService = TestUtils.getApplicationContext().getBean(OriginalResumeService.class);
    originalResumeService.delete(originalResumeId);
    OriginalResume originalResume2 = new OriginalResume();
    originalResume2.setId(originalResumeId);
    List<OriginalResume> originalResumes = originalResumeService.findByBean(originalResume2);
    Assert.assertTrue(originalResumes.get(0).getYn() == false);
  }

}
