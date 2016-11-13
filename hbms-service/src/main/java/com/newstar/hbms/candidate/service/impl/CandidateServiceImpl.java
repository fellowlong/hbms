package com.newstar.hbms.candidate.service.impl;

import com.newstar.hbms.common.dao.AttachmentDao;
import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.domain.Domain;
import com.newstar.hbms.candidate.dao.*;
import com.newstar.hbms.candidate.domain.*;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.utils.WordParser;
import com.newstar.hbms.utils.business.ObjectUtils;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
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

  private AttachmentDao attachmentDao;

  private WorkExperienceDao workExperienceDao;

  private EducationExperienceDao educationExperienceDao;

  private LanguageAbilityDao languageAbilityDao;

  private CertificateDao certificateDao;

  private ProjectExperienceDao projectExperienceDao;

  private CandidateIndexTaskDao candidateIndexTaskDao;

  public void setCandidateDao(CandidateDao candidateDao) {
    this.candidateDao = candidateDao;
  }

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  public void setCertificateDao(CertificateDao certificateDao) {
    this.certificateDao = certificateDao;
  }

  public void setEducationExperienceDao(EducationExperienceDao educationExperienceDao) {
    this.educationExperienceDao = educationExperienceDao;
  }

  public void setLanguageAbilityDao(LanguageAbilityDao languageAbilityDao) {
    this.languageAbilityDao = languageAbilityDao;
  }

  public void setProjectExperienceDao(ProjectExperienceDao projectExperienceDao) {
    this.projectExperienceDao = projectExperienceDao;
  }

  public void setWorkExperienceDao(WorkExperienceDao workExperienceDao) {
    this.workExperienceDao = workExperienceDao;
  }

  public void setCandidateIndexTaskDao(CandidateIndexTaskDao candidateIndexTaskDao) {
    this.candidateIndexTaskDao = candidateIndexTaskDao;
  }

  public void setAttachmentDao(AttachmentDao attachmentDao) {
    this.attachmentDao = attachmentDao;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Candidate candidate) throws IOException {
    int resultCount = 0;
    if (candidate.getId() != null) {
      resultCount = candidateDao.update(candidate);
    } else {
      resultCount = candidateDao.insert(candidate);
    }
    if (candidate.getResumeFile() != null) {
      String fileName = candidate.getResumeFile().getOriginalFilename();
      Attachment attachment = new Attachment();
      attachment.setBusinessId(candidate.getId());
      attachment.setBusinessBigType("Candidate");
      attachment.setBusinessSmallType("Resume");
      String textResume = WordParser.getText(
          candidate.getResumeFile().getInputStream(),
          WordParser.getVersion(fileName));
      attachment.setFileName(fileName);
      attachment.setFileBinaryData(candidate.getResumeFile().getBytes());
      attachment.setFileStringData(textResume);
      attachment.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
      attachment.setRemark("Candidate Resume");
      resultCount += attachmentDao.insert(attachment);
      //===========
      Resume resume = new Resume();
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
        attachment.setBusinessId(candidate.getId());
        attachment.setBusinessBigType("Candidate");
        attachment.setBusinessSmallType("OtherAttachment");
        String fileName = attachmentFile.getOriginalFilename();
        attachment.setFileName(fileName);
        attachment.setFileBinaryData(attachmentFile.getBytes());
        attachment.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
        attachment.setRemark("Candidate OtherAttachment");
        resultCount += attachmentDao.insert(attachment);
      }
    }

    //保存工作经历
    List<WorkExperience> workExperiences = candidate.getWorkExperiences();
    if (workExperiences != null && workExperiences.size() > 0) {
      Collections.sort(workExperiences, new Comparator<WorkExperience>() {
        @Override
        public int compare(WorkExperience o1, WorkExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (WorkExperience perWorkExperience : workExperiences) {
        perWorkExperience.setResumeId(candidate.getId());
        if (perWorkExperience.getId() == null
           && perWorkExperience.getCrud() != null && perWorkExperience.getCrud().equals(Domain.CRUD.CREATE)) {
          resultCount += workExperienceDao.insert(perWorkExperience);
        } else if (perWorkExperience.getId() != null
           && perWorkExperience.getCrud() != null && perWorkExperience.getCrud().equals(Domain.CRUD.UPDATE)){
          resultCount += workExperienceDao.update(perWorkExperience);
        }else if (perWorkExperience.getId() != null
           && perWorkExperience.getCrud() != null && perWorkExperience.getCrud().equals(Domain.CRUD.DELETE)){
          resultCount += workExperienceDao.deleteByIds(new Long[]{perWorkExperience.getId()});
        }
      }
    }
    //保存教育经历
    List<EducationExperience> educationExperiences = candidate.getEducationExperiences();
    if (educationExperiences != null && educationExperiences.size() > 0) {
      Collections.sort(educationExperiences, new Comparator<EducationExperience>() {
        @Override
        public int compare(EducationExperience o1, EducationExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (EducationExperience perEducationExperience : educationExperiences) {
        perEducationExperience.setResumeId(candidate.getId());
        if (perEducationExperience.getId() == null
           && perEducationExperience.getCrud() != null && perEducationExperience.getCrud().equals(Domain.CRUD.CREATE)) {
          resultCount += educationExperienceDao.insert(perEducationExperience);
        } else if (perEducationExperience.getId() != null
           && perEducationExperience.getCrud() != null && perEducationExperience.getCrud().equals(Domain.CRUD.UPDATE)){
          resultCount += educationExperienceDao.update(perEducationExperience);
        } else if (perEducationExperience.getId() != null
           && perEducationExperience.getCrud() != null && perEducationExperience.getCrud().equals(Domain.CRUD.DELETE)){
          resultCount += educationExperienceDao.deleteByIds(new Long[]{perEducationExperience.getId()});
        }
      }
    }
    //保存语言能力
    List<LanguageAbility> languageAbilities = candidate.getLanguageAbilities();
    if (languageAbilities != null && languageAbilities.size() > 0) {
      Collections.sort(languageAbilities, new Comparator<LanguageAbility>() {
        @Override
        public int compare(LanguageAbility o1, LanguageAbility o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (LanguageAbility perLanguageAbility : languageAbilities) {
        perLanguageAbility.setResumeId(candidate.getId());
        if (perLanguageAbility.getId() == null
           && perLanguageAbility.getCrud() != null && perLanguageAbility.getCrud().equals(Domain.CRUD.CREATE)) {
          resultCount += languageAbilityDao.insert(perLanguageAbility);
        } else if (perLanguageAbility.getId() != null
           && perLanguageAbility.getCrud() != null && perLanguageAbility.getCrud().equals(Domain.CRUD.UPDATE)){
          resultCount += languageAbilityDao.update(perLanguageAbility);
        } else if (perLanguageAbility.getId() != null
           && perLanguageAbility.getCrud() != null && perLanguageAbility.getCrud().equals(Domain.CRUD.DELETE)){
          resultCount += languageAbilityDao.deleteByIds(new Long[]{perLanguageAbility.getId()});
        }
      }
    }
    //保存证书
    List<Certificate> certificates = candidate.getCertificates();
    if (certificates != null && certificates.size() > 0) {
      Collections.sort(certificates, new Comparator<Certificate>() {
        @Override
        public int compare(Certificate o1, Certificate o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (Certificate perCertificate : certificates) {
        perCertificate.setResumeId(candidate.getId());
        if (perCertificate.getId() == null
           && perCertificate.getCrud() != null && perCertificate.getCrud().equals(Domain.CRUD.CREATE)) {
          resultCount += certificateDao.insert(perCertificate);
        } else if (perCertificate.getId() != null
           && perCertificate.getCrud() != null && perCertificate.getCrud().equals(Domain.CRUD.UPDATE)) {
          resultCount += certificateDao.update(perCertificate);
        } else if (perCertificate.getId() != null
           && perCertificate.getCrud() != null && perCertificate.getCrud().equals(Domain.CRUD.DELETE)) {
          resultCount += certificateDao.deleteByIds(new Long[]{perCertificate.getId()});
        }
      }
    }
    //保存项目经历
    List<ProjectExperience> projectExperiences = candidate.getProjectExperiences();
    if (projectExperiences != null && projectExperiences.size() > 0) {
      Collections.sort(projectExperiences, new Comparator<ProjectExperience>() {
        @Override
        public int compare(ProjectExperience o1, ProjectExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (ProjectExperience perProjectExperience : projectExperiences) {
        perProjectExperience.setResumeId(candidate.getId());
        if (perProjectExperience.getId() == null
           && perProjectExperience.getCrud() != null && perProjectExperience.getCrud().equals(Domain.CRUD.CREATE)) {
          resultCount += projectExperienceDao.insert(perProjectExperience);
        } else if (perProjectExperience.getId() != null
           && perProjectExperience.getCrud() != null && perProjectExperience.getCrud().equals(Domain.CRUD.UPDATE)) {
          resultCount += projectExperienceDao.update(perProjectExperience);
        } else if (perProjectExperience.getId() != null
           && perProjectExperience.getCrud() != null && perProjectExperience.getCrud().equals(Domain.CRUD.DELETE)) {
          resultCount += projectExperienceDao.deleteByIds(new Long[]{perProjectExperience.getId()});
        }
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
  public PagingResult<Candidate> findByBean(Candidate candidate, final PageRange pageRange) {
    PagingResult<Candidate> resumePagingResult = candidateDao.findByBean(candidate, pageRange);
    fillSubObjects(resumePagingResult.getRecords());
    return resumePagingResult;
  }

  @Override
  public List<Candidate> findByIds(Long[] ids) {
    List<Candidate> candidates = candidateDao.findByIds(ids);
    if (candidates != null) {
      List<Long> resumeIds = new ArrayList<Long>(candidates.size());
      Map<Long, Candidate> resumeMap = new HashMap<Long, Candidate>();
      for (Candidate candidate : candidates) {
        resumeIds.add(candidate.getId());
        resumeMap.put(candidate.getId(), candidate);
      }
      List<Resume> resumes = resumeDao.findByIds(
          resumeIds.toArray(new Long[resumeIds.size()]));
      for (Resume resume : resumes) {
        Candidate candidate = resumeMap.get(resume.getId());
        if (candidate != null) {
          candidate.setResume(resume);
        }
      }
    }
    fillSubObjects(candidates);
    return candidates;
  }

  private void fillSubObjects(List<Candidate> candidates) {
    ObjectUtils.fillCollection(
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
       });
  }

}
