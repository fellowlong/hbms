package com.companyname.hbms.resume.service;

import com.companyname.hbms.resume.domain.OriginalResume;
import com.companyname.hbms.resume.domain.Resume;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-27.
 *
 * 原始简历服务类
 */
public interface OriginalResumeService {

  public int insert(OriginalResume originalResume);

  public int update(OriginalResume originalResume);

  public int delete(Long id);

  public List<OriginalResume> findByBean(OriginalResume originalResume);


}
