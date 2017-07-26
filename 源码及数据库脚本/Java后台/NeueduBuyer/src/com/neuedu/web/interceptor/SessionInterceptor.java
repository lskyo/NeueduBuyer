package com.neuedu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 1.session会话拦截器，用于进行登录访问控制(页面的访问使用Filter进行拦截，action的访问可以使用interceptor进行拦截)
 * 2.本例，用于拦截所有需要登录后才能访问的controller
 * 
 * </pre>
 * 
 * @author chensw
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger LOG = Logger.getLogger(SessionInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		LOG.info("afterCompletion============");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		LOG.info("postHandle============");
	}

	@Override
	/**
	 * return true-不拦截，false-拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		// 检查是否有会话记录
		if (request.getSession().getAttribute("login") != null) {
			LOG.info("preHandle====1====true >" + request.getSession().getAttribute("login"));
			return true;
		} else {
			LOG.info("preHandle====1====false >" + request.getSession().getAttribute("login"));
			// 拦截后，返回没有拦截的页面
			response.sendRedirect("toAddUser.do");
			// request.getRequestDispatcher("toAddUser.do").forward(request,response);
			return false;
		}
	}

}
