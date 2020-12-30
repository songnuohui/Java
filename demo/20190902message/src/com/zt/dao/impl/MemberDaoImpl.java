package com.zt.dao.impl;
import java.sql.*;

import com.zt.dao.MemberDao;
import com.zt.po.Member;
import com.zt.utils.DBUtils;
public class MemberDaoImpl implements MemberDao {
	public Member login(String name) {
		String sql="select * from t_member where name=? ";
		Member member=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			   DBUtils.close(rs, pstmt, conn);
		}
		
		return member;
	}

}
