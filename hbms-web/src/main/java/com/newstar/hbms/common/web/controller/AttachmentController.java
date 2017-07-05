package com.newstar.hbms.common.web.controller;

import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.service.AttachmentService;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by fellowlong on 2014-12-01.
 */
public class AttachmentController extends ConfigurableMultiActionController {

  private AttachmentService attachmentService;

  public void setAttachmentService(AttachmentService attachmentService) {
    this.attachmentService = attachmentService;
  }

  public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Long id = WebUtils.getLong(request, WebUtils.ID);
    if (id != null) {
      List<Attachment> attachments = attachmentService.findByIds(new Long[]{id});
      if (attachments != null && !attachments.isEmpty()) {
        response.reset();
        // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(attachments.get(0).getFileName(), "UTF-8"));
        response.addHeader("Content-Length", "" + attachments.get(0).getFileBinaryData().length);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        os.write(attachments.get(0).getFileBinaryData());// 输出文件
        os.flush();
        os.close();
      }
    }
  }

}
