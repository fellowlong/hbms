package com.newstar.hbms.system.web.controller;

import com.newstar.hbms.system.domain.Authority;
import com.newstar.hbms.system.service.AuthorityService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class WorkPanelController implements Controller {

  private AuthorityService authorityService;

  public void setAuthorityService(AuthorityService authorityService) {
    this.authorityService = authorityService;
  }

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map<String, Object> modelMap = new HashMap<String, Object>();
    modelMap.put("authorities", authorityService.findAllTree());
    modelMap.put("currentAuthority", authorityService.findByUri(request.getRequestURI()));
    return new ModelAndView("/workspaceSimple", modelMap);
  }

}
