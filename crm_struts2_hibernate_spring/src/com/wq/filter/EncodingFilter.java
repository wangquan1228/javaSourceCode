package com.wq.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 编码过滤器
 * 
 * @author wangquan
 *
 */
/*@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding", value = "utf-8") })*/
public class EncodingFilter implements Filter {
	public String Encoding;

	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(Encoding);
		;
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		Encoding = fConfig.getInitParameter("encoding");
		System.out.println("编码格式:" + Encoding);
	}

}
