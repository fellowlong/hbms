package com.companyname.hbms.resume.service;

import com.companyname.hbms.resume.domain.Resume;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 简历服务类
 */
public interface ResumeService {

  public int insert(Resume resume);

  public int update(Resume resume);

  public int delete(Long resumeId);

  public int findById(Long resumeId);


}
