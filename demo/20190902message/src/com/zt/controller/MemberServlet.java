package com.zt.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zt.dao.MemberDao;
import com.zt.dao.impl.MemberDaoImpl;
import com.zt.po.Member;
public class MemberServlet extends HttpServlet {
    private MemberDao memberDao;
	public void init(ServletConfig config) throws ServletException {
		memberDao=new MemberDaoImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}
		if("out".equals(method)){
			out(request,response);
		}
	}
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name=request.getParameter("name");
    	String pass=request.getParameter("pass");
    	Member member=memberDao.login(name);
    	HttpSession session=request.getSession();
    	if(member==null){//用户不存在
    		session.setAttribute("error", "用户名输入错误");
    	}else{
    		if(member.getPass().equals(pass)){//登录成功
    			session.setAttribute("loginMember", member);
    		}else{ //密码错误
    			session.setAttribute("error", "密码输入错误");
    		}
    	}
    	request.getRequestDispatcher("default.jsp")
    	       .forward(request, response);
	}
    protected void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	session.invalidate();  //重置session
    	response.sendRedirect("default.jsp");
     }
	
}
