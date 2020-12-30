package com.zt.dao.impl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zt.dao.AddressBookDao;
import com.zt.po.AddressBook;
import com.zt.utils.DBUtils;
public class AddressBookDaoImpl implements AddressBookDao {

	@Override
	public boolean addAddressBook(AddressBook book) {
		String sql="insert into t_addressBook(id,name,sex,tel,"
				 + "birthDay,company)"
				 + " values(seq_book.nextval,?,?,?,?,?)";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getSex());
			pstmt.setString(3, book.getTel());
			pstmt.setDate(4, new java.sql.Date(book.getBirthDay().getTime()));
			pstmt.setString(5, book.getCompany());	
			int num=pstmt.executeUpdate();
			if(num==1){
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	@Override
	public AddressBook getAddressBookById(int id) {
		String sql="select * from t_addressBook where id=?";
		AddressBook book=null; Connection conn=null;
		PreparedStatement pstmt=null; ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				String tel=rs.getString("tel");
				String company=rs.getString("company");
				Date birthDay=rs.getDate("birthDay");
				book=new AddressBook(name,sex,tel,company,birthDay);
				book.setId(rs.getInt("id"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		
		return book;
	}

	@Override
	public boolean updateAddressBook(AddressBook book) {
		String sql="update t_addressBook set name=?,sex=?,tel=?,"
				 + "birthDay=?,company=?"
				 + " where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getSex());
			pstmt.setString(3, book.getTel());
			pstmt.setDate(4, new java.sql.Date(book.getBirthDay().getTime()));
			pstmt.setString(5, book.getCompany());
			pstmt.setInt(6, book.getId());
			int num=pstmt.executeUpdate();
			if(num==1){
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	@Override
	public boolean delAddressBook(int id) {
		String sql="delete from t_addressBook where id=?";
		boolean result=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			int num=pstmt.executeUpdate();
			if(num==1){
				result=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtils.close(null, pstmt, conn);
		}
		return result;
	}

	@Override
	public List<AddressBook> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressBook> seachByFilter(Map filter) {
		String sql="select * from t_addressBook where 1=1";
		if(filter.get("name")!=null){
			sql+=" and name like '%"+filter.get("name")+"%'";
		}
		if(filter.get("sex")!=null){
			sql+=" and sex like '%"+filter.get("sex")+"%'";
		}
		if(filter.get("tel")!=null){
			sql+=" and tel like '%"+filter.get("tel")+"%'";
		}
		if(filter.get("company")!=null){
			sql+=" and company like '%"+filter.get("company")+"%'";
		}
		List<AddressBook> books=new ArrayList<AddressBook>();
		Connection conn=null;
		PreparedStatement pstmt=null; ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				String tel=rs.getString("tel");
				String company=rs.getString("company");
				Date birthDay=rs.getDate("birthDay");
				AddressBook book=new AddressBook(name,sex,tel,company,birthDay);
				book.setId(rs.getInt("id"));
				books.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return books;
	}
 public boolean addBatchAddressBook(List<AddressBook> books){
		boolean result=true;
		String sql="insert into t_addressBook(id,name,sex,tel,"
				 + "birthDay,company)"
				 + " values(seq_book.nextval,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			int count=0;
			for(AddressBook book:books){
				pstmt.setString(1, book.getName());
				pstmt.setString(2, book.getSex());
				pstmt.setString(3, book.getTel());
				pstmt.setDate(4, new java.sql.Date(book.getBirthDay().getTime()));
				pstmt.setString(5, book.getCompany());	
				pstmt.addBatch(); //把这次执行放入批处理池
				count++;
				if(count%10000==0){ 
					//批量的数据也不宜太大  以10000为单位进行批处理
					pstmt.executeBatch();
					count=0;
				}
			}
			pstmt.executeBatch(); //执行这个批处理			
		}catch(Exception e){
			result=false;
		}finally{
			DBUtils.close(null, pstmt, conn);
		}	
		return result;
	}	

}
