package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.dao.ResumeDao;
import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.common.service.FileService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  private FileService fileService;

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Resume resume) throws IOException {
    int resultCount = (resume.getId() != null) ? resumeDao.update(resume) : resumeDao.insert(resume);
    if (resume.getAttachInputStream() != null && resume.getAttachUri() != null) {
      fileService.save(resume.getAttachInputStream(), resume.getAttachUri());
    }
    return resultCount;
  }


  @Override
  public int delete(Long id) {
    return resumeDao.delete(id);
  }

  @Override
  public PagingResult<Resume> findByBean(Resume resume, PageRange pageRange) {
    return resumeDao.findByBean(resume, pageRange);
  }
}
