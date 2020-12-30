package com.zt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.zt.dao.AddressBookDao;
import com.zt.po.AddressBook;
import com.zt.utils.DBUtils;

import java.sql.*;
public class AddressBookDaoImpl implements AddressBookDao {
	public boolean addAddressBook(AddressBook book) {
		String sql="insert into t_addressbook(id,name,sex,tel,"
				 + "company,birthDay)"
				 + " values(seq_book.nextval,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getSex());
			pstmt.setString(3, book.getTel());
			pstmt.setString(4, book.getCompany());
			pstmt.setDate(5,new java.sql.Date(book.getBirthDay().getTime()));
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
	public boolean updateAddressBook(AddressBook book) {
		String sql="update t_addressbook set name=?,sex=?,tel=?,"
				 + "company=?,birthDay=?"
				 + " where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getSex());
			pstmt.setString(3, book.getTel());
			pstmt.setString(4, book.getCompany());
			pstmt.setDate(5,new java.sql.Date(book.getBirthDay().getTime()));
			pstmt.setInt(6, book.getId());
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
	public boolean delAddressBook(int bookId) {
		String sql="delete from  t_addressbook where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean result=false;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
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
	public AddressBook getAddressBookById(int bookId) {
		String sql="select * from t_addressbook where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AddressBook book=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				book=new AddressBook();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setSex(rs.getString("sex"));
				book.setTel(rs.getString("tel"));
				book.setCompany(rs.getString("company"));
				book.setBirthDay(rs.getDate("birthDay"));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return book;
	}

	@Override
	public List<AddressBook> findAll() {
		String sql="select * from t_addressbook";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AddressBook> books=new ArrayList<AddressBook>();
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				AddressBook	book=new AddressBook();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setSex(rs.getString("sex"));
				book.setTel(rs.getString("tel"));
				book.setCompany(rs.getString("company"));
				book.setBirthDay(rs.getDate("birthDay"));
				books.add(book);
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return books;
	}

	@Override
	public AddressBook login(String name, String tel) {
		String sql="select * from t_addressbook where name=? and tel=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AddressBook book=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			rs=pstmt.executeQuery();
			if(rs.next()){
				book=new AddressBook();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setSex(rs.getString("sex"));
				book.setTel(rs.getString("tel"));
				book.setCompany(rs.getString("company"));
				book.setBirthDay(rs.getDate("birthDay"));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return book;
	}

}
