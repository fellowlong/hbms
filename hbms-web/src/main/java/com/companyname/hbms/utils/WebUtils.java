package com.companyname.hbms.utils;

import com.companyname.hbms.utils.paging.PageRange;
import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
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

  public final static String SUCCESS = "SUCCESS";

  public final static String ERROR = "ERROR";

  private static JexlEngine jexlEngine = new JexlEngine();
  static {
    jexlEngine.setSilent(Boolean.TRUE);
  }

  public static Long[] getLongArrayBySpearator(HttpServletRequest request, String name, String spearator) {
    String strValue = request.getParameter(name);
    Long[] longArray = null;
    if (strValue != null) {
      String[] strArray = strValue.split(spearator);
      longArray = new Long[strArray.length];
      for (int i = 0 ; i < longArray.length ;i ++) {
        longArray[i] = new Long(strArray[i].trim());
      }
    }
    return longArray;
  }

  public static Long getLong(HttpServletRequest request, String name) {
    Long[] longArray = getLongArray(request, name);
    return longArray != null ? longArray[0] : null;
  }


  public static Long[] getLongArray(HttpServletRequest request, String name) {
    String[] longStrArray = request.getParameterValues(name);
    Long[] longs = null;
    if (longStrArray != null) {
      longs = new Long[longStrArray.length];
      for (int i = 0; i < longs.length; i ++) {
        if (StringUtils.hasText(longStrArray[i])) {
          longs[i] =  new Long(longStrArray[i]);
        }
      }
    }
    return longs;
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
    response.setContentType("application/json;charset=UTF-8");
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

  public static PageRange getPageRange(HttpServletRequest request) {
    Long pageNum = WebUtils.getLong(request, "page");
    Long pageSize = WebUtils.getLong(request, "rows");
    return new PageRange(
      pageNum == null ? 1 : pageNum.intValue(),
      pageSize == null ? 10 : pageSize.intValue());
  }

  public static void writeForEasyUIDataGrid(HttpServletRequest request,
                                            HttpServletResponse response,
                                            PagingResult<?> pagingResult) throws Exception{
    StringBuilder data = new StringBuilder("{\"total\":\"" + pagingResult.getRecordTotal() + "\",\"rows\":[");
    if (pagingResult.getRecords() != null && request.getParameter("columnFields") != null) {
      String[] columnFields = request.getParameter("columnFields").split(",");
      for (int i = 0; columnFields.length > 0 && i < pagingResult.getRecords().size(); i++) {
        MapContext jexlContext = new MapContext();
        jexlContext.set("record", pagingResult.getRecords().get(i));
        StringBuilder row = new StringBuilder("{");
        for (int j = 0; j < columnFields.length; j++) {
          if (columnFields[j] != null) {
            Object value = jexlEngine.createExpression("record." + columnFields[j].trim()).evaluate(jexlContext);
            if (value != null && value.toString().trim().length() > 0) {
              value = "\"" + columnFields[j].trim() + "\":\"" + value + "\"";
              row.append((j > 0 ? "," : "") + value);
            }
          }
        }
        row.append("}");
        data.append((i > 0 ? "," : "") + row);
      }
    }
    data.append("]}");
    writeWithJson(response, data.toString());
  }

  public static void writeForJQGrid(HttpServletRequest request,
                                    HttpServletResponse response,
                                    PagingResult<?> pagingResult,
                                    String idProperty) throws Exception{
    String colNamesParam = request.getParameter("colNames");
    String[] colNames = colNamesParam == null ? new String[0] : colNamesParam.split(",");
    StringBuilder content = new StringBuilder("{\"page\": \"" + pagingResult.getPageNum() + "\", \"total\": " + pagingResult.getPageTotal() + ", \"records\": " + pagingResult.getRecordTotal() + ", \"rows\": [");
    for (int i =0; i < pagingResult.getRecords().size(); i ++) {
      Object record = pagingResult.getRecords().get(i);
      if (record == null) {
        continue;
      }
      StringBuilder cell = new StringBuilder("[");
      for (int j = 0; colNames != null && j < colNames.length; j++) {
        Object value = null;
        if (colNames[j] != null) {
          //创建jexl对象
          Expression jexlExp = jexlEngine.createExpression("record." + colNames[j].trim());
          //将参数塞入MapContext以便表达式中应用这些参数
          MapContext jexlContext = new MapContext();
          jexlContext.set("record", record);
          value = jexlExp.evaluate(jexlContext);
        }
        cell.append((j > 0 ? "," : "") + "\"" + (value == null ? "" : value) + "\"");
      }
      cell.append("]");
      String idValue = BeanUtils.getProperty(record, idProperty.trim());
      content.append((i > 0 ? "," : "") + "{\"id\": \"" + (idValue == null ? "" : idValue) + "\", \"cell\":" + cell + "}");
    }
    content.append("]}");
    writeWithJson(response, content.toString());
  }



}
