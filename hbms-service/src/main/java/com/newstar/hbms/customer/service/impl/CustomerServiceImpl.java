package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.customer.dao.CustomerDao;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.service.CustomerService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class CustomerServiceImpl implements CustomerService {

  private CustomerDao customerDao;

  public void setCustomerDao(CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  public int insertOrUpdate(Company company) {
    return company.getId() != null ? customerDao.update(company) : customerDao.insert(company);
  }

  @Override
  public int disable(Long[] customerIds) {
    return customerDao.disable(customerIds);
  }

  @Override
  public int enable(Long[] customerIds) {
    return customerDao.enable(customerIds);
  }

  @Override
  public PagingResult<Company> findByBean(Company company, PageRange pageRange) {
    return customerDao.findByBean(company, pageRange);
  }

  @Override
  public List<Company> findByIds(Long[] ids) {
    return customerDao.findByIds(ids);
  }

}
