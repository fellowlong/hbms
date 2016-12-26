package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.dao.PositionDao;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.customer.domain.PositionLanguage;
import com.newstar.hbms.customer.domain.PositionTag;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.utils.business.BaseDataUtils;
import com.newstar.hbms.utils.business.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class PositionServiceImpl implements PositionService {

  private PositionDao positionDao;

  private TreeService treeService;

  private static List<BaseDataUtils.BaseDataConfig> baseDataConfigs = new ArrayList<BaseDataUtils.BaseDataConfig>();
  static {
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("priorityId", "priority"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("industryId", "industry"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("functionId", "function"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("cityId", "city"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("fameCompanyBackgroundId", "fameCompanyBackground"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("nationalityId", "nationality"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("degreeId", "degree"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig("sexId", "sex"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig(true, "languages", "languageId", "language"));
    baseDataConfigs.add(new BaseDataUtils.BaseDataConfig(true, "tags", "tagId", "tag"));
  }

  public void setPositionDao(PositionDao positionDao) {
    this.positionDao = positionDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  @Override
  public int insertOrUpdate(Position position) {
    int count = 0;
    if (position.getId() != null) {
      count += positionDao.update(position);
      count += positionDao.cleanLanguages(position.getId());
      count += positionDao.cleanTags(position.getId());
    } else {
      count += positionDao.insert(position);
    }
    if (position.getLanguages() != null && !position.getLanguages().isEmpty()) {
      for (PositionLanguage positionLanguage : position.getLanguages()) {
        positionLanguage.setPositionId(position.getId());
        count += positionDao.insertLanguage(positionLanguage);
      }
    }
    if (position.getTags() != null && !position.getTags().isEmpty()) {
      for (PositionTag positionTag : position.getTags()) {
        positionTag.setPositionId(position.getId());
        count += positionDao.insertTag(positionTag);
      }
    }
    return count;
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
    PagingResult<Position> result = positionDao.findByBean(position, pageRange);
    fillSubCollections(result.getRecords());
    BaseDataUtils.fillBaseData(result.getRecords(), baseDataConfigs, treeService);
    return result;
  }

  @Override
  public List<Position> findByIds(Long[] ids) {
    List<Position> positions = positionDao.findByIds(ids);
    fillSubCollections(positions);
    BaseDataUtils.fillBaseData(positions, baseDataConfigs, treeService);
    return positions;
  }

  private void fillSubCollections(List<Position> positions) {
    ObjectUtils.fillCollection(
        positions,
        "id",
        "languages",
        "positionId",
        new ObjectUtils.CollectionFetcher() {
          @Override
          public List fetch(Object[] parentKeys) {
            return positionDao.findLanguagesPositionIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
          }
        });
    ObjectUtils.fillCollection(
        positions,
        "id",
        "tags",
        "positionId",
        new ObjectUtils.CollectionFetcher() {
          @Override
          public List fetch(Object[] parentKeys) {
            return positionDao.findTagsPositionIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
          }
        });
  }


}
