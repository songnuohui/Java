package com.zt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.AuthDao;
import com.zt.dao.impl.AuthDaoImpl;
import com.zt.po.Auth;
@WebServlet("/admin/system/auth/auth")
public class AuthServlet extends HttpServlet{
    private AuthDao authDao;
    public void init() throws ServletException {
    	authDao=new AuthDaoImpl();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String method=request.getParameter("method");
    	if("add".equals(method)){
    		add(request,response);
    	}
    	if("list".equals(method)){
    		list(request,response);
    	}
    	if("save".equals(method)){
    		save(request,response);
    	}
    	
    }
    protected void list(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    }
    protected void add(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	List<Auth> authList=authDao.findByLeave(1);
    	request.setAttribute("authList", authList);
    	request.getRequestDispatcher("authAdd.jsp")
    	      .forward(request, response); 	
    }
    protected void save(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String name=request.getParameter("name");
    	String url=request.getParameter("url");
    	String parentId=request.getParameter("parentId");
    	Auth  auth=new Auth();
    	auth.setName(name);
    	auth.setUrl(url);
    	if(!"0".equals(parentId)){
    		Auth parent=authDao.getAuthById(Integer.parseInt(parentId));
    		auth.setParent(parent);
    	}
    	boolean f=authDao.addAuth(auth);
    	
    }
    protected void show(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    }
}
