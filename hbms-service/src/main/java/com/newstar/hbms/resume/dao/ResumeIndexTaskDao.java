package com.newstar.hbms.resume.dao;

import com.newstar.hbms.resume.domain.ResumeIndexTask;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeIndexTaskDao {

  public int insert(ResumeIndexTask resumeIndexTask);

  public int update(ResumeIndexTask resumeIndexTask);

  public int deleteByIds(Long[] resumeIndexTaskIds);

  public List<ResumeIndexTask> findByBean(ResumeIndexTask resumeIndexTask);


}
