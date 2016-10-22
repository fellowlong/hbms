package com.newstar.hbms.mvc;


public class ControllerClassNameHandlerMapping
		extends
		org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping {

	@SuppressWarnings("rawtypes")
	@Override
	protected String[] buildUrlsForHandler(String beanName, Class beanClass) {
		if(ManualUrlMapper.class.isAssignableFrom(beanClass)) {
			ManualUrlMapper mapper = (ManualUrlMapper)getApplicationContext().getBean(beanName);
			return mapper.getUrls();
		}
		return super.buildUrlsForHandler(beanName, beanClass);
	}
	
}
