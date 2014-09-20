package com.companyname.hbms.talent.web.controller;

import com.companyname.hbms.mvc.MessageCollector;
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


  public void insertOrUpdate(HttpServletRequest request,
                     HttpServletResponse response,
                     Talent talent) throws Exception {
    int resultCount = 0;
    if(talent.getId() == null)  {
      resultCount = talentService.insert(talent);
    } else {
      resultCount = talentService.update(talent);
    }
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    WebUtils.writeWithJson(response, msgCollector);
  }

}
