package com.newstar.hbms.customer.service;

import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2016/10/22.
 */
public interface PositionService {

  public int insertOrUpdate(Position position);

  public int disable(Long[] contactIds);

  public int enable(Long[] contactIds);

  public PagingResult<Position> findByBean(Position position, PageRange pageRange);

  public List<Position> findByIds(Long[] ids);

}
