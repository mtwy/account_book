package org.loong.common.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.loong.common.content.SystemContent;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@WebFilter(filterName = "SystemFilter", urlPatterns = "/*")
public class SystemFilter implements Filter {

	private final Log log = LogFactory.getLog(getClass());

	/* ==================================== method =================================== */
	Map<?, ?> proper;

	/* =================================== resource ================================== */
	
	@Override
	public void destroy() {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		SystemContent.setRequest((HttpServletRequest) request);
		SystemContent.setResponse((HttpServletResponse) response);
		
		//正常请求
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("================================= system info =================================");
		log.info("SystemFilter init... " + this);
		WebApplicationContext factory = ContextLoader.getCurrentWebApplicationContext();
		proper = (Map<?, ?>) factory.getBean("proper");
		log.info("================================= system info =================================");
	}

}
