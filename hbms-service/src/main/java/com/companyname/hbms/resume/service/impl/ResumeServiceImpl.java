package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.basedata.dao.ListItemDao;
import com.companyname.hbms.candidate.dao.CandidateDao;
import com.companyname.hbms.common.service.FileService;
import com.companyname.hbms.resume.dao.*;
import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.business.ObjectUtils;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  private CertificateDao certificateDao;

  private EducationExperienceDao educationExperienceDao;

  private LanguageAbilityDao languageAbilityDao;

  private ProjectExperienceDao projectExperienceDao;

  private WorkExperienceDao workExperienceDao;

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
  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange) {
    PagingResult<Resume> resumes = resumeDao.findByBean(resume, pageRange);
    ObjectUtils.fillAssociationByKey(
       resumes.getRecords(),
       "candidateId",
       "candidate",
       "id",
       new ObjectUtils.AssociationFetcher() {
         @Override
         public List fetch(Object[] associationKeys) {
           return candidateDao.findByIds(Arrays.asList(keys).toArray(new Long[keys.length]));
         }
       });
    ObjectUtils.fillAssociationByKey(
       resumes.getRecords(),
       "languageId",
       "language",
       "id",
       new ObjectUtils.AssociationFetcher() {
         @Override
         public List fetch(Object[] associationKeys) {
           return listItemDao.findByIds(Arrays.asList(keys).toArray(new Long[keys.length]));
         }
       });
    return resumes;
  }

  @Override
  public List<Resume> findByIds(Long[] ids) {
    return null;
  }
}
