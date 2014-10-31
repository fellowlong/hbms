package resume;

import com.companyname.hbms.resume.domain.Resume;
import com.companyname.hbms.resume.service.ResumeService;
import com.companyname.hbms.resume.web.controller.ResumeController;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fellowlong on 2014-10-27.
 */
public class ResumeTest extends TestCase {


  public void testFindById() throws Exception {
    ResumeController resumeController = TestUtils.getBean(ResumeController.class);
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setParameter("id", "1");
    MockHttpServletResponse response = new MockHttpServletResponse();
    ModelAndView modelAndView = resumeController.findById(request, response);
    Assert.assertTrue(
      modelAndView != null
      && modelAndView.getModel().get("resume") != null
      && ((Resume)(modelAndView.getModel().get("resume"))).getId() != null
    );
  }

}
