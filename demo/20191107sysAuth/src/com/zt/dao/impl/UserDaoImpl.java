package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zt.dao.UserDao;
import com.zt.po.User;
import com.zt.util.DBUtils;

public class UserDaoImpl implements UserDao{
	public User login(String name, String pass) {
		String sql="select * from t_user where name=? and pass=?";
		User user=null;
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, name);pstmt.setString(2, pass);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
				 user=new User();
				 user.setId(rs.getInt("id"));
				 user.setName(rs.getString("name"));
				 user.setPass(rs.getString("pass"));
				 user.setStatus(rs.getString("status"));
				 user.setRoleId(rs.getInt("roleId"));
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 
		
		return user;
	}
	

}
