package com.newstar.hbms.mvc;

import com.newstar.hbms.utils.DateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wangjinsi on 2016/11/12.
 */
public class ConfigurableMultiActionController extends MultiActionController {

  private DateEditor dateEditor = new DateEditor();

  @Override
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(Date.class, dateEditor);
    super.initBinder(request, binder);
  }
}
