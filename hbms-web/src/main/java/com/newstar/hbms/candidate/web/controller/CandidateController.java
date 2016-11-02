package com.newstar.hbms.candidate.web.controller;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.common.service.CommonService;
import com.newstar.hbms.mvc.MessageCollector;
import com.newstar.hbms.candidate.service.ResumeService;
import com.newstar.hbms.utils.WebUtils;
import com.newstar.hbms.utils.paging.PagingResult;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class CandidateController extends MultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private ResumeService resumeService;

  private CommonService commonService;

  private HttpSolrServer httpSolrServer;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setCommonService(CommonService commonService) {
    this.commonService = commonService;
  }

  public void setHttpSolrServer(HttpSolrServer httpSolrServer) {
    this.httpSolrServer = httpSolrServer;
  }

  public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/resumeSimple/resumeIndex");
  }

  public ModelAndView findByBean(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Candidate candidate) throws Exception {
    candidate.setYn(Boolean.TRUE);
    PagingResult<Candidate> resumePagingResult = resumeService.findByBean(candidate, WebUtils.getPageRange(request));
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("resumePagingResult", resumePagingResult);
    return new ModelAndView("/resumeSimple/resumeList", model);
  }

  public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Candidate> candidates = resumeService.findByIds(new Long[]{WebUtils.getLong(request, WebUtils.ID)});
    ModelAndView modelAndView = new ModelAndView("/resumeSimple/resumeDetail");
    if (candidates != null && !candidates.isEmpty()) {
      modelAndView.getModel().put("resume", candidates.get(0));
    }
    return modelAndView;
  }

  public ModelAndView resumeAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/resumeSimple/resumeAdd");
  }


  public ModelAndView preInsertOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    String view = id == null ? "/resume/resumeAdd" : "/resume/resumeEdit";
    ModelAndView modelAndView = new ModelAndView(view);
    if (id != null) {
      List<Candidate> candidates = resumeService.findByIds(new Long[]{id});
      if (candidates != null && !candidates.isEmpty()) {
        modelAndView.getModel().put("resume", candidates.get(0));
      }
    }
    return modelAndView;
  }

  public ModelAndView insertOrUpdate(HttpServletRequest request, HttpServletResponse response,Candidate candidate2) throws Exception {
    Candidate candidate = new Candidate();
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    MultipartHttpServletRequest multipartHttpServletRequest = resolver.resolveMultipart(request);
    ServletRequestDataBinder servletRequestDataBinder = new ServletRequestDataBinder(candidate);
    servletRequestDataBinder.bind(multipartHttpServletRequest);
    boolean isNew = (candidate.getId() == null ? true : false);
    int resultCount = resumeService.insertOrUpdate(candidate);
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    ModelAndView modelAndView = new ModelAndView("/resumeSimple/resumeDetail");
    modelAndView.addObject("msgCollector", msgCollector);
    modelAndView.addObject("resume", candidate);
    return modelAndView;
  }

  public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int resultCount = resumeService.deleteByIds(WebUtils.getLongArrayBySeparator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }

  public ModelAndView resumeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView modelAndView = new ModelAndView("/resumeSimple/resumeSearch");
    String searchKeyword = request.getParameter("searchKeyword");
    if (searchKeyword != null && !searchKeyword.isEmpty()) {
      SolrQuery query = new SolrQuery();
      String[] searchFields = request.getParameterValues("searchFields");
      StringBuilder queryStr = new StringBuilder();
      StringBuilder hlFl = new StringBuilder();
      if (searchFields != null) {
        for (String searchField : searchFields) {
          if (searchField != null && !searchField.isEmpty()) {
            if (queryStr.length() > 0) {
              queryStr.append(" OR ");
              hlFl.append(",");
            }
            queryStr.append(searchField).append(":").append(searchKeyword);
            hlFl.append(searchField);
          }
        }
        query.setQuery(queryStr.toString());
      } else {
        query.setQuery("all:" + searchKeyword);
      }
      query.setHighlight(true);                //开启高亮
      query.setHighlightFragsize(50);          //返回的字符个数
      query.setHighlightRequireFieldMatch(true);
      query.setHighlightSimplePre("<em>");    //后缀
      query.setHighlightSimplePost("</em>");    //前缀
      query.setParam("hl.fl", "all," + hlFl.toString());      //高亮字段
      QueryResponse queryResponse = httpSolrServer.query(query);
      SolrDocumentList documents = queryResponse.getResults();
      Map<String, Map<String, List<String>>> highlights = queryResponse.getHighlighting();
      modelAndView.addObject("documents", documents);
      modelAndView.addObject("highlights", highlights);
    }
    return modelAndView;
  }

}
