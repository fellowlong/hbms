package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.common.service.FileService;
import com.companyname.hbms.resume.dao.*;
import com.companyname.hbms.resume.domain.*;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.business.ObjectUtils;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

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

  private FileService fileService;

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

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Resume resume) throws IOException {
    int resultCount = (resume.getId() != null) ? resumeDao.update(resume) : resumeDao.insert(resume);
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
        if (perWorkExperience.getId() == null) {
          resultCount += workExperienceDao.insert(perWorkExperience);
        } else {
          resultCount += workExperienceDao.update(perWorkExperience);
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
        if (perEducationExperience.getId() == null) {
          resultCount += educationExperienceDao.insert(perEducationExperience);
        } else {
          resultCount += educationExperienceDao.update(perEducationExperience);
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
        if (perLanguageAbility.getId() == null) {
          resultCount += languageAbilityDao.insert(perLanguageAbility);
        } else {
          resultCount += languageAbilityDao.update(perLanguageAbility);
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
        if (perCertificate.getId() == null) {
          resultCount += certificateDao.insert(perCertificate);
        } else {
          resultCount += certificateDao.update(perCertificate);
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
        if (perProjectExperience.getId() == null) {
          resultCount += projectExperienceDao.insert(perProjectExperience);
        } else {
          resultCount += projectExperienceDao.update(perProjectExperience);
        }
      }
    }
    //保存原始附件
    if (resume.getOriginalResumeInputStream() != null && resume.getOriginalResumeInputStream() != null) {
      fileService.save(resume.getOriginalResumeInputStream(), resume.getOriginalResumeUri());
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
