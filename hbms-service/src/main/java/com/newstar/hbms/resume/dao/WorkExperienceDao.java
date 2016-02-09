package com.newstar.hbms.resume.dao;

import com.newstar.hbms.resume.domain.WorkExperience;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface WorkExperienceDao {

  public int insert(WorkExperience workExperience);

  public int update(WorkExperience workExperience);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<WorkExperience> findByBean(WorkExperience workExperience, PageRange pageRange);

  public List<WorkExperience> findByIds(Long[] ids);

  public List<WorkExperience> findByResumeIds(Long[] ids);

  public PagingResult<WorkExperience> findMaxByCandidateIdsAndBean(WorkExperience workExperience, PageRange pageRange);

}
