package com.newstar.hbms.customer.service;

import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface ContactService {

  public int insertOrUpdate(Contact contact);

  public int disable(Long[] contactIds);

  public int enable(Long[] contactIds);

  public PagingResult<Contact> findByBean(Contact contact, PageRange pageRange);

  public List<Contact> findByIds(Long[] ids);

}
