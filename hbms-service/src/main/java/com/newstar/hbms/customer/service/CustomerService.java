package com.newstar.hbms.customer.service;

import com.newstar.hbms.customer.domain.Customer;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface CustomerService {


  public int insertOrUpdate(Customer customer);

  public int disable(Long customerId);

  public int enable(Long customerId);

  public PagingResult<Customer> findByBean(Customer customer, PageRange pageRange);

  public List<Customer> findByIds(Long[] ids);

}
