package com.zt.dao.impl;
import java.sql.*;
import java.util.*;

import com.zt.dao.UserDao;
import com.zt.po.User;
import com.zt.utils.DBUtils;
import com.zt.utils.PageUtil;

public class UserDaoImpl implements UserDao {
	public boolean reg(String name, String pass) {
		String sql="insert into t_user(userId,name,pass,status)"
				+ " values(seq_user.nextval,?,?,'1')";
		boolean result=true;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.executeUpdate();
		}catch(Exception e){
			result=false;
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}	
		return result;
	}
	public User login(String name, String pass) {
		String sql="select * from t_user "
				 + "where name=? and pass=?";
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setStatus(rs.getString("status"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return user;
	}

	public int getToatalSize(Map filter) {
		int totalSize=0;
		String sql="select count(*) totalSize from t_user where 1=1";
		if(filter.get("name")!=null){
			sql+=" and name like '%"+filter.get("name")+"%'";
		}
		if(filter.get("status")!=null){
			sql+=" and status='"+filter.get("status")+"'";
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				//totalSize=rs.getInt(1);
				totalSize=rs.getInt("totalSize");
			}
		 }catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		 }
		return totalSize;
	}

	@Override
	public List<User> findUserBypage(Map filter, PageUtil page) {
		List<User> userList=new ArrayList<User>();
		String sql="select t.*,rownum n from t_user t"
				+ " where rownum<=?";
		if(filter.get("name")!=null){
			sql+=" and name like '%"+filter.get("name")+"%'";
		}
		if(filter.get("status")!=null){
			sql+=" and status='"+filter.get("status")+"'";
		}
		String newsql="select * from ("+sql+") t2 "
				+ " where t2.n>?";
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
				User user=new User();
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setStatus(rs.getString("status"));
				userList.add(user);
			}		
		}catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		 }	
		return userList;
	}
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
