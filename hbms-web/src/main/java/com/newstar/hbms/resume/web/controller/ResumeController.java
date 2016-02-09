package com.newstar.hbms.resume.web.controller;

import com.newstar.hbms.common.service.CommonService;
import com.newstar.hbms.mvc.MessageCollector;
import com.newstar.hbms.resume.domain.Resume;
import com.newstar.hbms.resume.service.ResumeService;
import com.newstar.hbms.utils.WebUtils;
import com.newstar.hbms.utils.paging.PagingResult;
import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeController extends MultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private ResumeService resumeService;

  private CommonService commonService;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setCommonService(CommonService commonService) {
    this.commonService = commonService;
  }

  public ModelAndView findByBean(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Resume resume) throws Exception {
    resume.setYn(Boolean.TRUE);
    PagingResult<Resume> resumePagingResult = resumeService.findByBean(resume, WebUtils.getPageRange(request));
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("resumePagingResult", resumePagingResult);
    return new ModelAndView("/resume/resumeList.ftl", model);
  }

  public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Resume> resumes = resumeService.findByIds(new Long[]{WebUtils.getLong(request, WebUtils.ID)});
    ModelAndView modelAndView = new ModelAndView("/resume/resumeDetail.ftl");
    if (resumes != null && !resumes.isEmpty()) {
      modelAndView.getModel().put("resume", resumes.get(0));
    }
    return modelAndView;
  }

  public ModelAndView resumeAddView(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("/resume/resumeAdd.ftl");
  }


  public ModelAndView preInsertOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    String view = request.getParameter("view");
    ModelAndView modelAndView = new ModelAndView(view);
    if (id != null) {
      List<Resume> resumes = resumeService.findByIds(new Long[]{id});
      if (resumes != null && !resumes.isEmpty()) {
        modelAndView.getModel().put("resume", resumes.get(0));
      }
    }
    return modelAndView;
  }

  public void insertOrUpdate(HttpServletRequest request, HttpServletResponse response,Resume resume2) throws Exception {
    Resume resume = new Resume();
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    MultipartHttpServletRequest multipartHttpServletRequest = resolver.resolveMultipart(request);
    ServletRequestDataBinder servletRequestDataBinder = new ServletRequestDataBinder(resume);
    servletRequestDataBinder.bind(multipartHttpServletRequest);
    if (resume.getOriginalResumeFile() != null) {
      resume.setOriginalResumeInputStream(new ByteArrayInputStream(resume.getOriginalResumeFile().getBytes()));
      resume.setOriginalResumeName(resume.getOriginalResumeFile().getOriginalFilename());
    }
    boolean isNew = (resume.getId() == null ? true : false);
    int resultCount = resumeService.insertOrUpdate(resume);
    MessageCollector msgCollector = new MessageCollector();
    if (resultCount == 1) {
      msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    } else {
      msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
    }
    if (isNew) {
      Resume resumeForResult = new Resume();
      resumeForResult.setId(resume.getId());
      WebUtils.writeWithJson(response, resumeForResult);
    } else {
      WebUtils.writeWithJson(response, msgCollector);
    }
  }

  public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int resultCount = resumeService.deleteByIds(WebUtils.getLongArrayBySeparator(request, "id", ","));
    MessageCollector msgCollector = new MessageCollector();
    msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
    WebUtils.writeWithJson(response, msgCollector);
  }
}