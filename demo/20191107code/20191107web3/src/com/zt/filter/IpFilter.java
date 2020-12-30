package com.zt.filter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class IpFilter implements Filter{
	private List<String> heiIp=new ArrayList<String>();
   public void init(FilterConfig arg0) throws ServletException {			
	   heiIp.add("192.168.1.140");
	   heiIp.add("192.168.1.174");
	   heiIp.add("192.168.1.175");
	   heiIp.add("192.168.1.104");
   }
	public void destroy() {		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		String ip=request.getRemoteAddr();
		if(heiIp.contains(ip)){
			response.getWriter().write("黑名单用户不能访问！");
		}else{
			chain.doFilter(request, response);
		}		
			
	}
	

}
