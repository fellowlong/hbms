package com.newstar.hbms.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller, ManualUrlMapper {
	
	private UrlPathHelper urlPathHelper = new UrlPathHelper();
	
	public ModelAndView handleRequest(HttpServletRequest request,
																		HttpServletResponse response) throws Exception {
		String viewPath = urlPathHelper.getLookupPathForRequest(request);
		if(viewPath.lastIndexOf(".") > - 1) {
			viewPath = viewPath.substring(0, viewPath.lastIndexOf("."));
		}
		if(viewPath.startsWith("/")) {
			viewPath = viewPath.substring(1);
		}
		return new ModelAndView(viewPath);
	}

	public String[] getUrls() {
		return new String[]{"/**/*"};
	}
}
