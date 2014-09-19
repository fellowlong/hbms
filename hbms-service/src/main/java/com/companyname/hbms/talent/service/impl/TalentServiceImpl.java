package com.companyname.hbms.talent.service.impl;

import com.companyname.hbms.talent.dao.TalentDao;
import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.talent.service.TalentService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fellowlong on 14-5-29.
 */
public class TalentServiceImpl implements TalentService {

  private TalentDao talentDao;

  public void setTalentDao(TalentDao talentDao) {
    this.talentDao = talentDao;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insert(Talent talent) {
    return talentDao.insert(talent);
  }

  @Override
  public int update(Talent talent) {
    return talentDao.update(talent);
  }

  @Override
  public int disable(Long talentId) {
    return talentDao.disable(talentId);
  }

  @Override
  public int enable(Long talentId) {
    return talentDao.enable(talentId);
  }

  @Override
  public List<Talent> findByBean(Talent talent) {
    return talentDao.findByBean(talent);
  }

}
