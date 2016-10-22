package com.newstar.hbms.customer;

import com.newstar.hbms.customer.service.CustomerService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
