package com.newstar.hbms.candidate.web.controller;

import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.service.AttachmentService;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.utils.file.FileType;
import com.newstar.hbms.utils.file.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by fellowlong on 2017/6/8.
 */
public class ResumeController extends ConfigurableMultiActionController {

    private Logger logger = LoggerFactory.getLogger(ResumeController.class);

    private AttachmentService attachmentService;

    private String targetFolder;

    public void setAttachmentService(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
    }

    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("/candidate/resumeManager");
    }


    public void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        File resumeFile = new File(targetFolder + "/" + fileName);
        if (!resumeFile.exists() || resumeFile.isDirectory()) {
            response.getOutputStream().write("请求错误，不存在的简历，先检查是否已经上传简历，如果已经上传再看看是否生产简历镜像".getBytes());
        } else {
            FileInputStream in = new FileInputStream(resumeFile);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            int length = 0;
            byte[] buffer = new byte[2048];
            while ((length = in.read(buffer, 0, length)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public ModelAndView convert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Attachment attachment = new Attachment();
        attachment.setBusinessType(Attachment.BUSINESS_TYPE_RESUME);
        List<Attachment> attachments = attachmentService.findByBean(attachment);
        StringBuilder result = new StringBuilder();
        for (Attachment perAttachment : attachments) {
            if (perAttachment.getFileBinaryData() == null) continue;
            try {
                FileUtils.convert(
                        new ByteArrayInputStream(perAttachment.getFileBinaryData()),
                        new FileOutputStream(targetFolder + "/" + perAttachment.getBusinessId() + ".html"),
                        FileType.getFileType(perAttachment.getFileName()),
                        FileType.html);
                result.append( perAttachment.getBusinessId() + " " + perAttachment.getFileName() + "\n");
            } catch (Exception e) {
                logger.error("生产HTML格式的简历出错" , e);
            }
        }
        return new ModelAndView("/candidate/resumeManager", "result", result.toString());
    }
}
