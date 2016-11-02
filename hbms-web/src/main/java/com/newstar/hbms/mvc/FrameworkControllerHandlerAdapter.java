package com.newstar.hbms.mvc;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by wangjinsi on 2016/10/4.
 */
public class FrameworkControllerHandlerAdapter extends SimpleControllerHandlerAdapter {


  private final String requestName = "request";
  private final String sessionName = "session";
  private final String applicationName = "application";
  private final String contextPathName = "contextPath";
  private final String paramName = "param";
  private final String paramValuesName = "paramValues";
  private final String headerName = "header";
  private final String requestUri = "requestUri";

  private List<String> workUris;

  private final static String workViewName = "workView";

  private Controller workPanelController;

  private Map<String, Object> exportMap;

  @Override
  public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    ModelAndView resultMav = null;
    ModelAndView workMav = super.handle(request, response, handler);
    String uri = request.getRequestURI();
    if (workMav != null && workUris != null && workUris.contains(uri)) {
      resultMav = workPanelController.handleRequest(request, response);
      if (workMav != null) {
        resultMav.addAllObjects(workMav.getModel());
        resultMav.addObject(workViewName, workMav.getViewName());
      }
    } else {
      resultMav = workMav;
    }
    if (resultMav != null && resultMav.getModel() != null ) {
      putContextVariables(request, resultMav.getModel());
    }
    return resultMav;
  }

  private void putContextVariables(HttpServletRequest request, Map<String, Object> model) {
    //request response
    model.put(requestName, request);
    model.put(sessionName, request.getSession());
    model.put(applicationName, request.getSession().getServletContext());
    //contextPath
    String contextPath = request.getContextPath();
    if(!StringUtils.hasLength(contextPath)) {
      contextPath = "";
    }
    model.put(contextPathName, contextPath);
    //parameters
    Map<String, Object> parameterMap = new HashMap<String, Object>();
    Enumeration<String> parameterNames = request.getParameterNames();
    while(parameterNames.hasMoreElements()) {
      String parameterName = parameterNames.nextElement();
      parameterMap.put(parameterName, request.getParameter(parameterName));
    }
    model.put(paramName, parameterMap);
    model.put(paramValuesName, request.getParameterMap());
    //headers
    Enumeration<String> headerNames = request.getHeaderNames();
    Map<String, String> headerMap = new HashMap<String, String>();
    while(headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      headerMap.put(headerName.replaceAll("\\.", "_"), request.getHeader(headerName));
    }
    model.put(headerName, headerMap);
    //
    model.put(requestUri, request.getRequestURI());
    //
    if (exportMap != null) {
      model.putAll(exportMap);
    }
  }

  public void setWorkUris(List<String> workUris) {
    this.workUris = workUris;
  }

  public void setWorkPanelController(Controller workPanelController) {
    this.workPanelController = workPanelController;
  }

  public void setExportMap(Map<String, Object> exportMap) {
    this.exportMap = exportMap;
  }
}
