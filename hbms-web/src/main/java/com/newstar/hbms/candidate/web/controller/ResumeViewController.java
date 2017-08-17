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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by wangjinsi on 2017/6/8.
 */
public class ResumeViewController extends ConfigurableMultiActionController {

    private Logger logger = LoggerFactory.getLogger(ResumeViewController.class);

    private String targetFolder;

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String fileName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        File resumeFile = new File(targetFolder + "/" + fileName);
        if (!resumeFile.exists() || resumeFile.isDirectory()) {
            String msg = "请求错误，不存在的文件“" + fileName + "”,先检查是否已经上传简历，如果已经上传请确认简历镜像已生成。";
            logger.error(msg);
            response.getOutputStream().write(msg.getBytes("utf-8"));
        } else {
            FileInputStream in = new FileInputStream(resumeFile);
            int length = 0;
            byte[] buffer = new byte[2048];
            while ((length = in.read(buffer, 0, buffer.length)) > 0) {
                response.getOutputStream().write(buffer, 0, length);
            }
            in.close();
        }
        return null;
    }

}
