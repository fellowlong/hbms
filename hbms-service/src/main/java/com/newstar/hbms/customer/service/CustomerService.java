package com.newstar.hbms.customer.service;

import com.newstar.hbms.customer.domain.Customer;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface CustomerService {

  public int insertOrUpdate(Customer customer);

  public int disable(Long[] customerIds);

  public int enable(Long[] customerIds);

  public PagingResult<Customer> findByBean(Customer customer, PageRange pageRange);

  public List<Customer> findByIds(Long[] ids);

}
