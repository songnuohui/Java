package com.zt.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zt.dao.MemberDao;
import com.zt.po.Member;
import com.zt.utils.DBUtils;

public class MemberDaoImpl implements MemberDao {
	public boolean reg(Member member) {
		String sql="insert into t_member(id,name,pass)"
				 + "values(seq_member.nextval,"
				 + "'"+member.getName()+"',"
				 + "'"+member.getPass()+"')";
	// insert into t_member(id,name,pass)values(1,'xxxxxx','aaa');
		Connection conn=null;
		Statement stmt=null;
		boolean result=false;
		try{
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			int num=stmt.executeUpdate(sql);
			if(num==1){
				result=true;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(null, stmt, conn);
		}
		return result;
	}  
	

	@Override
	public boolean update(Member member) {
		String sql="update t_member set pass=? where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getPass());
			pstmt.setInt(2, member.getId());
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
	public boolean delete(int memberId) {
		String sql="delete from t_member where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberId);
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
	public Member login(String name, String pass) {
		String sql="select *  from t_member where "
				+ "name='"+name+"' and pass='"+pass+"'";
     //select *  from t_member where name='axasasasa' and  pass=' asasa' or '1'='1'
		//        asasa' or '1'='1
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Member member=null;
		try{
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
			} 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, stmt, conn);
		}
		return member;
	}
	/*  ? 代表一个占位符
	 *   sql语句中如果存在?那么处理语句的接口
	 *   只能用PreparedStatement 预处理接口
	 *   不能用Statement接口 因为Statement每次执行sql都必须编译运行 
	 * */
	public Member relogin(String name,String pass){
		String sql="select * from t_member where name=? and pass=?";
		Member member=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			//conn.createStatement()
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			while(rs.next()){
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
	public List<Member> findAll() {
		String sql="select * from  t_member";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> members=new ArrayList<Member>();
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

}
