package com.companyname.hbms.candidate.dao;

/**
 * Created by wangjinsi on 2014-05-16.
 */
public interface ResumeDao {

  public int save(Resume resume);

  public int update(Resume resume);

  public int delete(Resume resume);

  public int findById(Long resumeId);

}
