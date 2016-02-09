package com.newstar.hbms.mvc;

import com.newstar.hbms.utils.ExceptionUtils;
import com.newstar.hbms.utils.WebUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: fellowlong
 * Date: 3/18/13
 * Time: 4:56 PM
 */
public class LoggerHandlerExceptionResolver implements HandlerExceptionResolver {

  private final Logger logger = Logger.getLogger(LoggerHandlerExceptionResolver.class);

  @Override
  public ModelAndView resolveException(HttpServletRequest request,
                                       HttpServletResponse response,
                                       Object handler,
                                       Exception ex) {
    logger.error("执行请求出错：", ex);
    try {
      MessageCollector messageCollector = new MessageCollector();
      messageCollector.addError("exception", ExceptionUtils.getExceptionStack(ex));
      WebUtils.writeWithJson(response, messageCollector);
    } catch (Throwable throwable) {
      throw new RuntimeException("处理异常出错：", throwable);
    }
    return null;
  }
}
