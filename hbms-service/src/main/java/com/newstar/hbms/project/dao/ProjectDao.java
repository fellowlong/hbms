package com.newstar.hbms.project.dao;

import com.newstar.hbms.customer.domain.PositionLanguage;
import com.newstar.hbms.customer.domain.PositionTag;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.domain.ProjectAssistant;
import com.newstar.hbms.project.domain.ProjectConsultant;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 14-6-5.
 */
public interface ProjectDao {

  public int insert(Project project);

  public int update(Project project);

  public int disable(Long[] projectIds);

  public int enable(Long[] projectIds);

  public PagingResult<Project> findByBean(Project project, PageRange pageRange);

  public List<Project> findByIds(Long[] ids);

  public int insertAssistant(ProjectAssistant projectAssistant);

  public int cleanAssistants(Long projectId);

  public int insertConsultant(ProjectConsultant projectConsultant);

  public int cleanConsultants(Long projectId);

  public List<ProjectAssistant> findAssistantsByProjectIds(Long[] projectIds);

  public List<ProjectConsultant> findConsultantsByProjectIds(Long[] projectIds);

}
