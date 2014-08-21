package com.companyname.hbms.resume.web.controller;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingParameter;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
                   PagingParameter pagingParameter) throws Exception {
    Resume resume = new Resume();
    resume.setYn(Boolean.TRUE);
    pagingParameter.setParameter(resume);
    PagingResult<Resume> resumes = resumeService.findByBean(pagingParameter);
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
