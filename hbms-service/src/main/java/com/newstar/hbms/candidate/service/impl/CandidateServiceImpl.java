package com.newstar.hbms.candidate.service.impl;

import com.newstar.hbms.candidate.dao.*;
import com.newstar.hbms.candidate.domain.*;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.common.dao.AttachmentDao;
import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.service.AttachmentService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.utils.WordParser;
import com.newstar.hbms.utils.business.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class CandidateServiceImpl implements CandidateService {

  private CandidateDao candidateDao;

  private ResumeDao resumeDao;

  private AttachmentService attachmentService;

  private CandidateIndexTaskDao candidateIndexTaskDao;

  private List<ObjectUtils.SubCollectionConfig> subCollectionConfigs = new ArrayList<ObjectUtils.SubCollectionConfig>();

  public CandidateServiceImpl() {
    //填充子集合配置
    /*ObjectUtils.SubCollectionFetcher languagesFetcher = new ObjectUtils.SubCollectionFetcher() {
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
*/
  }

  public void setCandidateDao(CandidateDao candidateDao) {
    this.candidateDao = candidateDao;
  }

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  public void setAttachmentService(AttachmentService attachmentService) {
    this.attachmentService = attachmentService;
  }

  public void setCandidateIndexTaskDao(CandidateIndexTaskDao candidateIndexTaskDao) {
    this.candidateIndexTaskDao = candidateIndexTaskDao;
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
        attachmentService.deleteByIds(candidate.getDeletedOtherAttachmentIds());
      }
    } else {
      resultCount = candidateDao.insert(candidate);
    }
    if (candidate.getResumeFile() != null) {
      //如果是修改的话，新的简历要覆盖旧
      String fileName = candidate.getResumeFile().getOriginalFilename();
      Attachment attachment = new Attachment();
      attachment.setBusinessType(Attachment.BUSINESS_TYPE_RESUME);
      attachment.setBusinessId(candidate.getId());
      String textResume = WordParser.getText(
          candidate.getResumeFile().getInputStream(),
          WordParser.getVersion(fileName));
      attachment.setFileName(fileName);
      attachment.setFileBinaryData(candidate.getResumeFile().getBytes());
      attachment.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
      attachment.setRemark("Candidate Resume");
      resultCount += attachmentService.insert(attachment);
      //=================================
      Resume resume = new Resume();
      resume.setCandidateId(candidate.getId());
      resume.setAttachment(attachment);
      resume.setName(fileName);
      resume.setAttachmentId(attachment.getId());
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
  public int deleteByIds(Long[] resumeIds) {
    return candidateDao.deleteByIds(resumeIds);
  }

  @Override
  public PagingResult<Candidate> findByBean(Candidate candidate, PageRange pageRange) {
    PagingResult<Candidate> result = candidateDao.findByBean(candidate, pageRange);
    fillSubObjects(result.getRecords());
    return result;
  }

  @Override
  public List<Candidate> findByIds(Long[] ids) {
    List<Candidate> candidates = candidateDao.findByIds(ids);
    if (candidates != null) {
      List<Long> candidateIds = new ArrayList<Long>(candidates.size());
      Map<Long, Candidate> resumeMap = new HashMap<Long, Candidate>();
      for (Candidate candidate : candidates) {
        if (candidate.getId() != null) {
          candidateIds.add(candidate.getId());
          resumeMap.put(candidate.getId(), candidate);
        }
      }
      if (!candidateIds.isEmpty()) {
        List<Resume> resumes = resumeDao.findByCandidateIds(candidateIds.toArray(new Long[candidateIds.size()]));
        for (Resume resume : resumes) {
          Candidate candidate = resumeMap.get(resume.getCandidateId());
          if (candidate != null) {
            candidate.setResume(resume);
          }
        }
      }
    }
    fillSubObjects(candidates);
    return candidates;
  }

  private void fillSubObjects(List<Candidate> candidates) {
    /*ObjectUtils.fillCollection(
            candidates,
       "id",
       "workExperiences",
       "resumeId",
       new ObjectUtils.CollectionFetcher() {
         @Override
         public List fetch(Object[] parentKeys) {
           return workExperienceDao.findByResumeIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
         }
       });
    ObjectUtils.fillCollection(
            candidates,
       "id",
       "educationExperiences",
       "resumeId",
       new ObjectUtils.CollectionFetcher() {
         @Override
         public List fetch(Object[] parentKeys) {
           return educationExperienceDao.findByResumeIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
         }
       });
    ObjectUtils.fillCollection(
            candidates,
       "id",
       "languageAbilities",
       "resumeId",
       new ObjectUtils.CollectionFetcher() {
         @Override
         public List fetch(Object[] parentKeys) {
           return languageAbilityDao.findByResumeIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
         }
       });
    ObjectUtils.fillCollection(
            candidates,
       "id",
       "certificates",
       "resumeId",
       new ObjectUtils.CollectionFetcher() {
         @Override
         public List fetch(Object[] parentKeys) {
           return certificateDao.findByResumeIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
         }
       });
    ObjectUtils.fillCollection(
            candidates,
       "id",
       "projectExperiences",
       "resumeId",
       new ObjectUtils.CollectionFetcher() {
         @Override
         public List fetch(Object[] parentKeys) {
           return projectExperienceDao.findByResumeIds(Arrays.asList(parentKeys).toArray(new Long[parentKeys.length]));
         }
       });*/
  }

}
