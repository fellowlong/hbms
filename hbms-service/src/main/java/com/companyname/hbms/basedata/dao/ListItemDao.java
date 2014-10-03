package com.companyname.hbms.basedata.dao;

import com.companyname.hbms.basedata.domain.ListItem;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-09-04.
 */
public interface ListItemDao {

  public int insert(ListItem listItem);

  public int update(ListItem listItem);

  public int deleteById(Long[] ids);

  public List<ListItem> findByBean(ListItem listItem);

  public List<ListItem> findAllCategory();

  public List<ListItem> findListItemsOfCategoryByCode(String code);

  public List<ListItem> findByIds(Long[] ids);



}
