package com.newstar.hbms.candidate.dao;

import com.newstar.hbms.candidate.domain.Certificate;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-05-16.
 */
public interface CertificateDao {

  public int insert(Certificate certificate);

  public int update(Certificate certificate);

  public int deleteByIds(Long[] resumeIds);

  public PagingResult<Certificate> findByBean(Certificate certificate, PageRange pageRange);

  public List<Certificate> findByIds(Long[] ids);

  public List<Certificate> findByResumeIds(Long[] ids);

  public PagingResult<Certificate> findMaxByCandidateIdsAndBean(Certificate certificate, PageRange pageRange);

}
