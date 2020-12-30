package com.zt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import com.zt.dao.AuthDao;
import com.zt.dao.UserDao;
import com.zt.dao.impl.AuthDaoImpl;
import com.zt.dao.impl.UserDaoImpl;
import com.zt.po.Auth;
import com.zt.po.User;
@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet{
	 private AuthDao authDao;
	 private UserDao userDao;
	 public void init() throws ServletException {
	   authDao=new AuthDaoImpl();
	   userDao=new UserDaoImpl();
	 }
	 protected void service(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
	    	String name=request.getParameter("name");
	    	String pass=request.getParameter("pass");
	    	User user=userDao.login(name, pass);
	    	if(user!=null){
	    		HttpSession session=request.getSession();
	    		session.setAttribute("loginUser", user);
	    		List<Auth> authList=authDao.findAuthByRole(user.getRoleId());
	    		Set paid=new HashSet();
	    		for(Auth a:authList){
	    			if(a.getParent()!=null){
	    				paid.add(a.getParent().getId());
	    			}
	    		}
	    		List<Auth> authParent=new ArrayList();
	    		Iterator its=paid.iterator();
	    		 while(its.hasNext()){
	    			int authId=(Integer) its.next();
	    			authParent.add(authDao.getAuthById(authId));
	    		 }
	    		 session.setAttribute("authParent", authParent);
	    		 session.setAttribute("authList", authList);
	    		 response.sendRedirect("main.jsp");
	    		
	    	}else{
	    		response.sendRedirect("login.jsp");
	    	}
	    	
	    	
	 }
}
