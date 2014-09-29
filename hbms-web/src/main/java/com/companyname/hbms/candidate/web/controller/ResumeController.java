package com.companyname.hbms.candidate.web.controller;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.common.service.CommonService;
import com.companyname.hbms.common.service.FileService;
import com.companyname.hbms.utils.BeanUtils;
import com.companyname.hbms.utils.FileUtils;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeController extends MultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private ResumeService resumeService;

  private CommonService commonService;

  private FileService fileService;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setCommonService(CommonService commonService) {
    this.commonService = commonService;
  }

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  public void findByBean(HttpServletRequest request,
                   HttpServletResponse response,
                   Resume resume) throws Exception {
    resume.setYn(Boolean.TRUE);
    PagingResult<Resume> resumePagingResult = resumeService.findByBean(resume, WebUtils.getPageRange(request));
    if (resumePagingResult != null && resumePagingResult.getRecords() != null) {
      for (Resume perResume : resumePagingResult.getRecords()) {
        perResume.setAttachUri(FileUtils.decodeFileName(perResume.getAttachUri().substring(1)));
      }
    }
    WebUtils.writeForEasyUIDataGrid(request, response, resumePagingResult, true);
  }


  public void insertOrUpdate(HttpServletRequest request,
                             HttpServletResponse response,
                             Resume resume) throws Exception {
    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = upload.parseRequest(request);// 上传文件解析
    Iterator itr = items.iterator();// 枚举方法
    Map<String, Object> parameters = new HashMap<String, Object>();
    while (itr.hasNext()) {
      FileItem item = (FileItem) itr.next();
      if (item.isFormField()) {// 判断是文件还是文本信息
        parameters.put(item.getFieldName(), new String(item.getString().getBytes(),"UTF-8"));
      } else if (item.getFieldName().equals("attachFile")){
        resume.setAttachInputStream(item.getInputStream());
        resume.setAttachUri("/" + FileUtils.encodeFileName(item.getName(), commonService.getCurrentDate()));
      }
    }
    BeanUtils.bindProperties(resume, parameters);
    int count = resumeService.insertOrUpdate(resume);
    WebUtils.writeWithJson(response, count);
  }
}
