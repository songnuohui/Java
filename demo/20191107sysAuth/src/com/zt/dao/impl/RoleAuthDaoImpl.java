package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zt.dao.RoleAuthDao;
import com.zt.po.RoleAuth;
import com.zt.util.DBUtils;

public class RoleAuthDaoImpl implements RoleAuthDao {
	public boolean roleGrant(int roleId, int[] auths) {
		boolean result=true;
		String sql1="delete from t_roleAuth where roleId=?";
		String sql2="insert into t_roleAuth(roleId,authId)"
				 + "  values(?,?)";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 try{
			 conn=DBUtils.getConnection();
			 conn.setAutoCommit(false);
			 pstmt=conn.prepareStatement(sql1);
			 pstmt.setInt(1, roleId);
			 pstmt.executeUpdate();
			 pstmt=conn.prepareStatement(sql2);
			 for(int authId:auths){
				 pstmt.setInt(1, roleId);
				 pstmt.setInt(2, authId); pstmt.addBatch();
			 }
			 pstmt.executeBatch();
			 conn.commit();
			 
		 }catch(Exception e){
			 result=false;
			 try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 e.printStackTrace();
		 }finally{
			 try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 DBUtils.close(null, pstmt, conn);
		 }
		return result;
	}
	 public List<RoleAuth> findAuthByRole(int roleId){
		 List<RoleAuth> roleAuths=new ArrayList();
		 String sql="select * from t_roleAuth where roleId=?";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, roleId);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 RoleAuth ra=new RoleAuth();
				 ra.setRoleId(rs.getInt("roleId"));
				 ra.setAuthId(rs.getInt("authId"));
				 roleAuths.add(ra);
			 }
		 }catch(Exception e){
				 e.printStackTrace();
		 }finally{
			 DBUtils.close(rs, pstmt, conn);
		 }	 
		 return roleAuths;
	 }

}
