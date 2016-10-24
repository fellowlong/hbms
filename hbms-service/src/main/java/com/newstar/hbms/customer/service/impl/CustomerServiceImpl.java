package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.customer.dao.CustomerDao;
import com.newstar.hbms.customer.domain.Customer;
import com.newstar.hbms.customer.service.CustomerService;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

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
  public int insertOrUpdate(Customer customer) {
    return customer.getId() != null ? customerDao.update(customer) : customerDao.insert(customer);
  }

  @Override
  public int disable(Long customerId) {
    return customerDao.disable(customerId);
  }

  @Override
  public int enable(Long customerId) {
    return customerDao.enable(customerId);
  }

  @Override
  public PagingResult<Customer> findByBean(Customer customer, PageRange pageRange) {
    return customerDao.findByBean(customer, pageRange);
  }

  @Override
  public List<Customer> findByIds(Long[] ids) {
    return customerDao.findByIds(ids);
  }

}
