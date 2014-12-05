package com.companyname.hbms.common.web.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fellowlong on 2014-12-01.
 */
public class ViewController extends MultiActionController {

  private String prefix = "view";

  private String suffix = "ftl";

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String insertOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return request.getRequestURL().substring(prefix.length(), request.getRequestURL().lastIndexOf("")) + "." + suffix;
  }

}
