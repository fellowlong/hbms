package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.EducationExperience;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface EducationExperienceDao {

  public int insert(EducationExperience educationExperience);

  public int update(EducationExperience educationExperience);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<EducationExperience> findByBean(EducationExperience educationExperience, PageRange pageRange);

  public List<EducationExperience> findByIds(Long[] ids);

  public List<EducationExperience> findByResumeIds(Long[] ids);

  public PagingResult<EducationExperience> findMaxByCandidateIdsAndBean(EducationExperience educationExperience, PageRange pageRange);

}
