package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.customer.dao.PositionDao;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class PositionServiceImpl implements PositionService {

  private PositionDao positionDao;

  public void setPositionDao(PositionDao positionDao) {
    this.positionDao = positionDao;
  }

  @Override
  public int insertOrUpdate(Position position) {
    return position.getId() != null ? positionDao.update(position) : positionDao.insert(position);
  }

  @Override
  public int disable(Long[] positionIds) {
    return positionDao.disable(positionIds);
  }

  @Override
  public int enable(Long[] positionIds) {
    return positionDao.enable(positionIds);
  }

  @Override
  public PagingResult<Position> findByBean(Position position, PageRange pageRange) {
    return positionDao.findByBean(position, pageRange);
  }

  @Override
  public List<Position> findByIds(Long[] ids) {
    return positionDao.findByIds(ids);
  }

}
