package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.customer.dao.ContactDao;
import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class ContactServiceImpl implements ContactService {

  private ContactDao contactDao;

  public void setContactDao(ContactDao contactDao) {
    this.contactDao = contactDao;
  }

  @Override
  public int insertOrUpdate(Contact contact) {
    return contact.getId() != null ? contactDao.update(contact) : contactDao.insert(contact);
  }

  @Override
  public int disable(Long[] contactIds) {
    return contactDao.disable(contactIds);
  }

  @Override
  public int enable(Long[] contactIds) {
    return contactDao.enable(contactIds);
  }

  @Override
  public PagingResult<Contact> findByBean(Contact contact, PageRange pageRange) {
    return contactDao.findByBean(contact, pageRange);
  }

  @Override
  public List<Contact> findByIds(Long[] ids) {
    return contactDao.findByIds(ids);
  }

}
