package com.companyname.hbms.candidate.web.controller;

import com.companyname.hbms.mvc.MessageCollector;
import com.companyname.hbms.candidate.domain.Candidate;
import com.companyname.hbms.candidate.service.CandidateService;
import com.companyname.hbms.utils.DateEditor;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class CandidateController extends MultiActionController {

  private CandidateService candidateService;

  private DateEditor dateEditor;

  public void setCandidateService(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  public void setDateEditor(DateEditor dateEditor) {
    this.dateEditor = dateEditor;
  }

  public void findByBean(HttpServletRequest request,
                   HttpServletResponse response,
                   Candidate candidate) throws Exception {
    candidate.setYn(Boolean.TRUE);
    if(candidate.getLastOriginalResume() != null) {
      candidate.getLastOriginalResume().setYn(Boolean.TRUE);
    }
    if (candidate.getLastReportResume() != null) {
      candidate.getLastReportResume().setYn(Boolean.TRUE);
    }
    PagingResult<Candidate> candidates = candidateService.findByBean(candidate, WebUtils.getPageRange(request));
    WebUtils.writeForEasyUIDataGrid(request, response, candidates, true);

  }


  public void insertOrUpdate(HttpServletRequest request,
                     HttpServletResponse response,
                     Candidate candidate) throws Exception {
    int resultCount = 0;
    if(candidate.getId() == null)  {
      resultCount = candidateService.insert(candidate);
    } else {
      resultCount = candidateService.update(candidate);
    }
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    WebUtils.writeWithJson(response, msgCollector);
  }

  @Override
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    super.initBinder(request, binder);
    binder.registerCustomEditor(Date.class, dateEditor);
  }
}
