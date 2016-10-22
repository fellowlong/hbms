package com.newstar.hbms.system.web.controller;

import com.newstar.hbms.system.domain.Authority;
import com.newstar.hbms.system.service.AuthorityService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class WorkPanelController implements Controller {

  private AuthorityService authorityService;

  public void setAuthorityService(AuthorityService authorityService) {
    this.authorityService = authorityService;
  }

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map<String, Object> modelMap = new HashMap<String, Object>();

    Authority authority1 = new Authority();
    authority1.setId(1L);
    authority1.setCode("ResumeList");
    authority1.setName("搜索简历");
    authority1.setUri("/resume/resumeSearch.do");

    Authority authority2 = new Authority();
    authority2.setId(1L);
    authority2.setCode("ResumeList");
    authority2.setName("新增简历");
    authority2.setUri("/resume/preInsertOrUpdate.do");

    Authority authority3 = new Authority();
    authority3.setId(1L);
    authority3.setCode("ResumeList");
    authority3.setName("导入简历");
    authority3.setUri("/resume/preImport.do");

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

    Authority module1 = new Authority();
    module1.setId(1L);
    module1.setName("简历管理");

    module1.getChildren().add(authority1);
    module1.getChildren().add(authority2);
    module1.getChildren().add(authority3);

    Authority module2 = new Authority();
    module2.setId(2L);
    module2.setName("客户管理");

    module2.getChildren().add(authority4);
    module2.getChildren().add(authority5);
/*
    modelMap.put("authorities", new Authority[]{module1, module2});

    Long moduleId = null;
    try {
      moduleId = Long.parseLong(request.getParameter("moduleId"));
    } catch (Exception e) {

    }
    Authority module = null;
    if (moduleId == module1.getId()) {
      module = module1;
    } else if (moduleId == module2.getId()) {
      module = module2;
    } else {
      module = null;
    }
    if (module != null) {
      modelMap.put("module", module);
    }*/
    modelMap.put("authorities", authorityService.findAllTree());
    modelMap.put("currentAuthority", authorityService.findByUri(request.getRequestURI()));
    return new ModelAndView("/workspace", modelMap);
  }

}
