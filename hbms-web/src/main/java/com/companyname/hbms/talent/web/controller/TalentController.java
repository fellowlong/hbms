package com.companyname.hbms.talent.web.controller;

import com.companyname.hbms.talent.domain.Talent;
import com.companyname.hbms.talent.service.TalentService;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

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
                   Talent talent) throws Exception {
    talent.setYn(Boolean.TRUE);
    if(talent.getLastOriginalResume() != null) {
      talent.getLastOriginalResume().setYn(Boolean.TRUE);
    }
    if (talent.getLastReportResume() != null) {
      talent.getLastReportResume().setYn(Boolean.TRUE);
    }
    List<Talent> talents = talentService.findByBean(talent);
    WebUtils.writeWithJson(response, talents);

  }


  public void insert(HttpServletRequest request,
                     HttpServletResponse response,
                     Talent talent) throws Exception {
    int count = talentService.insert(talent);
    WebUtils.writeWithJson(response, count);
  }

}
