package com.newstar.hbms.resume;

import com.newstar.hbms.resume.domain.SourceResume;
import com.newstar.hbms.resume.service.SourceResumeService;
import com.newstar.hbms.utils.WordParser;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

/**
 * Created by wangjinsi on 2016/2/10.
 */
@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SourceResumeServiceTest extends TestCase {

  @Autowired
  SourceResumeService sourceResumeService;

  @Test
  public void testInsert() throws IOException {
    SourceResume sourceResume = new SourceResume();
    sourceResume.setName("张三的简历");
    FileInputStream fileInputStream = new FileInputStream("C:/吴奇的简历.doc");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int length = 0;
    byte[] buffer = new byte[1024];
    while ((length = fileInputStream.read(buffer, 0, buffer.length)) > 0) {
      out.write(buffer, 0, length);
    }
    fileInputStream.close();
    out.close();
    sourceResume.setBinaryResume(out.toByteArray());
    String textResume = WordParser.getText(new ByteArrayInputStream(out.toByteArray()), WordParser.Version.DOC_97TO2003);
    sourceResume.setTextResume(textResume);
    sourceResumeService.insert(sourceResume);
  }

}
