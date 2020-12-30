package com.zt.dao.impl;
import java.sql.*;

import com.zt.dao.BankUserDao;
import com.zt.utils.DBUtils;
public class BankUserDaoImpl implements BankUserDao {
	public boolean changMoney(int fromId, int toId, double money){
		String sql1="update bank_user set money=money-? where id=?";
		String sql2="update bank_user set money=money+? where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean result=true;
		try{
			conn=DBUtils.getConnection();
			//1：jdbc事务的默认自动提交true 改为 false
			conn.setAutoCommit(false); 
			pstmt=conn.prepareStatement(sql1);
			pstmt.setDouble(1, money);
			pstmt.setInt(2, fromId);
			pstmt.executeUpdate();	
			//int n=10/0;
			pstmt=conn.prepareStatement(sql2);
			pstmt.setDouble(1, money);
			pstmt.setInt(2, toId);
			pstmt.executeUpdate();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			result=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

}
