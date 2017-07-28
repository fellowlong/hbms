package com.newstar.hbms.candidate.service.impl;

import com.newstar.hbms.basedata.service.TreeService;
import com.newstar.hbms.candidate.dao.CandidateDao;
import com.newstar.hbms.candidate.dao.CandidateIndexTaskDao;
import com.newstar.hbms.candidate.dao.ResumeDao;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.candidate.domain.CandidateIndexTask;
import com.newstar.hbms.candidate.domain.Resume;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.service.AttachmentService;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.project.domain.ProjectCandidate;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.WordParser;
import com.newstar.hbms.utils.business.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class CandidateServiceImpl implements CandidateService {

  private CandidateDao candidateDao;

  private ResumeDao resumeDao;

  private TreeService treeService;

  private CompanyService companyService;

  private UserService userService;

  private AttachmentService attachmentService;

  private ProjectService projectService;

  private CandidateIndexTaskDao candidateIndexTaskDao;

  private List<ObjectUtils.SubObjectConfig> subObjectConfigs = new ArrayList<ObjectUtils.SubObjectConfig>();

  private List<ObjectUtils.SubCollectionConfig> subCollectionConfigs = new ArrayList<ObjectUtils.SubCollectionConfig>();

  public CandidateServiceImpl() {

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

    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("sexId", "sex", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("degreeId", "degree", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("maritalId", "marital", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("cityId", "city", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("industryId", "industry", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig( "companyId", "company", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("positionId", "position", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("statusId", "status", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("folderId", "folder", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("sourceId", "source", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("uploaderId", "uploader", "id", baseDataFetcher));
    subObjectConfigs.add(new ObjectUtils.SubObjectConfig("id", "resume", "candidateId", new ObjectUtils.SubObjectFetcher() {
      @Override
      public List fetch(List keys) {
        return resumeDao.findByCandidateIds((Long[]) keys.toArray(new Long[keys.size()]));
      }
    }));

    subCollectionConfigs.add(new ObjectUtils.SubCollectionConfig("id", "otherAttachments", "businessId", new ObjectUtils.SubCollectionFetcher() {
      @Override
      public List fetch(List parentKeys) {
        return attachmentService.findByBusiness(Attachment.BUSINESS_TYPE_CANDIDATE, (Long[]) parentKeys.toArray(new Long[parentKeys.size()]));
      }
    }));

  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Candidate candidate) throws IOException {
    int resultCount = 0;
    if (candidate.getId() != null) {
      resultCount = candidateDao.update(candidate);
      if (candidate.getDeletedResumeFileId() != null) {
        resumeDao.deleteByIds(new Long[]{candidate.getDeletedResumeFileId()});
      }
      if (candidate.getDeletedOtherAttachmentIds() != null) {
        attachmentService.deleteByIds(candidate.getDeletedOtherAttachmentIds().toArray(new Long[candidate.getDeletedOtherAttachmentIds().size()]));
      }
    } else {
      resultCount = candidateDao.insert(candidate);
    }
    if (candidate.getProjectIds() != null && !candidate.getProjectIds().isEmpty()) {
      List<ProjectCandidate> projectCandidates = new ArrayList<ProjectCandidate>();
      for (Long id : candidate.getProjectIds()) {
        ProjectCandidate projectCandidate = new ProjectCandidate();
        projectCandidate.setProjectId(id);
        projectCandidate.setCandidateId(candidate.getId());
        projectCandidates.add(projectCandidate);
      }
      resultCount += projectService.addProjectCandidates(projectCandidates);
    }
    if (candidate.getResumeFile() != null) {
      //如果是修改的话，新的简历要覆盖旧
      byte[] resumeFileData = candidate.getResumeFile().getBytes();
      String fileName = candidate.getResumeFile().getOriginalFilename();
      Attachment attachment = new Attachment();
      attachment.setBusinessType(Attachment.BUSINESS_TYPE_RESUME);
      attachment.setBusinessId(candidate.getId());
      attachment.setFileName(fileName);
      attachment.setFileBinaryData(resumeFileData);
      attachment.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
      attachment.setRemark("Candidate Resume");
      resultCount += attachmentService.insert(attachment);
      //=================================
      Resume resume = new Resume();
      resume.setCandidateId(candidate.getId());
      resume.setAttachment(attachment);
      resume.setName(fileName);
      resume.setAttachmentId(attachment.getId());
      String textResume = WordParser.getText(new ByteArrayInputStream(resumeFileData));
      resume.setTextResume(textResume);
      resume.setCreateUser(candidate.getCreateUser());
      resume.setUpdateUser(candidate.getUpdateUser());
      candidate.setResume(resume);
      resultCount += resumeDao.insert(resume);
    }
    if (candidate.getOtherAttachmentFiles() != null) {
      for (MultipartFile attachmentFile : candidate.getOtherAttachmentFiles() ) {
        Attachment attachment = new Attachment();
        attachment.setBusinessType(Attachment.BUSINESS_TYPE_CANDIDATE);
        attachment.setBusinessId(candidate.getId());
        String fileName = attachmentFile.getOriginalFilename();
        attachment.setFileName(fileName);
        attachment.setFileBinaryData(attachmentFile.getBytes());
        attachment.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
        attachment.setRemark("Candidate OtherAttachment");
        resultCount += attachmentService.insert(attachment);
      }
    }

    //添加创建索引任务
    CandidateIndexTask candidateIndexTask = new CandidateIndexTask();
    candidateIndexTask.setResumeId(candidate.getId());
    candidateIndexTask.setStatus(1);
    candidateIndexTask.setYn(Boolean.TRUE);
    resultCount += candidateIndexTaskDao.insert(candidateIndexTask);
    return resultCount;
  }


  @Override
  public int disableByIds(Long[] resumeIds) {
    return candidateDao.disableByIds(resumeIds);
  }

  @Override
  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange) {
    PagingResult<Candidate> result = candidateDao.findByBean(candidate, pageRange);
    fillAllSubObjects(result.getRecords());
    return result;
  }

  @Override
  public List<Candidate> findByIds(Long[] ids) {
    List<Candidate> candidates = candidateDao.findByIds(ids);
    fillAllSubObjects(candidates);
    return candidates;
  }

  private void fillAllSubObjects(List<Candidate> candidates) {
    ObjectUtils.fillSubCollection(candidates, subCollectionConfigs);
    ObjectUtils.fillSubObjects(candidates, subObjectConfigs);
  }

  public void setCandidateDao(CandidateDao candidateDao) {
    this.candidateDao = candidateDao;
  }

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  public void setTreeService(TreeService treeService) {
    this.treeService = treeService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setAttachmentService(AttachmentService attachmentService) {
    this.attachmentService = attachmentService;
  }

  public void setCandidateIndexTaskDao(CandidateIndexTaskDao candidateIndexTaskDao) {
    this.candidateIndexTaskDao = candidateIndexTaskDao;
  }

  public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }
}
