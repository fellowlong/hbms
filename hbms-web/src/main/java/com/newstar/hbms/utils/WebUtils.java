package com.newstar.hbms.utils;

import com.newstar.hbms.common.Constants;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

  public static Long[] getLongArrayBySeparator(HttpServletRequest request, String name, String separator) {
    String strValue = request.getParameter(name);
    Long[] longArray = null;
    if (strValue != null) {
      String[] strArray = strValue.split(separator);
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
                                            PagingResult<?> pagingResult,
                                            boolean ignoreColumnFields) throws Exception{
    StringBuilder data = new StringBuilder("{\"total\":\"" + pagingResult.getRecordTotal() + "\",\"rows\":[");
    if (pagingResult.getRecords() != null) {
      String columnFieldsStr = request.getParameter("columnFields");
      String[] columnFields = (columnFieldsStr != null ? columnFieldsStr.split(",") : new String[]{});
      for (int i = 0; i < pagingResult.getRecords().size(); i++) {
        Object record = pagingResult.getRecords().get(i);
        StringBuilder rowJson = new StringBuilder();
        if (ignoreColumnFields) {
          rowJson.append(JsonUtils.beanToJson(record));
        } else {
          rowJson.append("{");
          MapContext jexlContext = new MapContext();
          jexlContext.set("record", record);
          String columnField = null;
          for (int j = 0; j < columnFields.length; j++) {
            columnField = columnFields[j];
            if (columnField != null) {
              columnField = columnField.trim();
              Object value = jexlEngine.createExpression("record." + columnField).evaluate(jexlContext);
              if (value != null && value.toString().trim().length() > 0) {
                value = "\"" + columnFields[j].trim() + "\":\"" + value + "\"";
                rowJson.append((j > 0 ? "," : "") + value);
              }
            }
          }
          rowJson.append("}");
        }
        data.append((i > 0 ? "," : "") + rowJson);
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

  public static void bindParameterWithFile(HttpServletRequest request, Object bean) throws Exception {
    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = upload.parseRequest(request);// 上传文件解析
    Iterator itr = items.iterator();// 枚举方法
    Map<String, Object> parameters = new HashMap<String, Object>();
    while (itr.hasNext()) {
      FileItem item = (FileItem) itr.next();
      if (item.isFormField()) {// 判断是文件还是文本信息
        parameters.put(item.getFieldName(), item.getString("UTF-8"));
      } else {
        parameters.put(item.getFieldName() + "InputStream", item.getInputStream());
        parameters.put(item.getFieldName(), item.getName());

      }
    }
    com.newstar.hbms.utils.BeanUtils.bindProperties(bean, parameters);
  }



}
