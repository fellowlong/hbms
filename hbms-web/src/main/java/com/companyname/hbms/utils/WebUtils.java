package com.companyname.hbms.utils;

import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: fellowlong
 * Date: 7/8/12
 * Time: 11:47 AM
 */
public abstract class WebUtils {

  public final static String ID = "id";

  public static Long getLong(HttpServletRequest request, String name) {
    String id = request.getParameter(name);
    return StringUtils.hasText(id) ? new Long(id) : null;
  }

  public static Boolean getBoolean(HttpServletRequest request, String name) {
    String id = request.getParameter(name);
    return StringUtils.hasText(id) ? new Boolean(id) : null;
  }

  public static void writeWithJson(HttpServletResponse response, Object value)
    throws Exception {
    if (value == null) {
      return;
    }
    String json = value instanceof String ? (String) value : JsonUtils.beanToJson(value);
    response.setContentType("text/json;charset=UTF-8");
    response.getWriter().write(json);
  }

  public static void writeWithHtml(HttpServletResponse response, Object value)
    throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    if (value == null) {
      return;
    }
    response.getWriter().write(JsonUtils.beanToJson(value));
  }

  public static String createJQGridData(PagingResult<?> pagingResult, String idProperty, String[] colNames) {
    StringBuilder content = new StringBuilder("{\"page\": \"" + pagingResult.getPageNum() + "\", \"total\": " + pagingResult.getPageTotal() + ", \"records\": " + pagingResult.getRecordTotal() + ", \"rows\": [");
    try {
      for (int i =0; i < pagingResult.getRecords().size(); i ++) {
        Object record = pagingResult.getRecords().get(i);
        if (record == null) {
          continue;
        }
        StringBuilder cell = new StringBuilder("[");
        for (int j = 0; colNames != null && j < colNames.length; j++) {
          String value = BeanUtils.getProperty(record, colNames[j].trim());
          cell.append((j > 0 ? "," : "") + "\"" + (value == null ? "" : value) + "\"");
        }
        cell.append("]");
        String idValue = BeanUtils.getProperty(record, idProperty.trim());
        content.append((i > 0 ? "," : "") + "{\"id\": \"" + (idValue == null ? "" : idValue) + "\", \"cell\":" + cell + "}");
      }
      content.append("]}");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return content.toString();
  }

}
