package com.zt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.Perf.GetPerfAction;

import com.sun.net.httpserver.HttpServer;
import com.zt.dao.MessageDao;
import com.zt.dao.impl.MessageDaoImpl;
import com.zt.po.Member;
import com.zt.po.Message;

public class MessageServlet extends HttpServlet {
	private MessageDao messageDao;
	public void init() throws ServletException {
		messageDao=new MessageDaoImpl();
	}
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String method=request.getParameter("method");
    	if("add".equals(method)){add(request,response);}
    	if("list".equals(method)){list(request,response);}
    	if("del".equals(method)){del(request,response);}
    	if("edit".equals(method)){edit(request,response);}
    	if("update".equals(method)){update(request,response);}
    	if("show".equals(method)){show(request,response);}
    	
	}
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	Member member=(Member) session.getAttribute("loginMember");
    	if(member!=null){
    		String title=request.getParameter("title");
        	String content=request.getParameter("content");
        	String ip=request.getRemoteAddr();
        	Message message=new Message();
        	message.setTitle(title);
        	message.setContent(content);
        	message.setIp(ip);
        	message.setMember(member);
        	boolean f=messageDao.addMessage(message);
        	if(f){
        		response.sendRedirect("msg?method=list");
        	}else{
        		response.sendRedirect("error.jsp");
        	}
    	}else{
    		response.sendRedirect("error.jsp");
    	}
    	
    	
    
    	
   	}
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Message> list=messageDao.findAll();
    	request.setAttribute("msgList", list);
    	request.getRequestDispatcher("index.jsp")
    	       .forward(request, response);
	}
    
    
     protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String idStr=request.getParameter("id");
    	 int messageId=0;
    	 if(idStr!=null){
    		 messageId=Integer.parseInt(idStr);
    	 }
    	 Message message=messageDao.getMessageById(messageId);
    	 request.setAttribute("message", message);
     	request.getRequestDispatcher("show.jsp")
     	       .forward(request, response);
	}
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   	}

	

}
