package com.zt.filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CodeFilter implements Filter{
	public CodeFilter(){
		System.out.println("CodeFilter 构造器...");
	}
	public void init(FilterConfig arg0) throws ServletException {	
		System.out.println("CodeFilter init...");
	}
	public void destroy() {
		System.out.println("CodeFilter destroy...");
	}
	public void doFilter(ServletRequest arg0, 
			ServletResponse arg1,FilterChain chain) 
					throws IOException, ServletException {
		System.out.println("CodeFilter doFilter...");
		//1：把所有拦截的请求进行转码
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//2：放行请求
		chain.doFilter(request, response);
	}

	

}
