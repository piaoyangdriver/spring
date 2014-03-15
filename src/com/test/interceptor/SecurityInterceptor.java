package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userid");
		if (userId == null || "".equals(userId)) {
			String header = request.getHeader("X-Requested-With");
			if (header != null && "XMLHttpRequest".equals(header)) {
				response.getWriter()
						.print("{success:false,message:You left too long,please refresh the page.}");
			}
			//response.sendRedirect(request.getContextPath() + "/login.html");
			return false;
		}
		return true;
	}

}
