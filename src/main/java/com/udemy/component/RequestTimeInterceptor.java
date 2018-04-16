package com.udemy.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	
	//SE EJECUTA PRIMERO: se va a ejecuta antes de entrar al método del controlador 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	//SE EJECUTA DESPUES: se va a ejecutar antes de arrojar la vista en el navegador 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long)request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' -- TOTAL TIME: '" + (System.currentTimeMillis() - startTime) +"'ms");
	}


	

}
