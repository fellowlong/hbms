package com.newstar.hbms.search.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.search.dao.TempCandidateDao;
import com.newstar.hbms.search.domain.TempCandidate;
import com.newstar.hbms.search.service.TempCandidateService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.business.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fellowlong on 2014-07-28.
 */
public class TempCandidateServiceImpl implements TempCandidateService {

  private TempCandidateDao tempCandidateDao;

  private TreeService  treeService;

  private UserService userService;

  private CompanyService companyService;

  private PositionService positionService;

  private ProjectService projectService;

  private List<ObjectUtils.SubObjectConfig> subObjectConfigs = new ArrayList<ObjectUtils.SubObjectConfig>();

  private List<ObjectUtils.SubCollectionConfig> subCollectionConfigs = new ArrayList<ObjectUtils.SubCollectionConfig>();

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public void setPositionService(PositionService positionService) {
    this.positionService = positionService;
  }

  public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }

  public TempCandidateServiceImpl() {

    //填充子对象配置
    ObjectUtils.SubObjectFetcher baseDataFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return treeService.findTreesByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    ObjectUtils.SubObjectFetcher userFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return userService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    ObjectUtils.SubObjectFetcher projectFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return projectService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("companyId", "company", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("positionId", "position", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("cityId", "city", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("jobHuntingStatusId", "jobHuntingStatus", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("projectId", "project", "id", projectFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("addUserId", "addUser", "id", userFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("searchUserId", "searchUser", "id", userFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("searchStatusId", "searchStatus", "id", baseDataFetcher));

  }

  public void setTempCandidateDao(TempCandidateDao tempCandidateDao) {
    this.tempCandidateDao = tempCandidateDao;
  }

  @Override
  public int insertOrUpdate(TempCandidate tempCandidate) {
    if (tempCandidate.getId() == null) {
      return tempCandidateDao.insert(tempCandidate);
    } else {
      return tempCandidateDao.update(tempCandidate);
    }
  }

  @Override
  public int disableByIds(Long[] tempCandidateIds) {
    return tempCandidateDao.disableByIds(tempCandidateIds);
  }

  public PagingResult<TempCandidate> findByBean(TempCandidate tempCandidate, PageRange pageRange) {
    PagingResult<TempCandidate> result = tempCandidateDao.findByBean(tempCandidate, pageRange);
    fillAllSubObjects(result.getRecords());
    return result;
  }


  public List<TempCandidate> findByIds(Long[] ids){
    List<TempCandidate> tempCandidates = tempCandidateDao.findByIds(ids);
    fillAllSubObjects(tempCandidates);
    return tempCandidates;
  }

  private void fillAllSubObjects(List<TempCandidate> tempCandidates) {
    ObjectUtils.fillSubCollection(tempCandidates, subCollectionConfigs);
    ObjectUtils.fillSubObjects(tempCandidates, subObjectConfigs);
  }

}
