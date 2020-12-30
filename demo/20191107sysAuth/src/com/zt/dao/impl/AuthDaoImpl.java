package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zt.dao.AuthDao;
import com.zt.po.Auth;
import com.zt.util.DBUtils;
import com.zt.util.PageUtil;

public class AuthDaoImpl implements AuthDao {
	public boolean addAuth(Auth auth) {
		String sql="insert into t_auth"
				+ "(id,name,url,parentId,status) "
				+ "values(seq_auth.nextval,?,?,?,?)";
		Object[] params={auth.getName(),auth.getUrl(),
				 auth.getParent()!=null?auth.getParent().getId():null
				         ,auth.getStatus()};
		return DBUtils.executeUpdate(sql, params);
	}

	@Override
	public boolean updateAuth(Auth auth) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Auth> findByLeave(int leave){
		 List<Auth> authList=new ArrayList<Auth>();
		 String sql="";
		 if(leave==1){
			 sql="select * from t_auth where parentId is null";
		 }else{
			 sql="select * from t_auth where parentId is not null"; 
		 }
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 Auth auth=new Auth();
				 auth.setId(rs.getInt("id"));
				 auth.setName(rs.getString("name"));
				 Auth parent=new Auth();
				 parent.setId(rs.getInt("parentId"));
				 auth.setParent(parent);
				 authList.add(auth);
			 } 
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 
		 return authList;
	}
	@Override
	public Auth getAuthById(int authId) {
		Auth auth=null;
		 String sql="select * from t_auth where id=?";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, authId);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
				 auth=new Auth();
				 auth.setId(rs.getInt("id"));
				 auth.setName(rs.getString("name"));
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 
		return auth;
	}

	@Override
	public int getTotalSize(Map filter) {
	    String sql="select count(*) from t_auth where 1=1";
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
	public List<Auth> findByPage(Map filter, PageUtil page) {
		  String sql="select s.*,p.name pname,rownum n from"
		  		+ " t_auth s  ,t_auth p "
		  		+ "where s.parentId=p.id(+)"
		  		+ " and rownum<=?";
		    if(filter.get("name")!=null){
		    	sql+=" and s.name like '%"+filter.get("name")+"%'";
		    }
		    if(filter.get("status")!=null){
		    	sql+=" and s.status='"+filter.get("status")+"'";
		    }
		    String newsql="select * from("+sql+") t where t.n>?";  
		    List<Auth> authList=new ArrayList();
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
					 Auth auth=new Auth();
					 auth.setId(rs.getInt("id"));
					 auth.setName(rs.getString("name"));
					 auth.setUrl(rs.getString("url"));
					 auth.setStatus(rs.getString("status"));
					 Auth parent=new Auth();
					 parent.setId(rs.getInt("parentId"));
					 parent.setName(rs.getString("pname"));
					 auth.setParent(parent);
					 authList.add(auth);
				 } 
			 }catch(Exception e){
				 e.printStackTrace();
			 }finally{
				 DBUtils.close(rs, pstmt, conn);
			 }	 
		     return authList;
	}
	public List<Auth> findAuthByRole(int roleId){
		 String sql="select * from t_auth where id in"
		 		+ "(select  authId from t_roleAuth "
		 		+ "where roleId=?)";
		 List<Auth> authList=new ArrayList();
		 Connection conn=null;
	     PreparedStatement pstmt=null;
	     ResultSet rs=null; 
	     try{
	    	 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, roleId);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 Auth auth=new Auth();
				 auth.setId(rs.getInt("id"));
				 auth.setName(rs.getString("name"));
				 auth.setUrl(rs.getString("url"));
				 auth.setStatus(rs.getString("status"));
				 Auth parent=new Auth();
				 parent.setId(rs.getInt("parentId"));
				 auth.setParent(parent);
				 authList.add(auth);
			 } 
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 DBUtils.close(rs, pstmt, conn);
	     }	 
	    return authList;	 
	}
}
