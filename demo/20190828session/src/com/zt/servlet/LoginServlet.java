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
    		//��¼�ɹ� дsession ����ת�ɹ�ҳ��
    		HttpSession session=request.getSession();
    		session.setAttribute("loginUser", member);
    		response.sendRedirect("main.jsp");
    	}else{//ʧ�� ���ݴ�����Ϣ ��ת����¼ҳ��
    		request.setAttribute("msg", "�û������������");
    		request.getRequestDispatcher("index.jsp")
    		       .forward(request, response);
    	}
    	
    }
}
