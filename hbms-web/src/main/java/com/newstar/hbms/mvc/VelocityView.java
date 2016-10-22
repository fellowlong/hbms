package com.newstar.hbms.mvc;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjinsi on 2015-09-17.
 */
public class VelocityView extends org.springframework.web.servlet.view.velocity.VelocityView {


  protected void renderMergedTemplateModel(
      Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(model == null) {
      return;
    }

    super.renderMergedTemplateModel(model, request, response);
  }

}
