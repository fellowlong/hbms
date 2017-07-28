package com.newstar.hbms.project.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.project.dao.ProjectDao;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.domain.ProjectAssistant;
import com.newstar.hbms.project.domain.ProjectCandidate;
import com.newstar.hbms.project.domain.ProjectConsultant;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.business.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjinsi on 2016/10/30.
 */
public class ProjectServiceImpl implements ProjectService  {

  private CandidateService candidateService;

  private ProjectDao projectDao;

  private TreeService treeService;

  private UserService userService;

  private CompanyService companyService;

  private ContactService contactService;

  private PositionService positionService;

  private List<ObjectUtils.SubObjectConfig> subObjectConfigs = new ArrayList<ObjectUtils.SubObjectConfig>();

  private List<ObjectUtils.SubCollectionConfig> subCollectionConfigs = new ArrayList<ObjectUtils.SubCollectionConfig>();

  private List<ObjectUtils.SubObjectConfig> projectCandidateSubObjectConfigs = new ArrayList<ObjectUtils.SubObjectConfig>();


  public ProjectServiceImpl() {
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
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "companyId", "company", "id", new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return companyService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    }));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "positionId", "position", "id", new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return positionService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    }));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "contactId", "contact", "id", new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return contactService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    }));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("importantLevelId", "importantLevel", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("managerId", "manager", "id", userFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("statusId", "status", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("assistants", "assistantId", "assistant", "id", userFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("consultants", "consultantId", "consultant", "id", userFetcher));



    //填充子集合配置
    subCollectionConfigs.add(new ObjectUtils.SubCollectionConfig("id", "assistants", "projectId", new ObjectUtils.SubCollectionFetcher() {
      @Override
      public List fetch(List parentKeys) {
        return projectDao.findAssistantsByProjectIds((Long[]) parentKeys.toArray(new Long[parentKeys.size()]));
      }
    }));
    subCollectionConfigs.add(new ObjectUtils.SubCollectionConfig("id", "consultants", "projectId", new ObjectUtils.SubCollectionFetcher() {
      @Override
      public List fetch(List parentKeys) {
        return projectDao.findConsultantsByProjectIds((Long[]) parentKeys.toArray(new Long[parentKeys.size()]));
      }
    }));


    ObjectUtils.SubObjectFetcher projectFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    ObjectUtils.SubObjectFetcher candidateFetcher = new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return candidateService.findByIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    };
    projectCandidateSubObjectConfigs.add(new ObjectUtils.SubObjectConfig("projectId", "project", "id", projectFetcher));
    projectCandidateSubObjectConfigs.add(new ObjectUtils.SubObjectConfig("candidateId", "candidate", "id", candidateFetcher));

  }

  public void setCandidateService(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  public void setPositionService(PositionService positionService) {
    this.positionService = positionService;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Project project) {
    int count = 0;
    if (project.getId() != null) {
      count += projectDao.update(project);
      count += projectDao.cleanConsultants(project.getId());
      count += projectDao.cleanAssistants(project.getId());
    } else {
      count += projectDao.insert(project);
    }
    if (project.getConsultants() != null && !project.getConsultants().isEmpty()) {
      for (ProjectConsultant projectConsultant : project.getConsultants()) {
        projectConsultant.setProjectId(project.getId());
        count += projectDao.insertConsultant(projectConsultant);
      }
    }
    if (project.getAssistants() != null && !project.getAssistants().isEmpty()) {
      for (ProjectAssistant projectAssistant : project.getAssistants()) {
        projectAssistant.setProjectId(project.getId());
        count += projectDao.insertAssistant(projectAssistant);
      }
    }
    return count;
  }

  @Override
  public int disable(Long[] projectIds) {
    return projectDao.disable(projectIds);
  }

  @Override
  public int enable(Long[] projectIds) {
    return projectDao.enable(projectIds);
  }

  @Override
  public PagingResult<Project> findByBean(Project project, PageRange pageRange) {
    PagingResult<Project> result = projectDao.findByBean(project, pageRange);
    fillAllSubObjects(result.getRecords());
    return result;
  }

  @Override
  public List<Project> findByIds(Long[] ids) {
    List<Project> projects = projectDao.findByIds(ids);
    fillAllSubObjects(projects);
    return projects;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int addProjectCandidates(List<ProjectCandidate> projectCandidates) {
    int resultCount = 0;
    for (ProjectCandidate projectCandidate : projectCandidates) {
      resultCount += projectDao.addProjectCandidate(projectCandidate);
    }
    return resultCount;
  }

  @Override
  public int removeProjectCandidates(List<Long> projectCandidateIds) {
    return projectDao.removeProjectCandidates(projectCandidateIds);
  }

  @Override
  public PagingResult<ProjectCandidate> findProjectCandidatesByBean(ProjectCandidate projectCandidate, PageRange pageRange) {
    PagingResult<ProjectCandidate> projectCandidates = projectDao.findProjectCandidatesByBean(projectCandidate, pageRange);
    ObjectUtils.fillSubObjects(projectCandidates.getRecords(), projectCandidateSubObjectConfigs);
    return projectCandidates;
  }


  private void fillAllSubObjects(List<Project> projects) {
    ObjectUtils.fillSubCollection(projects, subCollectionConfigs);
    ObjectUtils.fillSubObjects(projects, subObjectConfigs);
  }
}
