package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.customer.dao.CompanyDao;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class CompanyServiceImpl implements CompanyService {

  private CompanyDao companyDao;

  public void setCompanyDao(CompanyDao companyDao) {
    this.companyDao = companyDao;
  }

  @Override
  public int insertOrUpdate(Company company) {
    return company.getId() != null ? companyDao.update(company) : companyDao.insert(company);
  }

  @Override
  public int disable(Long[] customerIds) {
    return companyDao.disable(customerIds);
  }

  @Override
  public int enable(Long[] customerIds) {
    return companyDao.enable(customerIds);
  }

  @Override
  public PagingResult<Company> findByBean(Company company, PageRange pageRange) {
    return companyDao.findByBean(company, pageRange);
  }

  @Override
  public List<Company> findByIds(Long[] ids) {
    return companyDao.findByIds(ids);
  }

}
