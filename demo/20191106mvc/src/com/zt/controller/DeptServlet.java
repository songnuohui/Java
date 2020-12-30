package com.zt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.DeptDao;
import com.zt.dao.impl.DeptDaoImpl;
import com.zt.po.Dept;

public class DeptServlet extends HttpServlet{
    private DeptDao  deptDao;
    @Override
    public void init() throws ServletException {
    	deptDao=new DeptDaoImpl();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//���� ��ѯ���в������� ����ҵ��㷽��
    	List<Dept> deptList=deptDao.findAll();
    	//��Ӧ��������ת����
    	request.setAttribute("deptList", deptList);
    	request.getRequestDispatcher("deptList.jsp")
    	        .forward(request, response);
    	 	
    }
}
