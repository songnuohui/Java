package com.zt.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.EmpDao;
import com.zt.dao.impl.EmpDaoImpl;
import com.zt.po.Emp;
import com.zt.utils.PageUtil;

public class EmpServlet extends HttpServlet{
	private EmpDao empDao;
	public void init() throws ServletException {
		empDao=new EmpDaoImpl();
	}
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	 //查询总记录数
    	Map filter=new HashMap();
    	String ename=request.getParameter("ename");
    	String job=request.getParameter("job");
    	String deptNo=request.getParameter("deptNo");
    	if(ename!=null&&!"".equals(ename)){
    		filter.put("ename", ename);
    	}
    	if(job!=null&&!"".equals(job)){
    		filter.put("job", job);
    	}
    	if(deptNo!=null&&!"".equals(deptNo)){
    		filter.put("deptNo", Integer.parseInt(deptNo));
    	}
    	
    	int totalSize=empDao.getTotalSize(filter);
    	//模糊查询当前页记录集合
    	PageUtil pageUtil=new PageUtil();
    	int currPage=1;
    	String pagestr=request.getParameter("page");
    	if(pagestr!=null&&!"".equals(pagestr)){
    		currPage=Integer.parseInt(pagestr);
    	}
    	pageUtil.setCurrPage(currPage);
    	pageUtil.setPageSize(3);
    	pageUtil.setTotalSize(totalSize);
    	pageUtil.setTotalPage(totalSize);
    	List<Emp> emps=empDao.findByPage(filter, pageUtil);
    	request.setAttribute("emps", emps);
    	request.setAttribute("filter", filter);
    	request.setAttribute("pageUtil", pageUtil);
    	request.getRequestDispatcher("empList.jsp")
    	       .forward(request, response);
    }
}
