package com.newstar.hbms.basedata.service.impl;

import com.newstar.hbms.basedata.dao.ListItemDao;
import com.newstar.hbms.basedata.domain.ListItem;
import com.newstar.hbms.basedata.service.ListItemService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public class ListItemServiceImpl implements ListItemService {

  private ListItemDao listItemDao;

  public void setListItemDao(ListItemDao listItemDao) {
    this.listItemDao = listItemDao;
  }

  @Override
  public int insert(ListItem listItem) {
    return listItemDao.insert(listItem);
  }

  @Override
  public int update(ListItem listItem) {
    return listItemDao.update(listItem);
  }

  @Override
  public int deleteById(Long[] ids) {
    List<Long> idList = Arrays.asList(ids);
    Collections.sort(idList, new Comparator<Long>() {
      @Override
      public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
      }
    });
    return listItemDao.deleteById(idList.toArray(new Long[ids.length]));
  }

  @Override
  public List<ListItem> findByBean(ListItem listItem) {
    return listItemDao.findByBean(listItem);
  }

  @Override
  public List<ListItem> findAllCategory() {
    return listItemDao.findAllCategory();
  }

  public List<ListItem> findListItemsOfCategoryByCode(String code) {
    return listItemDao.findListItemsOfCategoryByCode(code);
  }

  @Override
  public List<ListItem> findByIds(Long[] ids) {
    return listItemDao.findByIds(ids);
  }
}
