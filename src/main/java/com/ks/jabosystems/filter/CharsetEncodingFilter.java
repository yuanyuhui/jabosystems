package com.ks.jabosystems.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharsetEncodingFilter implements Filter {

	private String charset = "UTF-8";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		response.setContentType("text/html;charset=" + charset);
		response.setCharacterEncoding(charset);
		String methodType = request.getMethod();
		if ("post".equalsIgnoreCase(methodType)) {
			request.setCharacterEncoding(charset);
			chain.doFilter(request, response);
		} else if ("get".equalsIgnoreCase(methodType)) {
			// 匿名子类完成request包装
			HttpServletRequestWrapper hrw = new HttpServletRequestWrapper(request) {
				@Override
				public String getParameter(String name) {
					String srcValue = super.getParameter(name);
					try {
						srcValue = new String(srcValue.getBytes("ISO-8859-1"), charset);
					} catch (UnsupportedEncodingException e) {
						srcValue = null;
					}
					return srcValue;
				}

				@Override
				public String[] getParameterValues(String name) {
					String[] srcValue = super.getParameterValues(name);
					for (int i = 0; i < srcValue.length; i++) {
						try {
							srcValue[i] = new String(srcValue[i].getBytes("ISO-8859-1"), charset);
						} catch (UnsupportedEncodingException e) {
							srcValue[i] = null;
						}
					}
					return srcValue;
				}

			};
			chain.doFilter(hrw, response);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		charset = config.getInitParameter("encoding");
	}

}
