package com.newstar.hbms.system.web.controller;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangjinsi on 2016/12/7.
 */
public class BaseDataController extends ConfigurableMultiActionController {

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/system/baseDataManager");
  }

}
