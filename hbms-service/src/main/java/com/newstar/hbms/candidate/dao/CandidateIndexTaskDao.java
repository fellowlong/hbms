package com.newstar.hbms.candidate.dao;

import com.newstar.hbms.candidate.domain.CandidateIndexTask;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface CandidateIndexTaskDao {

  public int insert(CandidateIndexTask candidateIndexTask);

  public int update(CandidateIndexTask candidateIndexTask);

  public int deleteByIds(Long[] resumeIndexTaskIds);

  public List<CandidateIndexTask> findByBean(CandidateIndexTask candidateIndexTask);


}
