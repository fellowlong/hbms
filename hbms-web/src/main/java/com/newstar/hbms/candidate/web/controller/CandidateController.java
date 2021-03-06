package com.newstar.hbms.candidate.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.candidate.service.CandidateService;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.mvc.JsonResult;
import com.newstar.hbms.mvc.MessageCollector;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.domain.ProjectCandidate;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.JsonUtils;
import com.newstar.hbms.utils.WebUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class CandidateController extends ConfigurableMultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private CandidateService candidateService;

  private HttpSolrServer httpSolrServer;

  private UserService userService;

  private ProjectService projectService;

  public void setCandidateService(CandidateService candidateService) {
    this.candidateService = candidateService;
  }

  public void setHttpSolrServer(HttpSolrServer httpSolrServer) {
    this.httpSolrServer = httpSolrServer;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }

  public static Map<Class, List<String>> excludedProperties = new HashMap<Class, List<String>>(0);

  static {
    excludedProperties.put(TreeNode.class, Arrays.asList(new String[]{"children"}));
  }

  public ModelAndView workspace(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Candidate candidate) throws Exception {
    ModelAndView modelAndView = new ModelAndView("/candidate/candidateManage");
    modelAndView.addObject("operationType", "MANAGE");
    return modelAndView;
  }

  public ModelAndView select(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Candidate candidate) throws Exception {
    ModelAndView modelAndView = new ModelAndView("/candidate/candidateManage");
    modelAndView.addObject("operationType", "SELECT");
    return modelAndView;
  }

  public void findByBean(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Candidate candidate) throws Exception {
    candidate.setYn(Boolean.TRUE);
    String pageSize = request.getParameter("rows");
    String pageNum = request.getParameter("page");
    PageRange pageRange = new PageRange();
    if (pageSize != null) {
      pageRange.setPageSize(Integer.parseInt(pageSize));
    }
    if (pageNum != null) {
      pageRange.setPageNum(Integer.parseInt(pageNum));
    }
    PagingResult<Candidate> candidateResult = candidateService.findByBean(candidate, pageRange);
    Map<String, Object> jsonMap = new HashMap();
    jsonMap.put("page", pageNum);
    jsonMap.put("total ", candidateResult.getPageTotal());
    jsonMap.put("records ", candidateResult.getRecordTotal());
    if (candidateResult.getRecords() != null) {
      jsonMap.put("rows", candidateResult.getRecords().toArray());
    } else {
      jsonMap.put("rows", null);
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap, excludedProperties));
  }

  public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Candidate> candidates = candidateService.findByIds(new Long[]{WebUtils.getLong(request, WebUtils.ID)});
    ModelAndView modelAndView = new ModelAndView("/resumeSimple/resumeDetail");
    if (candidates != null && !candidates.isEmpty()) {
      modelAndView.getModel().put("resume", candidates.get(0));
    }
    return modelAndView;
  }

  public ModelAndView editView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/candidate/candidateEdit");
    if (id != null) {
      List<Candidate> candidates = candidateService.findByIds(new Long[]{id});
      if (candidates != null && !candidates.isEmpty()) {
        modelAndView.getModel().put("candidate", candidates.get(0));
      }
    } else {
      Long projectId = WebUtils.getLong(request, "projectId");
      if (projectId != null) {
        List<Project> projects = projectService.findByIds(new Long[]{projectId});
        if (projects != null && !projects.isEmpty()) {
          modelAndView.getModel().put("project", projects.get(0));
        }
      }
    }
    modelAndView.addObject("users", userService.findAll());
    return modelAndView;
  }

  public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/candidate/candidateDetail");
    if (id != null) {
      List<Candidate> candidates = candidateService.findByIds(new Long[]{id});
      if (candidates != null && !candidates.isEmpty()) {
        modelAndView.getModel().put("candidate", candidates.get(0));
      }
    }
    return modelAndView;
  }

  public ModelAndView save(HttpServletRequest request, HttpServletResponse response, Candidate candidate) throws Exception {
    int resultCount = candidateService.insertOrUpdate(candidate);
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

  public void disableByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      List<Long> ids = new ArrayList<Long>();
      String[] idsStrArray = request.getParameterValues("ids[]");
      if (idsStrArray != null && idsStrArray.length > 0) {
        for (String idsStr : idsStrArray) {
          ids.add(new Long(idsStr));
        }
        int result = candidateService.disableByIds(ids.toArray(new Long[ids.size()]));
        if (result > 0) {
          jsonResult.setSuccess(true);
          jsonResult.setData(result);
        }
      }
    } catch (Throwable t) {
      logger.error("删除Candidate失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
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


  public void findProjectsByCandidateId(HttpServletRequest request,
                         HttpServletResponse response,
                         ProjectCandidate projectCandidate) throws Exception {
    String pageSize = request.getParameter("rows");
    String pageNum = request.getParameter("page");
    PageRange pageRange = new PageRange();
    if (pageSize != null) {
      pageRange.setPageSize(Integer.parseInt(pageSize));
    }
    if (pageNum != null) {
      pageRange.setPageNum(Integer.parseInt(pageNum));
    }
    PagingResult<ProjectCandidate> candidateResult = projectService.findProjectCandidatesByBean(projectCandidate, pageRange);
    Map<String, Object> jsonMap = new HashMap();
    jsonMap.put("page", pageNum);
    jsonMap.put("total ", candidateResult.getPageTotal());
    jsonMap.put("records ", candidateResult.getRecordTotal());
    if (candidateResult.getRecords() != null) {
      List<Project> projects = new ArrayList<Project>(candidateResult.getRecords().size());
      for (ProjectCandidate perProjectCandidate : candidateResult.getRecords()) {
        projects.add(perProjectCandidate.getProject());
      }
      jsonMap.put("rows", projects.toArray());
    } else {
      jsonMap.put("rows", null);
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap, excludedProperties));
  }
}
