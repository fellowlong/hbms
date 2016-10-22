package com.newstar.hbms.customer.dao;

import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface ContactDao {

  public int insert(Contact contact);

  public int update(Contact contact);

  public int disable(Long contactId);

  public int enable(Long contactId);

  public PagingResult<Contact> findByBean(Contact contact, PageRange pageRange);

  public List<Contact> findByIds(Long[] ids);

}
