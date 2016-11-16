package com.newstar.hbms.customer.dao;

import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface CompanyDao {

  public int insert(Company company);

  public int update(Company company);

  public int disable(Long[] customerIds);

  public int enable(Long[] customerIds);

  public PagingResult<Company> findByBean(Company company, PageRange pageRange);

  public List<Company> findByIds(Long[] ids);

}
