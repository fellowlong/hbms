package com.newstar.hbms.customer.service;

import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2016/10/22.
 */
public interface CompanyService {

  public int insertOrUpdate(Company company);

  public int disable(Long[] customerIds);

  public int enable(Long[] customerIds);

  public PagingResult<Company> findByBean(Company company, PageRange pageRange);

  public List<Company> findByIds(Long[] ids);

}
