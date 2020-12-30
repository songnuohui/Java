package com.zt.dao.impl;
import java.sql.*;
import java.util.*;

import com.zt.dao.DeptDao;
import com.zt.po.Dept;
import com.zt.utils.DBUtils;

public class DeptDaoImpl implements DeptDao {
	public List<Dept> findAll() {
		String sql="select * from dept";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Dept> deptList=new ArrayList();
	     try{
	    	 conn=DBUtils.getConnection();
	    	 pstmt=conn.prepareStatement(sql);
	    	 rs=pstmt.executeQuery();
	    	 while(rs.next()){
	    		 Dept d=new Dept();
	    		  d.setDeptNo(rs.getInt("deptNo"));
	    		  d.setDname(rs.getString("dname"));
	    		  d.setLoc(rs.getString("loc"));
	    		  deptList.add(d);
	    	 }    	 
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally{
	    	 DBUtils.close(rs, pstmt, conn);
	     }
		return deptList;
	}

}
