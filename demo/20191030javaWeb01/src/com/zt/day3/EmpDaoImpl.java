package com.zt.day3;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zt.utils.DBUtils;
public class EmpDaoImpl implements EmpDao {
	public List<Emp> findAll() {
		List<Emp> emps=new ArrayList<Emp>();
		String sql="select * from  emp";
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				Emp emp=new Emp();
				emp.setEmpNo(rs.getInt("empNo"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setSal(rs.getDouble("sal"));
				BigDecimal bc=(BigDecimal)rs.getObject("comm");
				if(bc==null){
					emp.setComm(null);
				}else{
					emp.setComm(bc.doubleValue());
				}
				emp.setHireDate(rs.getDate("hireDate"));
				emp.setDeptNo(rs.getInt("deptNo"));
				emps.add(emp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, stmt, conn);
		}
		
		
		
		return emps;
	}
	public static void main(String[] args) {
		EmpDao dao=new EmpDaoImpl();
		List<Emp> emps=dao.findAll();
		for(Emp e:emps){
			System.out.println(e);
		}
		
	}

}
