package com.newstar.hbms.customer.web.controller;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.domain.Contact;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.customer.service.ContactService;
import com.newstar.hbms.mvc.JsonResult;
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
 * Created by fellowlong on 2016/10/22.
 */
public class ContactController extends MultiActionController {

  private ContactService contactService;

  private CompanyService companyService;

  private String datePattern;

  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  public void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    PagingResult<Company> companyPagingResult = companyService.findByBean(new Company(), new PageRange(1, 1000));
    return new ModelAndView("/customer/contactManager", "companies", companyPagingResult.getRecords());
  }

  public ModelAndView editView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/customer/contactEdit");
    if (id != null) {
      List<Contact> contacts = contactService.findByIds(new Long[]{id});
      if (contacts != null && !contacts.isEmpty()) {
        modelAndView.getModel().put("contact", contacts.get(0));
      }
    }
    PagingResult<Company> companyPagingResult = companyService.findByBean(new Company(), new PageRange(1, 1000));
    modelAndView.addObject("companies", companyPagingResult.getRecords());
    return modelAndView;
  }

  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response, Contact contact) throws Exception  {
    JsonResult jsonResult = new JsonResult();
    try {
      int resultCount = contactService.insertOrUpdate(contact);
      jsonResult.setSuccess(true);
      jsonResult.setData(resultCount);
    } catch (Throwable t) {
      logger.error("新增Contact失败", t);
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
        int result = contactService.disable(ids.toArray(new Long[ids.size()]));
        if (result > 0) {
          jsonResult.setSuccess(true);
          jsonResult.setData(result);
        }
      }
    } catch (Throwable t) {
      logger.error("删除Contact失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void findById(HttpServletRequest request, HttpServletResponse response, Contact contact)
          throws Exception {
    JsonResult jsonResult = new JsonResult();
    try {
      List<Contact> contacts = contactService.findByIds(new Long[]{contact.getId()});
      if (contacts != null && contacts.size() == 1) {
        jsonResult.setSuccess(true);
        jsonResult.setData(contacts.get(0));
      } else {
        jsonResult.setSuccess(false);
        jsonResult.setErrorMessage("没有找到客户");
      }
    } catch (Throwable t) {
      logger.error("查询Contact失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonResult));
  }

  public void findByBean(HttpServletRequest request, HttpServletResponse response, Contact contact)
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
    PagingResult<Contact> contactResult = contactService.findByBean(contact, pageRange);
    Map<String, Object> jsonMap = new HashMap();
    jsonMap.put("page", pageNum);
    jsonMap.put("total ", contactResult.getPageTotal());
    jsonMap.put("records ", contactResult.getRecordTotal());
    if (contactResult.getRecords() != null) {
      jsonMap.put("rows", contactResult.getRecords().toArray());
    } else {
      jsonMap.put("rows", null);
    }
    SerializeConfig.getGlobalInstance().addFilter(TreeNode.class, new PropertyFilter() {
      @Override
      public boolean apply(Object object, String name, Object value) {
        return name.equals("children") ? false : true;
      }

    });
    WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap));
  }

  public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    ModelAndView modelAndView = new ModelAndView("/customer/contactDetail");
    if (id != null) {
      List<Contact> contacts = contactService.findByIds(new Long[]{id});
      if (contacts != null && !contacts.isEmpty()) {
        modelAndView.getModel().put("contact", contacts.get(0));
      }
    }
    return modelAndView;
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
