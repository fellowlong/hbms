package com.companyname.hbms.talent.web.controller;

import com.companyname.hbms.talent.domain.Resume;
import com.companyname.hbms.talent.service.ResumeService;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeController extends MultiActionController {

  private ResumeService resumeService;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void list(HttpServletRequest request,
                   HttpServletResponse response,
                   Resume resume) throws Exception {
    resume.setYn(Boolean.TRUE);
    PagingResult<Resume> resumes = resumeService.findByBean(resume, null);
    String json = WebUtils.createJQGridData(resumes, "id", request.getParameter("colNames").split(","));
    WebUtils.writeWithJson(response, json);
  }


  public void insert(HttpServletRequest request,
                     HttpServletResponse response,
                     Resume resume) throws Exception {
    int count = resumeService.insert(resume);
    WebUtils.writeWithJson(response, count);
  }

}
