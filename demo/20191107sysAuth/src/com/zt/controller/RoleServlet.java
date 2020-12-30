package com.zt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.AuthDao;
import com.zt.dao.RoleAuthDao;
import com.zt.dao.RoleDao;
import com.zt.dao.impl.AuthDaoImpl;
import com.zt.dao.impl.RoleAuthDaoImpl;
import com.zt.dao.impl.RoleDaoImpl;
import com.zt.po.Auth;
import com.zt.po.Role;
import com.zt.po.RoleAuth;
import com.zt.util.PageUtil;
@WebServlet("/admin/system/role/role")
public class RoleServlet extends HttpServlet{
    private RoleDao roleDao;
    private AuthDao authDao;
    private RoleAuthDao roleAuthDao;
    public void init() throws ServletException {
    	roleDao=new RoleDaoImpl();
    	authDao=new AuthDaoImpl();
    	roleAuthDao=new RoleAuthDaoImpl();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String method=request.getParameter("method");
    	if("save".equals(method)){
    		save(request,response);
    	}
    	if("list".equals(method)){
    		list(request,response);
    	}
    	if("grant".equals(method)){
    		grant(request,response);
    	}
    	if("saveRoleAuth".equals(method)){
    		saveRoleAuth(request,response);
    	}
    	
     }
    protected void list(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String name=request.getParameter("name");
    	String status=request.getParameter("status");
    	Map filter=new HashMap();
    	if(name!=null&&!"".equals(name)){
    		filter.put("name", name);
    	}
    	if(status!=null&&!"".equals(status)){
    		filter.put("status", status);
    	}
    	
    	int totalSize=roleDao.getTotalSize(filter);
    	PageUtil pageUtil=new PageUtil();
    	int currPage=1;
    	String page=request.getParameter("page");
    	if(page!=null&&!"".equals(page)){
    		currPage=Integer.parseInt(page);
    	}
    	pageUtil.setCurrPage(currPage);
    	pageUtil.setPageSize(2);
    	pageUtil.setTotalSize(totalSize);
    	pageUtil.setTotalPage(totalSize);
    	List<Role> roleList=roleDao.finByPage(filter, pageUtil);
    	request.setAttribute("roleList", roleList);
    	request.setAttribute("pageUtil", pageUtil);
    	request.setAttribute("filter", filter);
    	request.getRequestDispatcher("roleList.jsp")
    	      .forward(request, response); 	
    }
    protected void save(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String name=request.getParameter("name");
    	Role role=new Role();
    	role.setName(name);
    	boolean f=roleDao.addRole(role);
    	if(f){
    		response.sendRedirect("role?method=list");
    	}else{
    		response.sendRedirect("roleAdd.jsp");
    	}
    }
    
    protected void grant(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String roleIdStr=request.getParameter("roleId");
    	int roleId=0;
    	if(roleIdStr!=null&&!"".equals(roleIdStr)){
    		roleId=Integer.parseInt(roleIdStr);
    	}
    	Role role=roleDao.getRoleById(roleId);
    	 List<RoleAuth> roleAuths=roleAuthDao.findAuthByRole(roleId);
    	List<Auth> authfirstList=authDao.findByLeave(1);
    	List<Auth> authsecondList=authDao.findByLeave(2);
    	request.setAttribute("role", role);
    	request.setAttribute("roleAuths", roleAuths);
    	request.setAttribute("firstList", authfirstList);
    	request.setAttribute("secondList", authsecondList);
    	request.getRequestDispatcher("roleGrant.jsp")
    	      .forward(request, response); 	
    }
    protected void saveRoleAuth(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String roleIdStr=request.getParameter("roleId");
    	String authIds[]=request.getParameterValues("authId");
    	int roleId=0;
    	int authId[]=new int[authIds.length];
    	if(roleIdStr!=null&&!"".equals(roleIdStr)){
    		roleId=Integer.parseInt(roleIdStr);
    	}
    	for(int i=0;i<authIds.length;i++){
    		authId[i]=Integer.parseInt(authIds[i]);
    	}
    	boolean f=roleAuthDao.roleGrant(roleId, authId);
    	if(f){
    		response.sendRedirect("role?method=list");
    	}else{
    		response.sendRedirect("error.jsp");
    	}
    	
    	
    }
    
    
}
