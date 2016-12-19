package com.newstar.hbms.customer.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.CompanyFolder;
import com.newstar.hbms.customer.domain.CompanyIndustry;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.mvc.JsonResult;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.JsonUtils;
import com.newstar.hbms.utils.WebUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class CompanyController extends MultiActionController {

  private CompanyService companyService;

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/customer/companyManager");
  }

  public ModelAndView editView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/customer/companyEdit");
    if (id != null) {
      List<Company> companies = companyService.findByIds(new Long[]{id});
      if (companies != null && !companies.isEmpty()) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if (companies.get(0).getIndustries() != null) {
          for (CompanyIndustry companyIndustry : companies.get(0).getIndustries()) {
            treeNodes.add(companyIndustry.getIndustry());
          }
        }
        if (companies.get(0).getFolders() != null) {
          for (CompanyFolder companyFolder : companies.get(0).getFolders()) {
            treeNodes.add(companyFolder.getFolder());
          }
        }
        removeTreeNodeChildren(treeNodes);
        modelAndView.getModel().put("company", companies.get(0));
      }
    }
    return modelAndView;
  }

  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response, Company company) throws Exception  {
    JsonResult jsonResult = new JsonResult();
    try {
      int resultCount = companyService.insertOrUpdate(company);
      jsonResult.setSuccess(true);
      jsonResult.setData(resultCount);
    } catch (Throwable t) {
      logger.error("新增Customer失败", t);
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
        int result = companyService.disable(ids.toArray(new Long[ids.size()]));
        if (result > 0) {
          jsonResult.setSuccess(true);
          jsonResult.setData(result);
        }
      }
    } catch (Throwable t) {
      logger.error("删除Customer失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void findById(HttpServletRequest request, HttpServletResponse response, Company company)
          throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      List<Company> companies = companyService.findByIds(new Long[]{company.getId()});
      if (companies != null && companies.size() == 1) {
        jsonResult.setSuccess(true);
        jsonResult.setData(companies.get(0));
      } else {
        jsonResult.setSuccess(false);
        jsonResult.setErrorMessage("没有找到客户");
      }
    } catch (Throwable t) {
      logger.error("查询Customer失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void findByBean(HttpServletRequest request, HttpServletResponse response, Company company)
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
    PagingResult<Company> customerResult = companyService.findByBean(company, pageRange);
    List<TreeNode> treeNodes = new ArrayList<TreeNode>();
    if (customerResult.getRecords() != null) {
      for (Company perCompany : customerResult.getRecords()) {
        if(perCompany.getCompanyType() != null) {
          treeNodes.add(perCompany.getCompanyType());
        }
        if(perCompany.getCity() != null) {
          treeNodes.add(perCompany.getCity());
        }
        if(perCompany.getNature() != null) {
          treeNodes.add(perCompany.getNature());
        }
        if(perCompany.getPropertyRightStructure() != null) {
          treeNodes.add(perCompany.getPropertyRightStructure());
        }
        if (perCompany.getIndustries() != null) {
          for (CompanyIndustry companyIndustry : perCompany.getIndustries()) {
            treeNodes.add(companyIndustry.getIndustry());
          }
        }
        if (perCompany.getFolders() != null) {
          for (CompanyFolder companyFolder : perCompany.getFolders()) {
            treeNodes.add(companyFolder.getFolder());
          }
        }
      }
    }
    removeTreeNodeChildren(treeNodes);
    Map<String, Object> jsonMap = new HashMap();
    jsonMap.put("page", pageNum);
    jsonMap.put("total ", customerResult.getPageTotal());
    jsonMap.put("records ", customerResult.getRecordTotal());
    if (customerResult.getRecords() != null) {
      jsonMap.put("rows", customerResult.getRecords().toArray());
    } else {
      jsonMap.put("rows", null);
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap));
  }

  private void removeTreeNodeChildren(List<TreeNode> treeNodes) {
    if (treeNodes != null) {
      for (TreeNode treeNode : treeNodes) {
        treeNode.setChildren(null);
        if (treeNode.getParent() != null) {
          removeTreeNodeChildren(Arrays.asList(new TreeNode[]{treeNode.getParent()}));
        }
      }
    }
  }

}
