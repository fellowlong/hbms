package com.newstar.hbms.mvc;

import com.newstar.hbms.utils.DateEditor;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjinsi on 2016/11/12.
 */
public class ConfigurableMultiActionController extends MultiActionController {

  private DateEditor dateEditor = new DateEditor();

  public class IgnoreEmptyServletRequestDataBinder extends ServletRequestDataBinder {

    public IgnoreEmptyServletRequestDataBinder(Object target) {
      super(target);
    }

    public IgnoreEmptyServletRequestDataBinder(Object target, String objectName) {
      super(target, objectName);
    }

    @Override
    protected void doBind(MutablePropertyValues mpvs) {
      for (PropertyValue pv : mpvs.getPropertyValues()) {
        if (pv.getValue() == null
            || (pv.getValue() instanceof String && ((String)pv.getValue()).trim().isEmpty())) {
          //空值及空字符串
          mpvs.removePropertyValue(pv);
        } else if (pv.getValue() instanceof MultipartFile) {
          //空文件
          MultipartFile multipartFile = (MultipartFile) pv.getValue();
          if (multipartFile.isEmpty() || multipartFile.getOriginalFilename() == null || multipartFile.getOriginalFilename().trim().isEmpty()) {
            mpvs.removePropertyValue(pv);
          }
        }
      }
      super.doBind(mpvs);
    }
  }

  @Override
  protected ServletRequestDataBinder createBinder(HttpServletRequest request, Object command) throws Exception {
    ServletRequestDataBinder dataBinder = new IgnoreEmptyServletRequestDataBinder(command, getCommandName(command));
    initBinder(request, dataBinder);
    return dataBinder;
  }

  @Override
  protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    binder.registerCustomEditor(Date.class, dateEditor);
    super.initBinder(request, binder);
  }

}
