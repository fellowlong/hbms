package com.companyname.hbms.talent.service.impl;

import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.talent.service.TalentService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by fellowlong on 14-5-29.
 */
public class TalentServiceImplTest extends TestCase {

  private static Long talentId = null;

  private static String updateBefore = "Zhangsan's Resume";

  private static String updateAfter = "LiSi's Enginner Resume";

  public void testInsert() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    Talent talent = new Talent();
    talent.setName(updateBefore);
    talentService.insert(talent);
    talentId = talent.getId();
    Assert.assertNotNull(talentId);
  }

  public void testUpdate() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    Talent talent = new Talent();
    talent.setId(talentId);
    talent.setName(updateAfter);
    talentService.update(talent);
    PagingResult<Talent> pagingResult = talentService.findByBean(talent, new PageRange(1, 10));
    Assert.assertNotSame(updateAfter, pagingResult.getRecords().get(0).getName());
  }

  public void testFindById() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    Talent talent = new Talent();
    talent.setId(talentId);
    PagingResult<Talent> pagingResult = talentService.findByBean(talent, new PageRange(1, 10));
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 1);
  }

  public void testDisable() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    talentService.disable(talentId);
    Talent talent = new Talent();
    talent.setYn(Boolean.FALSE);
    talent.setId(talentId);
    PagingResult<Talent> pagingResult = talentService.findByBean(talent, new PageRange(1, 10));
    Assert.assertTrue(pagingResult.getRecords() != null || pagingResult.getRecords().size() == 1);
  }

  public void testEnable() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    talentService.enable(talentId);
    Talent talent = new Talent();
    talent.setId(talentId);
    PagingResult<Talent> pagingResult = talentService.findByBean(talent, new PageRange(1, 10));
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 1);
  }

  public void testPagingQuery() {
    TalentService talentService = TestUtils.getApplicationContext().getBean(TalentService.class);
    Talent talent = new Talent();
    talent.setYn(Boolean.TRUE);
    PagingResult<Talent> pagingResult = talentService.findByBean(talent, new PageRange(1, 1));
    System.out.println(pagingResult);
    Assert.assertTrue(pagingResult.getRecords() != null && pagingResult.getRecords().size() == 10);
  }

}
