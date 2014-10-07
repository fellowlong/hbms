package com.companyname.hbms.resume.web.controller;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.common.service.CommonService;
import com.companyname.hbms.mvc.MessageCollector;
import com.companyname.hbms.utils.FileUtils;
import com.companyname.hbms.utils.IOUtils;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeController extends MultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private ResumeService resumeService;

  private CommonService commonService;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setCommonService(CommonService commonService) {
    this.commonService = commonService;
  }

  public void findByBean(HttpServletRequest request,
                   HttpServletResponse response,
                   Resume resume) throws Exception {
    resume.setYn(Boolean.TRUE);
    PagingResult<Resume> resumePagingResult = resumeService.findByBean(resume, WebUtils.getPageRange(request));
    WebUtils.writeForEasyUIDataGrid(request, response, resumePagingResult, true);
  }


  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Resume resume = new Resume();
    WebUtils.bindParameterWithFile(request, resume);
    int resultCount = resumeService.insertOrUpdate(resume);
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    WebUtils.writeWithJson(response, msgCollector);
  }

  public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int resultCount = resumeService.deleteByIds(WebUtils.getLongArrayBySeparator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }
}
