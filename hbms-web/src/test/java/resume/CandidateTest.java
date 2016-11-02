package resume;

import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.candidate.web.controller.CandidateController;
import common.TestUtils;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fellowlong on 2014-10-27.
 */
public class CandidateTest extends TestCase {


  public void testFindById() throws Exception {
    CandidateController candidateController = TestUtils.getBean(CandidateController.class);
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setParameter("id", "1");
    MockHttpServletResponse response = new MockHttpServletResponse();
    ModelAndView modelAndView = candidateController.findById(request, response);
    Assert.assertTrue(
      modelAndView != null
      && modelAndView.getModel().get("resume") != null
      && ((Candidate)(modelAndView.getModel().get("resume"))).getId() != null
    );
  }

}
