package com.newstar.hbms.project.dao;

import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 14-6-5.
 */
public interface ProjectDao {

  public int insert(Project project);

  public int update(Project project);

  public int disable(Long[] contactIds);

  public int enable(Long[] contactIds);

  public PagingResult<Project> findByBean(Project project, PageRange pageRange);

  public List<Project> findByIds(Long[] ids);

}
