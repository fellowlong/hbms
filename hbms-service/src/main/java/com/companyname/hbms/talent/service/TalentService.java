package com.companyname.hbms.talent.service;

import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 人才服务类
 */
public interface TalentService {

  public int insert(Talent talent);

  public int update(Talent talent);

  public int disable(Long talentId);

  public int enable(Long talentId);

  public List<Talent> findByBean(Talent talent);


}
