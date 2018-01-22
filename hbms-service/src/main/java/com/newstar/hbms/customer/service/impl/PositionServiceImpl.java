package com.newstar.hbms.customer.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.dao.PositionDao;
import com.newstar.hbms.customer.domain.Position;
import com.newstar.hbms.customer.domain.PositionLanguage;
import com.newstar.hbms.customer.domain.PositionTag;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.business.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fellowlong on 2016/10/22.
 */
public class PositionServiceImpl implements PositionService {

  private PositionDao positionDao;

  private TreeService treeService;

  private CompanyService companyService;
  private ContactService contactService;
  private UserService userService;

  private List<ObjectUtils.SubObjectConfig> subObjectConfigs = new ArrayList<ObjectUtils.SubObjectConfig>();

  private List<ObjectUtils.SubCollectionConfig> subCollectionConfigs = new ArrayList<ObjectUtils.SubCollectionConfig>();


  public PositionServiceImpl() {
    //填充子对象配置
    ObjectUtils.SubObjectFetcher baseDataFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return treeService.findTreesByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("priorityId", "priority", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("industryId", "industry", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("functionId", "function", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("cityId", "city", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("fameCompanyBackgroundId", "fameCompanyBackground", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("nationalityId", "nationality", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("degreeId", "degree", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("sexId", "sex", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("languages", "languageId", "language", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("tags", "tagId", "tag", "id", baseDataFetcher));

    ObjectUtils.SubObjectFetcher companyFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return companyService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "companyId", "company", "id", companyFetcher));

    ObjectUtils.SubObjectFetcher contactFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return contactService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "contactId", "contact", "id", contactFetcher));

    ObjectUtils.SubObjectFetcher userFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return userService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "businessDeveloperId", "businessDeveloper", "id", userFetcher));

    //填充子集合配置
    ObjectUtils.SubCollectionFetcher languagesFetcher = new ObjectUtils.SubCollectionFetcher() {
      @Override
      public List fetch(List parentKeys) {
        return positionDao.findLanguagesByPositionIds((Long[]) parentKeys.toArray(new Long[parentKeys.size()]));
      }
    };
    subCollectionConfigs.add(new ObjectUtils.SubCollectionConfig("id", "languages", "positionId", languagesFetcher));
    ObjectUtils.SubCollectionFetcher tagsFetcher = new ObjectUtils.SubCollectionFetcher() {
      @Override
      public List fetch(List parentKeys) {
        return positionDao.findTagsByPositionIds((Long[]) parentKeys.toArray(new Long[parentKeys.size()]));
      }
    };
    subCollectionConfigs.add(new ObjectUtils.SubCollectionConfig("id", "tags", "positionId", tagsFetcher));
  }

  public void setPositionDao(PositionDao positionDao) {
    this.positionDao = positionDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
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
    fillAllSubObjects(result.getRecords());
    return result;
  }

  @Override
  public List<Position> findByIds(Long[] ids) {
    List<Position> positions = positionDao.findByIds(ids);
    fillAllSubObjects(positions);
    return positions;
  }

  private void fillAllSubObjects(List<Position> positions) {
    ObjectUtils.fillSubCollection(positions, subCollectionConfigs);
    ObjectUtils.fillSubObjects(positions, subObjectConfigs);
  }


}
