package com.ks.jabosystems.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionValidate implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		// 获得请求uri(/WebFilter/c/user?f=login)
		String uri = request.getRequestURI();
		if (uri.contains("/jabosystems/loginin")) {
			chain.doFilter(request, response);
		} else {
			//验证session
			if (session.getAttribute("Employee") == null) {
				response.sendRedirect("/jabosystems/sessionerror.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
