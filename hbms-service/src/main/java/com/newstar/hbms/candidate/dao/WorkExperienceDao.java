package com.newstar.hbms.candidate.dao;

import com.newstar.hbms.candidate.domain.WorkExperience;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface WorkExperienceDao {

  public int insert(WorkExperience workExperience);

  public int update(WorkExperience workExperience);

  public int deleteByIds(Long[] workExperienceIds);

  public int deleteByCandidateIds(Long[] candidateIds);

  public PagingResult<WorkExperience> findByBean(WorkExperience workExperience, PageRange pageRange);

  public List<WorkExperience> findByIds(Long[] ids);

  public List<WorkExperience> findByCandidateIds(Long[] ids);

}
