package com.zt.day3;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zt.utils.DBUtils;
public class UserDaoImpl implements UserDao {

	public boolean addUserBatch(List<User> users) {
		String sql="insert into  bank_user(id,name,money)"
				+ " values(seq_users.nextval,?,?)";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 boolean result=true;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 for(int i=0;i<users.size();i++){
				 User u=users.get(i);
				 pstmt.setString(1, u.getName());
				 pstmt.setDouble(2, u.getMoney());
				 pstmt.addBatch();
				 if(i%2000==0){
					 pstmt.executeBatch();
				 }
			 }
			 pstmt.executeBatch();
		 }catch(Exception e){
			 result=false;
		 }finally{
			 DBUtils.close(null, pstmt, conn);
		 }	 
		return result;
	}

	@Override
	public boolean delUserBatch(int[] usersId) {
		String sql="delete from bank_user where id=?";
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 boolean result=true;
		 try{
			 conn=DBUtils.getConnection();
			 pstmt=conn.prepareStatement(sql);
			 for(int id:usersId){
				 pstmt.setInt(1, id); 
				 pstmt.addBatch();
			 }
			 pstmt.executeBatch();
		  }catch(Exception e){
			 result=false;
		 }finally{
			 DBUtils.close(null, pstmt, conn);
		 }	 
		return result;
	}
	
	  public static void main(String[] args) {
		  UserDao dao=new UserDaoImpl();
		 /* List<User> users=new ArrayList<User>();
		  for(int i=0;i<1000;i++){
			  User u=new User();
			  u.setName("aaa"+i);
			  u.setMoney(100+i);
			  users.add(u);
		  }
		  boolean f=dao.addUserBatch(users);
		  System.out.println(f);*/
		  
		  int[] usersId=new int[500];
		  for(int i=0;i<500;i++){
			  usersId[i]=21+i;
		  }
		  boolean f=dao.delUserBatch(usersId);
		  System.out.println(f);
	}

}
