package com.newstar.hbms.search.web.controller;

import com.newstar.hbms.basedata.domain.TreeNode;
import com.newstar.hbms.candidate.domain.Candidate;
import com.newstar.hbms.customer.domain.Company;
import com.newstar.hbms.customer.service.CompanyService;
import com.newstar.hbms.mvc.ConfigurableMultiActionController;
import com.newstar.hbms.mvc.MessageCollector;
import com.newstar.hbms.project.domain.Project;
import com.newstar.hbms.project.service.ProjectService;
import com.newstar.hbms.search.domain.TempCandidate;
import com.newstar.hbms.search.service.TempCandidateService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;
import com.newstar.hbms.system.service.UserService;
import com.newstar.hbms.utils.JsonUtils;
import com.newstar.hbms.utils.WebUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjinsi on 2017/3/23.
 */
public class TempCandidateController  extends ConfigurableMultiActionController {

    private TempCandidateService tempCandidateService;

    private UserService userService;

    private CompanyService companyService;

    private ProjectService projectService;

    public static Map<Class, List<String>> excludedProperties = new HashMap<Class, List<String>>(0);

    static {
        excludedProperties.put(TreeNode.class, Arrays.asList(new String[]{"children"}));
    }

    private String datePattern;

    public void setTempCandidateService(TempCandidateService tempCandidateService) {
        this.tempCandidateService = tempCandidateService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ModelAndView workspace(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("/search/tempCandidateManage");
        mav.addObject("companies", companyService.findByBean(new Company(), new PageRange(1, 1000)).getRecords());
        return mav;
    }


    public ModelAndView editView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = WebUtils.getLong(request, WebUtils.ID);
        ModelAndView modelAndView = new ModelAndView("/search/tempCandidateEdit");
        if (id != null) {
            List<TempCandidate> tempCandidates = tempCandidateService.findByIds(new Long[]{id});
            if (tempCandidates != null && !tempCandidates.isEmpty()) {
                modelAndView.getModel().put("tempCandidate", tempCandidates.get(0));
            }
        }
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("companies", companyService.findByBean(new Company(), new PageRange(1, 1000)).getRecords());
        return modelAndView;
    }

    public ModelAndView save(HttpServletRequest request, HttpServletResponse response, TempCandidate tempCandidate) throws Exception {
        int resultCount = tempCandidateService.insertOrUpdate(tempCandidate);
        MessageCollector msgCollector = new MessageCollector();
        if (resultCount == 1) {
            msgCollector.addInfo(WebUtils.SUCCESS, Boolean.TRUE);
        } else {
            msgCollector.addError(WebUtils.ERROR, Boolean.TRUE);
        }
        ModelAndView modelAndView = new ModelAndView("/search/tempCandidateManage");
        modelAndView.addObject("msgCollector", msgCollector);
        modelAndView.addObject("tempCandidate", tempCandidate);
        return modelAndView;
    }


    public void findByBean(HttpServletRequest request,
                           HttpServletResponse response,
                           TempCandidate tempCandidate) throws Exception {
        tempCandidate.setYn(Boolean.TRUE);
        String pageSize = request.getParameter("rows");
        String pageNum = request.getParameter("page");
        PageRange pageRange = new PageRange();
        if (pageSize != null) {
            pageRange.setPageSize(Integer.parseInt(pageSize));
        }
        if (pageNum != null) {
            pageRange.setPageNum(Integer.parseInt(pageNum));
        }
        PagingResult<TempCandidate> tempCandidateResult = tempCandidateService.findByBean(tempCandidate, pageRange);
        Map<String, Object> jsonMap = new HashMap();
        jsonMap.put("page", pageNum);
        jsonMap.put("total ", tempCandidateResult.getPageTotal());
        jsonMap.put("records ", tempCandidateResult.getRecordTotal());
        if (tempCandidateResult.getRecords() != null) {
            jsonMap.put("rows", tempCandidateResult.getRecords().toArray());
        } else {
            jsonMap.put("rows", null);
        }
        WebUtils.writeWithJson(response, JsonUtils.beanToJson(jsonMap, excludedProperties));
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
