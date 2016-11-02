package com.newstar.hbms.candidate.service;

import com.newstar.hbms.candidate.domain.Resume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface SourceResumeService {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int deleteByIds(Long[] sourceResumeIds);

  public List<Resume> findByIds(Long[] sourceResumeIds);


}
