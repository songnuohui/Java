package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zt.dao.RoleDao;
import com.zt.po.Auth;
import com.zt.po.Role;
import com.zt.util.DBUtils;
import com.zt.util.PageUtil;

public class RoleDaoImpl implements RoleDao {
	public boolean addRole(Role role) {
		String sql="insert into t_role(id,name,status)"
				+ " values(seq_role.nextval,?,?)";
		Object[] params={role.getName(),role.getStatus()};
		return DBUtils.executeUpdate(sql, params);
	}
	public Role getRoleById(int roleId) {
		Role role=null;
		 String sql="select * from t_role where id=?";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, roleId);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
				 role=new Role();
				 role.setId(rs.getInt("id"));
				 role.setName(rs.getString("name"));
				 role.setStatus(rs.getString("status"));
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 
		return role;
	}

	@Override
	public int getTotalSize(Map filter) {
		 String sql="select count(*) from t_role where 1=1";
		    if(filter.get("name")!=null){
		    	sql+=" and name like '%"+filter.get("name")+"%'";
		    }
		    if(filter.get("status")!=null){
		    	sql+=" and status='"+filter.get("status")+"'";
		    }
		    int size=0;
		    Connection conn=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs=null;
			 try{
				 conn=DBUtils.getConnection();
				 pstmt=conn.prepareStatement(sql);
				 rs=pstmt.executeQuery();
				 if(rs.next()){
					 size=rs.getInt(1);
				 }
			  }catch(Exception e){
				 e.printStackTrace();
			  }finally{
				 DBUtils.close(rs, pstmt, conn);
			  }	 
			return size;
	}

	@Override
	public List<Role> finByPage(Map filter, PageUtil page) {
		String sql="select r.* ,rownum n from "
				+ "t_role r where rownum<=?";
	    if(filter.get("name")!=null){
	    	sql+=" and r.name like '%"+filter.get("name")+"%'";
	    }
	    if(filter.get("status")!=null){
	    	sql+=" and r.status='"+filter.get("status")+"'";
	    }
	    String newsql="select * from ("+sql+") where n>?";
	    List<Role> roleList=new ArrayList<Role>();
	    Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(newsql);
			 pstmt.setInt(1, page.getCurrPage()*page.getPageSize());
			 pstmt.setInt(2, (page.getCurrPage()-1)*page.getPageSize());
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 Role role=new Role();
				 role.setId(rs.getInt("id"));
				 role.setName(rs.getString("name"));
				 role.setStatus(rs.getString("status"));
				 roleList.add(role);
			 } 
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 	    
		return roleList;
	}

}
