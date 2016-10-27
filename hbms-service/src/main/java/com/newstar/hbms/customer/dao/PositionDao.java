package com.newstar.hbms.customer.dao;

import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public interface PositionDao {

  public int insert(Position position);

  public int update(Position position);

  public int disable(Long[] contactIds);

  public int enable(Long[] contactIds);

  public PagingResult<Position> findByBean(Position position, PageRange pageRange);

  public List<Position> findByIds(Long[] ids);

}
