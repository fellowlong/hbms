package com.newstar.hbms.resume.dao;

import com.newstar.hbms.resume.domain.ProjectExperience;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ProjectExperienceDao {

  public int insert(ProjectExperience projectExperience);

  public int update(ProjectExperience projectExperience);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<ProjectExperience> findByBean(ProjectExperience projectExperience, PageRange pageRange);

  public List<ProjectExperience> findByIds(Long[] ids);

  public List<ProjectExperience> findByResumeIds(Long[] ids);

  public PagingResult<ProjectExperience> findMaxByCandidateIdsAndBean(ProjectExperience projectExperience, PageRange pageRange);

}
