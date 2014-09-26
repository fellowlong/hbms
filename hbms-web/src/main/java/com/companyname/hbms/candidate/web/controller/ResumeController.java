package com.companyname.hbms.candidate.web.controller;

import com.companyname.hbms.candidate.domain.Resume;
import com.companyname.hbms.candidate.service.ResumeService;
import com.companyname.hbms.common.FileService;
import com.companyname.hbms.utils.WebUtils;
import com.companyname.hbms.utils.paging.PagingResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fellowlong on 2014-08-07.
 */
public class ResumeController extends MultiActionController {

  private Logger logger = Logger.getLogger(getClass());

  private ResumeService resumeService;

  private FileService fileService;

  public void setResumeService(ResumeService resumeService) {
    this.resumeService = resumeService;
  }

  public void setFileService(FileService fileService) {
    this.fileService = fileService;
  }

  public void findByBean(HttpServletRequest request,
                   HttpServletResponse response,
                   Resume resume) throws Exception {
    resume.setYn(Boolean.TRUE);
    PagingResult<Resume> resumePagingResult = resumeService.findByBean(resume, null);
    WebUtils.writeForJQGrid(request, response, resumePagingResult, "id");
  }


  public void insertOrUpdate(HttpServletRequest request,
                             HttpServletResponse response,
                             Resume resume) throws Exception {
    DiskFileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = upload.parseRequest(request);// 上传文件解析
    Iterator itr = items.iterator();// 枚举方法
    while (itr.hasNext()) {
      FileItem item = (FileItem) itr.next();
      if (item.isFormField()) {// 判断是文件还是文本信息
        logger.info("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
      } else {
        int count = resumeService.insertOrUpdate(resume);
        WebUtils.writeWithJson(response, count);
      }
    }
  }

}
