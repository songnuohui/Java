package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zt.dao.MemberDao;
import com.zt.dao.impl.MemberDaoImpl;
import com.zt.po.Member;

public class LoginServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String userName=request.getParameter("userName");
    	String pass=request.getParameter("pass");
    	MemberDao dao=new MemberDaoImpl();
    	Member member=dao.login(userName, pass);
    	if(member!=null){
    		//登录成功 写session 在跳转成功页面
    		HttpSession session=request.getSession();
    		session.setAttribute("loginUser", member);
    		response.sendRedirect("main.jsp");
    	}else{//失败 传递错误信息 跳转到登录页面
    		request.setAttribute("msg", "用户名或密码错误！");
    		request.getRequestDispatcher("index.jsp")
    		       .forward(request, response);
    	}
    	
    }
}
