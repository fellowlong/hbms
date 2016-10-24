package com.newstar.hbms.customer;

import com.newstar.hbms.customer.domain.Customer;
import com.newstar.hbms.customer.service.CustomerService;
import com.newstar.hbms.mvc.JsonResult;
import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.JsonUtils;
import com.newstar.hbms.utils.WebUtils;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjinsi on 2016/10/22.
 */
public class CustomerController extends MultiActionController {

  private CustomerService customerService;

  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/customer/customerManager");
  }

  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response, Customer customer) throws Exception  {
    JsonResult jsonResult = new JsonResult();
    try {
      int resultCount = customerService.insertOrUpdate(customer);
      jsonResult.setSuccess(true);
      jsonResult.setData(resultCount);
    } catch (Throwable t) {
      logger.error("新增EventParserConfig失败", t);
      jsonResult.setErrorMessage(ExceptionUtils.getExceptionStack(t));
    }
    WebUtils.writeWithJson(response, jsonResult);
  }

  public void findByBean(HttpServletRequest request, HttpServletResponse response, Customer customer)
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
    PagingResult<Customer> customerResult = customerService.findByBean(customer, pageRange);
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

}
