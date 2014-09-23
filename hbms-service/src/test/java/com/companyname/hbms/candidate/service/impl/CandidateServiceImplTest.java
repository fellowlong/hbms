package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.candidate.service.CandidateService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by fellowlong on 14-5-29.
 */
public class CandidateServiceImplTest extends TestCase {

  private static Long candidateId = null;

  private static String updateBefore = "Zhangsan's Resume";

  private static String updateAfter = "LiSi's Enginner Resume";

  public void testInsert() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    Candidate candidate = new Candidate();
    candidate.setName(updateBefore);
    candidateService.insert(candidate);
    candidateId = candidate.getId();
    Assert.assertNotNull(candidateId);
  }

  public void testUpdate() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    Candidate candidate = new Candidate();
    candidate.setId(candidateId);
    candidate.setName(updateAfter);
    candidateService.update(candidate);
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, new PageRange(1, 10));
    Assert.assertNotSame(updateAfter, candidates.getRecords().get(0).getName());
  }

  public void testFindById() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    Candidate candidate = new Candidate();
    candidate.setId(candidateId);
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, new PageRange(1, 10));
    Assert.assertTrue(candidates != null && candidates.getRecords().size() == 1);
  }

  public void testDisable() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    candidateService.disable(candidateId);
    Candidate candidate = new Candidate();
    candidate.setYn(Boolean.FALSE);
    candidate.setId(candidateId);
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, new PageRange(1, 10));
    Assert.assertTrue(candidates != null || candidates.getRecords().size() == 1);
  }

  public void testEnable() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    candidateService.enable(candidateId);
    Candidate candidate = new Candidate();
    candidate.setId(candidateId);
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, new PageRange(1, 10));
    Assert.assertTrue(candidates != null && candidates.getRecords().size() == 1);
  }

  public void testPagingQuery() {
    CandidateService candidateService = TestUtils.getApplicationContext().getBean(CandidateService.class);
    Candidate candidate = new Candidate();
    candidate.setYn(Boolean.TRUE);
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, new PageRange(1, 10));
    System.out.println(candidates);
    Assert.assertTrue(candidates != null && candidates.getRecords().size() == 10);
  }

}
