package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.paging.PagingParameter;
import com.companyname.hbms.utils.paging.PagingResult;
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
    resumeId = resume.getId();
    Assert.assertNotNull(resumeId);
  }

  public void testUpdate() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setId(resumeId);
    resume.setName(updateAfter);
    resumeService.update(resume);
    PagingParameter pagingParameter = new PagingParameter();
    pagingParameter.setParameter(resume);
    pagingParameter.setPageSize(10);
    pagingParameter.setPageNum(1);
    PagingResult<Resume> pagingResult = resumeService.findByBean(pagingParameter);
    Assert.assertNotSame(updateAfter, pagingResult.getRecords().get(0).getName());
  }

  public void testFindById() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setId(resumeId);
    PagingParameter pagingParameter = new PagingParameter();
    pagingParameter.setParameter(resume);
    pagingParameter.setPageSize(10);
    pagingParameter.setPageNum(1);
    PagingResult<Resume> pagingResult = resumeService.findByBean(pagingParameter);
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 1);
  }

  public void testDisable() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.disable(resumeId);
    Resume resume = new Resume();
    resume.setYn(Boolean.FALSE);
    resume.setId(resumeId);
    PagingParameter pagingParameter = new PagingParameter();
    pagingParameter.setParameter(resume);
    pagingParameter.setPageSize(10);
    pagingParameter.setPageNum(1);
    PagingResult<Resume> pagingResult = resumeService.findByBean(pagingParameter);
    Assert.assertTrue(pagingResult.getRecords() != null || pagingResult.getRecords().size() == 1);
  }

  public void testEnable() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    resumeService.enable(resumeId);
    Resume resume = new Resume();
    resume.setId(resumeId);
    PagingParameter pagingParameter = new PagingParameter();
    pagingParameter.setParameter(resume);
    pagingParameter.setPageSize(10);
    pagingParameter.setPageNum(1);
    PagingResult<Resume> pagingResult = resumeService.findByBean(pagingParameter);
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 1);
  }

  public void testPagingQuery() {
    ResumeService resumeService = TestUtils.getApplicationContext().getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setYn(Boolean.TRUE);
    PagingParameter pagingParameter = new PagingParameter();
    pagingParameter.setParameter(resume);
    pagingParameter.setPageSize(10);
    pagingParameter.setPageNum(6);
    PagingResult<Resume> pagingResult = resumeService.findByBean(pagingParameter);
    System.out.println(pagingResult);
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 10);
  }

}
