package com.newstar.hbms.resume.service.impl;

import com.newstar.hbms.common.domain.Domain;
import com.newstar.hbms.common.service.CommonService;
import com.newstar.hbms.common.service.FileService;
import com.newstar.hbms.resume.dao.*;
import com.newstar.hbms.resume.domain.*;
import com.newstar.hbms.resume.service.ResumeService;
import com.newstar.hbms.utils.FileUtils;
import com.newstar.hbms.utils.IOUtils;
import com.newstar.hbms.utils.WordParser;
import com.newstar.hbms.utils.business.ObjectUtils;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  private WorkExperienceDao workExperienceDao;

  private EducationExperienceDao educationExperienceDao;

  private LanguageAbilityDao languageAbilityDao;

  private CertificateDao certificateDao;

  private ProjectExperienceDao projectExperienceDao;

  private CommonService commonService;

  private FileService fileService;

  private String originalResumeSavePathPrefix;

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

  public void setCommonService(CommonService commonService) {
    this.commonService = commonService;
  }

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  public void setOriginalResumeSavePathPrefix(String originalResumeSavePathPrefix) {
    this.originalResumeSavePathPrefix = originalResumeSavePathPrefix;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Resume resume) throws IOException {
    if (resume.getOriginalResumeName() != null
        && !resume.getOriginalResumeName().isEmpty()
        && resume.getOriginalResumeInputStream() != null) {
      String encodedFileName = FileUtils.encodeFileName(
         resume.getOriginalResumeName(), commonService.getCurrentDate());
      resume.setOriginalResumeUri(originalResumeSavePathPrefix + encodedFileName);
      if (!resume.getOriginalResumeInputStream().markSupported()) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(resume.getOriginalResumeInputStream(), byteArrayOutputStream);
        resume.setOriginalResumeInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
      }
      resume.setOriginalResumeText(
         WordParser.getText(resume.getOriginalResumeInputStream(), WordParser.getVersion(resume.getOriginalResumeName())));
      resume.getOriginalResumeInputStream().reset();
    }
    int resultCount = (resume.getId() != null) ? resumeDao.update(resume) : resumeDao.insert(resume);
    //保存原始附件
    if (resume.getOriginalResumeName() != null
       && !resume.getOriginalResumeName().isEmpty()
       && resume.getOriginalResumeInputStream() != null) {
      fileService.save(
         resume.getOriginalResumeInputStream(),
         resume.getOriginalResumeUri());
      resume.getOriginalResumeInputStream().reset();
    }
    //保存工作经历
    List<WorkExperience> workExperiences = resume.getWorkExperiences();
    if (workExperiences != null && workExperiences.size() > 0) {
      Collections.sort(workExperiences, new Comparator<WorkExperience>() {
        @Override
        public int compare(WorkExperience o1, WorkExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (WorkExperience perWorkExperience : workExperiences) {
        perWorkExperience.setResumeId(resume.getId());
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
    List<EducationExperience> educationExperiences = resume.getEducationExperiences();
    if (educationExperiences != null && educationExperiences.size() > 0) {
      Collections.sort(educationExperiences, new Comparator<EducationExperience>() {
        @Override
        public int compare(EducationExperience o1, EducationExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (EducationExperience perEducationExperience : educationExperiences) {
        perEducationExperience.setResumeId(resume.getId());
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
    List<LanguageAbility> languageAbilities = resume.getLanguageAbilities();
    if (languageAbilities != null && languageAbilities.size() > 0) {
      Collections.sort(languageAbilities, new Comparator<LanguageAbility>() {
        @Override
        public int compare(LanguageAbility o1, LanguageAbility o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (LanguageAbility perLanguageAbility : languageAbilities) {
        perLanguageAbility.setResumeId(resume.getId());
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
    List<Certificate> certificates = resume.getCertificates();
    if (certificates != null && certificates.size() > 0) {
      Collections.sort(certificates, new Comparator<Certificate>() {
        @Override
        public int compare(Certificate o1, Certificate o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (Certificate perCertificate : certificates) {
        perCertificate.setResumeId(resume.getId());
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
    List<ProjectExperience> projectExperiences = resume.getProjectExperiences();
    if (projectExperiences != null && projectExperiences.size() > 0) {
      Collections.sort(projectExperiences, new Comparator<ProjectExperience>() {
        @Override
        public int compare(ProjectExperience o1, ProjectExperience o2) {
          return (o1.getId() == null || o2.getId() == null) ? -1 : o1.getId().compareTo(o2.getId());
        }
      });
      for (ProjectExperience perProjectExperience : projectExperiences) {
        perProjectExperience.setResumeId(resume.getId());
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
    return resultCount;
  }


  @Override
  public int deleteByIds(Long[] resumeIds) {
    return resumeDao.deleteByIds(resumeIds);
  }

  @Override
  public PagingResult<Resume> findByBean(Resume resume, final PageRange pageRange) {
    PagingResult<Resume> resumePagingResult = resumeDao.findByBean(resume, pageRange);
    fillSubObjects(resumePagingResult.getRecords());
    return resumePagingResult;
  }

  @Override
  public List<Resume> findByIds(Long[] ids) {
    List<Resume> resumes = resumeDao.findByIds(ids);
    fillSubObjects(resumes);
    return resumes;
  }

  private void fillSubObjects(List<Resume> resumes) {
    ObjectUtils.fillCollection(
       resumes,
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
       resumes,
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
       resumes,
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
       resumes,
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
       resumes,
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
