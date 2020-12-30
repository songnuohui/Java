package com.zt.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zt.dao.MemberDao;
import com.zt.po.Member;
import com.zt.utils.DBUtils;
public class MemberDaoImpl implements MemberDao {

	public Member login(String name, String pass) {
		String sql="select * from t_member where name=? and pass=?";
		Member member=null;
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
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtils.close(rs, pstmt, conn);
		}
		
		return member;
	}
	 public List<Member> findAll(){
		 List<Member> members=new ArrayList<Member>();
		 String sql="select * from t_member ";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try{
				conn=DBUtils.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Member member=new Member();
					member.setId(rs.getInt("id"));
					member.setName(rs.getString("name"));
					member.setPass(rs.getString("pass"));
					members.add(member);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				 DBUtils.close(rs, pstmt, conn);
			}
		 return members;
	 }
	@Override
	public Member getMember(int id) {
		String sql="select * from t_member where id=?";
		Member member=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtils.close(rs, pstmt, conn);
		}
		
		return member;
	}
	@Override
	public boolean updateMember(Member member) {
		String sql="update t_member set name=? ,pass=? where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPass());
			pstmt.setInt(3, member.getId());
			int num=pstmt.executeUpdate();
			if(num==1){result=true;}
		 }catch(Exception e){
		 	e.printStackTrace();
		}finally{
			 DBUtils.close(null, pstmt, conn);
		}
		return result;
	}
	@Override
	public boolean delMember(int id) {
		String sql="delete from t_member where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, id);
			int num=pstmt.executeUpdate();
			if(num==1){result=true;}
		 }catch(Exception e){
		 	e.printStackTrace();
		}finally{
			 DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

}
