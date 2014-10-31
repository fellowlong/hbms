package com.companyname.hbms.system.web.controller;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.system.domain.Authority;
import com.companyname.hbms.system.domain.Model;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class WorkPanelController extends MultiActionController {


  public ModelAndView workPanel(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map<String, Object> modelMap = new HashMap<String, Object>();
    Authority authority1 = new Authority();
    authority1.setId(1L);
    authority1.setCode("ResumeList");
    authority1.setName("简历列表");
    authority1.setUri("/resume/findByBean.do");
    Authority authority2 = new Authority();
    authority2.setId(1L);
    authority2.setCode("ResumeList");
    authority2.setName("简历列表");
    authority2.setUri("/resume/findByBean.do");
    Authority authority3 = new Authority();
    authority3.setId(1L);
    authority3.setCode("ResumeList");
    authority3.setName("简历列表");
    authority3.setUri("/resume/findByBean.do");
    Authority authority4 = new Authority();
    authority4.setId(1L);
    authority4.setCode("ResumeList");
    authority4.setName("简历列表");
    authority4.setUri("/resume/findByBean.do");
    Authority authority5 = new Authority();
    authority5.setId(1L);
    authority5.setCode("ResumeList");
    authority5.setName("简历列表");
    authority5.setUri("/resume/findByBean.do");
    Model model1 = new Model();
    model1.setId(1L);
    model1.setName("简历管理");
    model1.getAuthorities().add(authority1);
    model1.getAuthorities().add(authority2);
    model1.getAuthorities().add(authority3);
    Model model2 = new Model();
    model2.setId(2L);
    model2.setName("客户管理");
    model2.getAuthorities().add(authority4);
    model2.getAuthorities().add(authority5);
    modelMap.put("models", new Model[]{model1, model2});
    return new ModelAndView("/workPanel.ftl", modelMap);
  }

}
