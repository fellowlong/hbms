package com.newstar.hbms.candidate.dao;

import com.newstar.hbms.candidate.domain.Resume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface ResumeDao {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int disable(Long[] resumeIds);

  public int enable(Long[] resumeIds);

  public int deleteByIds(Long[] sourceResumeIds);

  public List<Resume> findByCandidateIds(Long[] candidateIds);

  public List<Resume> findByIds(Long[] sourceResumeIds);

}
