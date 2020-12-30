package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.zt.dao.MessageDao;
import com.zt.po.Member;
import com.zt.po.Message;
import com.zt.utils.DBUtils;

public class MessageDaoImpl implements MessageDao {

	@Override
	public boolean addMessage(Message message) {
		String sql="insert into t_message(id,title,content,"
				+ "memberId,createTime,ip) "
				+ "values(seq_message.nextval,?,?,?,sysdate,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try {
			conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, message.getTitle());	
			 pstmt.setString(2, message.getContent());	
			 pstmt.setInt(3, message.getMember().getId());
			 pstmt.setString(4, message.getIp());	
			 int num= pstmt.executeUpdate();
			 if(num==1){result=true;}
		 }catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	@Override
	public Message getMessageById(int messageId) {
		//Message <--select * from t_message  where id=messageId
		//  select * from  t_member where id=Message.memberId
		String sql="select msg.*, mb.name name,mb.pass pass from t_message msg,t_member mb "
				+ " where msg.memberId=mb.id and msg.id=?";
		Message msg=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				 msg=new Message();
				 msg.setId(rs.getInt("id"));
				 msg.setTitle(rs.getString("title"));
				 msg.setContent(rs.getString("content"));
				 msg.setIp(rs.getString("ip"));
				 msg.setCreateTime(rs.getDate("createTime"));
				 Member member=new Member();
				 member.setId(rs.getInt("memberId"));
				 member.setName(rs.getString("name"));
				// member.setPass(rs.getString("pass"));
				 msg.setMember(member);
			}			
		 }catch(Exception e) {
			 e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		
		return msg;
	}

	@Override
	public boolean updateMessage(Message message) {
		String sql="update t_message set title=?,content=?,"
				+ "createTime=sysdate,ip=? where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			 pstmt.setString(1, message.getTitle());	
			 pstmt.setString(2, message.getContent());	
			 pstmt.setString(3, message.getIp());	
			 pstmt.setInt(4, message.getId());
			 int num= pstmt.executeUpdate();
			 if(num==1){result=true;}
		  }catch(Exception e) {
			 e.printStackTrace();
		  }finally{
			DBUtils.close(null, pstmt, conn);
		  }
		return result;
	}
	public boolean delMessage(int messageId) {
		String sql="delete from t_message where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, messageId);
			 int num= pstmt.executeUpdate();
			 if(num==1){result=true;}
		  }catch(Exception e) {
			 e.printStackTrace();
		  }finally{
			  DBUtils.close(null, pstmt, conn);
		  }
		return result;
	}
	public List<Message> findAll(){
		List<Message> list=new ArrayList();
		String sql="select msg.*, mb.name name,mb.pass pass "
				+ "from t_message msg,t_member mb "
				+ " where msg.memberId=mb.id ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 Message msg=new Message();
				 msg.setId(rs.getInt("id"));
				 msg.setTitle(rs.getString("title"));
				 msg.setContent(rs.getString("content"));
				 msg.setIp(rs.getString("ip"));
				 msg.setCreateTime(rs.getDate("createTime"));
				 Member member=new Member();
				 member.setId(rs.getInt("memberId"));
				 member.setName(rs.getString("name"));
				 msg.setMember(member);
				 list.add(msg);
			}			
		 }catch(Exception e) {
			 e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}	
		return list;
	}

}
