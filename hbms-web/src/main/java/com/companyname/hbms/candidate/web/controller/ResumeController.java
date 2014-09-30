package com.companyname.hbms.candidate.web.controller;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.common.service.CommonService;
import com.companyname.hbms.mvc.MessageCollector;
import com.companyname.hbms.utils.FileUtils;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    if (resumePagingResult != null && resumePagingResult.getRecords() != null) {
      for (Resume perResume : resumePagingResult.getRecords()) {
        perResume.setAttachUri(FileUtils.decodeFileName(perResume.getAttachUri().substring(1)));
      }
    }
    WebUtils.writeForEasyUIDataGrid(request, response, resumePagingResult, true);
  }


  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Resume resume = new Resume();
    WebUtils.bindParameterWithFile(request, resume);
    resume.setAttachUri("/" + FileUtils.encodeFileName(resume.getAttachUri(), commonService.getCurrentDate()));
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
    int resultCount = resumeService.deleteByIds(WebUtils.getLongArrayBySpearator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }
}
