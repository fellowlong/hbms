package com.companyname.hbms.basedata.service;

import com.companyname.hbms.basedata.domain.ListItem;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2014-09-09.
 */
public interface ListItemService {


  public int insert(ListItem listItem);

  public int update(ListItem listItem);

  public int deleteById(Long[] ids);

  public PagingResult<ListItem> findByBean(ListItem listItem, PageRange pageRange);

  public PagingResult<ListItem> findAllCategory(PageRange pageRange);

}
