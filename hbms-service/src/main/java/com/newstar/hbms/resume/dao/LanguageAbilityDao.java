package com.newstar.hbms.resume.dao;

import com.newstar.hbms.resume.domain.LanguageAbility;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface LanguageAbilityDao {

  public int insert(LanguageAbility languageAbility);

  public int update(LanguageAbility languageAbility);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<LanguageAbility> findByBean(LanguageAbility languageAbility, PageRange pageRange);

  public List<LanguageAbility> findByIds(Long[] ids);

  public List<LanguageAbility> findByResumeIds(Long[] ids);

  public PagingResult<LanguageAbility> findMaxByCandidateIdsAndBean(LanguageAbility languageAbility, PageRange pageRange);

}
