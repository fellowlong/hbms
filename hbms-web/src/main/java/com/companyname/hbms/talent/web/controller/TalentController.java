package com.companyname.hbms.talent.web.controller;

import com.companyname.hbms.talent.domain.Resume;
import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.talent.service.TalentService;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingParameter;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class TalentController extends MultiActionController {

  private TalentService talentService;

  public void setTalentService(TalentService talentService) {
    this.talentService = talentService;
  }

  public void list(HttpServletRequest request,
                   HttpServletResponse response,
                   PagingParameter pagingParameter) throws Exception {
    Resume resume = new Resume();
    resume.setYn(Boolean.TRUE);
    pagingParameter.setParameter(resume);
    PagingResult<Talent> resumes = talentService.findByBean(pagingParameter);
    String json = WebUtils.createJQGridData(resumes, "id", request.getParameter("colNames").split(","));
    WebUtils.writeWithJson(response, json);
  }


  public void insert(HttpServletRequest request,
                     HttpServletResponse response,
                     Talent talent) throws Exception {
    int count = talentService.insert(talent);
    WebUtils.writeWithJson(response, count);
  }

}
