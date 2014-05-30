package com.companyname.hbms.resume.service.impl;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangjinsi on 14-5-29.
 */
public class CustomerServiceImplTest extends TestCase {

  private static ClassPathXmlApplicationContext applicationContext = null;

  static {
    String path = "classpath:applicationContext.xml";
    applicationContext = new ClassPathXmlApplicationContext(path);
  }

  public void testInsert() {
    ResumeService resumeService = applicationContext.getBean(ResumeService.class);
    Resume resume = new Resume();
    resume.setName("Zhangsan's Resume");
    resumeService.insert(resume);
  }

}
