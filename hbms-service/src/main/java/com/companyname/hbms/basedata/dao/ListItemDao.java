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

  public PagingResult<ListItem> findByBean(ListItem listItem, PageRange pageRange);

  public PagingResult<ListItem> findAllCategory(PageRange pageRange);

}
