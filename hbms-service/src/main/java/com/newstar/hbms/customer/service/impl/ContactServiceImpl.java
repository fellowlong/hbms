package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.dao.ContactDao;
import com.newstar.hbms.customer.domain.CompanyIndustry;
import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class ContactServiceImpl implements ContactService {

  private ContactDao contactDao;

  private TreeService treeService;

  public void setContactDao(ContactDao contactDao) {
    this.contactDao = contactDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
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
    PagingResult<Contact> contactPagingResult = contactDao.findByBean(contact, pageRange);
    fillSubObject(contactPagingResult.getRecords());
    return contactPagingResult;
  }

  @Override
  public List<Contact> findByIds(Long[] ids) {
    List<Contact> contacts = contactDao.findByIds(ids);
    fillSubObject(contacts);
    return contacts;
  }

  private void fillSubObject(List<Contact> contacts) {
    if (contacts == null || contacts.isEmpty()) {
      return;
    }
    Set<Long> treeNodeIds = new HashSet<Long>();
    for (Contact contact : contacts) {
      if (contact.getImportantLevelId() != null) {
        treeNodeIds.add(contact.getImportantLevelId());
      }
      if (contact.getSexId() != null) {
        treeNodeIds.add(contact.getSexId());
      }
    }
    if (!treeNodeIds.isEmpty()) {
      List<TreeNode> treeNodes = treeService.findNodeByIds(treeNodeIds.toArray(new Long[treeNodeIds.size()]));
      for (TreeNode treeNode : treeNodes) {
        for (Contact contact : contacts) {
          if (treeNode.getId().equals(contact.getImportantLevelId())) {
            contact.setImportantLevel(treeNode);
          }
          if (treeNode.getId().equals(contact.getSexId())) {
            contact.setSex(treeNode);
          }
        }
      }
    }
  }

}
