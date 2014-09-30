package com.companyname.hbms.candidate.service.impl;

import com.companyname.hbms.candidate.dao.CandidateDao;
import com.companyname.hbms.candidate.dao.ResumeDao;
import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.common.service.FileService;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeServiceImpl implements ResumeService {

  private ResumeDao resumeDao;

  private CandidateDao candidateDao;

  private FileService fileService;

  public void setResumeDao(ResumeDao resumeDao) {
    this.resumeDao = resumeDao;
  }

  public void setCandidateDao(CandidateDao candidateDao) {
    this.candidateDao = candidateDao;
  }

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public int insertOrUpdate(Resume resume) throws IOException {
    int resultCount = (resume.getId() != null) ? resumeDao.update(resume) : resumeDao.insert(resume);
    if (resume.getAttachUriInputStream() != null && resume.getAttachUriInputStream() != null) {
      fileService.save(resume.getAttachUriInputStream(), resume.getAttachUri());
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
    if (resumes.getRecords() != null) {
      Map<Long, Object> keys = new HashMap<Long, Object>();
      for (Resume perResume : resumes.getRecords()) {
        keys.put(perResume.getCandidateId(), perResume.getCandidateId());
      }
      List<Candidate> candidates = candidateDao.findByIds(keys.keySet().toArray(new Long[keys.keySet().size()]));
      keys.clear();
      if (candidates != null) {
        for (Candidate candidate : candidates) {
          keys.put(candidate.getId(), candidate);
        }
      }
      for (Resume perResume : resumes.getRecords()) {
        perResume.setCandidate((Candidate) keys.get(perResume.getCandidateId()));
      }
    }
    return resumes;
  }
}
