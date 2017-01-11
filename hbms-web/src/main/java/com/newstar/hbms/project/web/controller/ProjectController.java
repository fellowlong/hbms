package com.newstar.hbms.project.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.customer.service.PositionService;
import com.newstar.hbms.mvc.JsonResult;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.DateEditor;
import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.JsonUtils;
import com.newstar.hbms.utils.WebUtils;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class ProjectController extends MultiActionController {

  private ProjectService projectService;

  private CompanyService companyService;

  private ContactService contactService;

  private PositionService positionService;

  private UserService userService;

  private String datePattern;

  public static Map<Class, List<String>> excludedProperties = new HashMap<Class, List<String>>(0);

  static {
    excludedProperties.put(TreeNode.class, Arrays.asList(new String[]{"children"}));
  }

  public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  public void setPositionService(PositionService positionService) {
    this.positionService = positionService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    PagingResult<Company> customerPagingResult = companyService.findByBean(new Company(), new PageRange(1, 100));
    ModelAndView modelAndView =new ModelAndView("/project/projectManager");
    modelAndView.addObject("companies", customerPagingResult.getRecords());
    modelAndView.addObject("users", customerPagingResult.getRecords());
    return modelAndView;
  }

  public ModelAndView editView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/project/projectEdit");
    if (id != null) {
      List<Project> projects = projectService.findByIds(new Long[]{id});
      if (projects != null && !projects.isEmpty()) {
        modelAndView.getModel().put("project", projects.get(0));
      }
    }
    PagingResult<Company> customerPagingResult = companyService.findByBean(new Company(), new PageRange(1, 1000));
    modelAndView.addObject("companies", customerPagingResult.getRecords());
    modelAndView.addObject("users", userService.findAll());
    return modelAndView;
  }

  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response, Project project) throws Exception  {
    JsonResult jsonResult = new JsonResult();
    try {
      int resultCount = projectService.insertOrUpdate(project);
      jsonResult.setSuccess(true);
      jsonResult.setData(resultCount);
    } catch (Throwable t) {
      logger.error("新增Position失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void disableByIds(HttpServletRequest request, HttpServletResponse response)
          throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      List<Long> ids = new ArrayList<Long>();
      String[] idsStrArray = request.getParameterValues("ids[]");
      if (idsStrArray != null && idsStrArray.length > 0) {
        for (String idsStr : idsStrArray) {
          ids.add(new Long(idsStr));
        }
        int result = positionService.disable(ids.toArray(new Long[ids.size()]));
        if (result > 0) {
          jsonResult.setSuccess(true);
          jsonResult.setData(result);
        }
      }
    } catch (Throwable t) {
      logger.error("删除Position失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void findById(HttpServletRequest request, HttpServletResponse response, Project project)
          throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      List<Project> positions = projectService.findByIds(new Long[]{project.getId()});
      if (positions != null && positions.size() == 1) {
        jsonResult.setSuccess(true);
        jsonResult.setData(positions.get(0));
      } else {
        jsonResult.setSuccess(false);
        jsonResult.setErrorMessage("没有找到客户");
      }
    } catch (Throwable t) {
      logger.error("查询Position失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonResult, excludedProperties));
  }

  public void findByBean(HttpServletRequest request, HttpServletResponse response, Project project)
          throws Exception {
    String pageSize = request.getParameter("rows");
    String pageNum = request.getParameter("page");
    PageRange pageRange = new PageRange();
    if (pageSize != null) {
      pageRange.setPageSize(Integer.parseInt(pageSize));
    }
    if (pageNum != null) {
      pageRange.setPageNum(Integer.parseInt(pageNum));
    }
    PagingResult<Project> positionResult = projectService.findByBean(project, pageRange);
    Map<String, Object> jsonMap = new HashMap();
    jsonMap.put("page", pageNum);
    jsonMap.put("total ", positionResult.getPageTotal());
    jsonMap.put("records ", positionResult.getRecordTotal());
    if (positionResult.getRecords() != null) {
      jsonMap.put("rows", positionResult.getRecords().toArray());
    } else {
      jsonMap.put("rows", null);
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap, excludedProperties));
  }

  @Override
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    super.initBinder(request, binder);
    binder.registerCustomEditor(Date.class, new DateEditor(datePattern));
  }

  public void setDatePattern(String datePattern) {
    this.datePattern = datePattern;
  }
}
