package com.companyname.hbms.resume.dao;

import com.companyname.hbms.resume.domain.Certificate;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

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

  public PagingResult<Certificate> findMaxByCandidateIdsAndBean(Certificate certificate, PageRange pageRange);

}
