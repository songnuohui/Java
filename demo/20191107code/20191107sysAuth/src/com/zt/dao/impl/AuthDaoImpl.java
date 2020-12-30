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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Auth> findByPage(Map filter, PageUtil page) {
		// TODO Auto-generated method stub
		return null;
	}

}
