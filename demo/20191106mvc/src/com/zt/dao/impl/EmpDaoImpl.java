package com.zt.dao.impl;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zt.dao.EmpDao;
import com.zt.po.Emp;
import com.zt.utils.DBUtils;
import com.zt.utils.PageUtil;

public class EmpDaoImpl implements EmpDao {
	public int getTotalSize(Map filter) {
		String sql="select count(*) from emp where 1=1";
		int size=0;
		if(filter.get("ename")!=null){
			sql+=" and ename like '%"+filter.get("ename")+"%'";
		}
		if(filter.get("job")!=null){
			sql+=" and job ='"+filter.get("job")+"'";
		}
		if(filter.get("deptNo")!=null){
			sql+=" and deptNo ="+filter.get("deptNo")+"";
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
				 size=rs.getInt(1);
			 }	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}		
		return size;
	}

	public List<Emp> findByPage(Map filter, PageUtil page) {
String sql="select e.*,rownum n from emp e where rownum<=?";
		if(filter.get("ename")!=null){
			sql+=" and e.ename like '%"+filter.get("ename")+"%'";
		}
		if(filter.get("job")!=null){
			sql+=" and e.job ='"+filter.get("job")+"'";
		}
		if(filter.get("deptNo")!=null){
			sql+=" and e.deptNo ="+filter.get("deptNo")+"";
		}
		String newSql="select * from ("+sql+") t where t.n>?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Emp> emps=new ArrayList<Emp>();
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(newSql);
			pstmt.setInt(1, page.getCurrPage()*page.getPageSize());
			pstmt.setInt(2, (page.getCurrPage()-1)*page.getPageSize());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Emp emp=new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
			    emp.setEname(rs.getString("ename"));
			    emp.setJob(rs.getString("job"));
			    emp.setMgr(rs.getInt("mgr"));
			    emp.setHireDate(rs.getDate("hireDate"));
			    emp.setSal(rs.getDouble("sal"));
			   BigDecimal b=(BigDecimal)rs.getObject("comm");
			   if(b!=null){emp.setComm(b.doubleValue());}
			   else{emp.setComm(null);}
			    emp.setDeptNo(rs.getInt("deptNo"));	
				emps.add(emp);
			}
		 }catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		 }	
		return emps;
	}

}
