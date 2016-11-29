package com.newstar.hbms.project.service.impl;

import com.newstar.hbms.project.dao.ProjectDao;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/30.
 */
public class ProjectServiceImpl implements ProjectService  {

  private ProjectDao projectDao;

  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public int insertOrUpdate(Project project) {
    return 0;
  }

  @Override
  public int disable(Long[] contactIds) {
    return 0;
  }

  @Override
  public int enable(Long[] contactIds) {
    return 0;
  }

  @Override
  public PagingResult<Project> findByBean(Project project, PageRange pageRange) {
    return projectDao.findByBean(project, pageRange);
  }

  @Override
  public List<Project> findByIds(Long[] ids) {
    return null;
  }

}
