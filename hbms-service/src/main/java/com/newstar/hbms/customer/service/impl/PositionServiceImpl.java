package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.dao.PositionDao;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.utils.business.BaseDataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class PositionServiceImpl implements PositionService {

  private PositionDao positionDao;

  private TreeService treeService;

  public void setPositionDao(PositionDao positionDao) {
    this.positionDao = positionDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
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

  private void fillBaseData(List<Position> positions) {
    List<BaseDataUtils.BaseDataConfig> baseDataConfigs = new ArrayList<BaseDataUtils.BaseDataConfig>();
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("companyId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("contactId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("priorityId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("industryId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("functionId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("cityId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("fameCompanyBackgroundId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("nationalityId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("degreeId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("sexId", "company"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig(true, "languages", "languageId", "language"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig(true, "tags", "tagId", "tag"));
    BaseDataUtils.fillBaseData(positions, baseDataConfigs, treeService);
  }

}
