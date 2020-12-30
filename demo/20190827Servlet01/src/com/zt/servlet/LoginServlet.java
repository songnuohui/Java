package com.zt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.MemberDao;
import com.zt.dao.impl.MemberDaoImpl;
import com.zt.po.Member;

public class LoginServlet extends HttpServlet{
     @Override
    protected void service(HttpServletRequest request, 
    		               HttpServletResponse response)
    		throws ServletException, IOException {
    	 request.setCharacterEncoding("UTF-8");
    	 String userName=request.getParameter("userName");
    	 String pass=request.getParameter("pass");
    	 MemberDao dao=new MemberDaoImpl();
    	 Member member=dao.login(userName, pass);
    	 if(member!=null){
    		//1: response.sendRedirect("success.jsp?name="+member.getName());
    		 request.setAttribute("member", member);
    		 request.setAttribute("msg", "hello");
    		 List<Member> members=dao.findAll();
    		 request.setAttribute("members", members);
    		// response.sendRedirect("success.jsp");
    		 request.getRequestDispatcher("success.jsp")
    		              .forward(request, response); 	 
    	 }else{
    		 response.sendRedirect("error.jsp");
    	 }
    	 
    }
    
}
