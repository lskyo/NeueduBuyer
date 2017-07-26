package com.neuedu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * 1.登录访问控制，当页面不在WEB-INF目录下，使用Filter进行页面访问控制，controller可以使用interceptor进行控制
 * 2.本例配置所有需要访问控制的jsp页面
 * </pre>
 * @author chensw
 */
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		if (request2.getSession().getAttribute("login") == null) {
			// && request2.getRequestURI().indexOf("addUser.jsp") < 0) {
			// 跳转到未被拦截的controller
			response2.sendRedirect(request2.getContextPath()+"/login.html");
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
