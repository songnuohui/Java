package com.zt;
import java.sql.*;

import com.zt.utils.DBUtils;
public class TestJDBCDelet02 {
	public static void main(String[] args) {	
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			String sql="delete from dept where deptno=80";			
			int num=stmt.executeUpdate(sql);
			if(num==1){System.out.println("É¾³ý³É¹¦£¡");
			}else{System.out.println("É¾³ýÊ§°Ü£¡");
			}	
		 } catch(Exception e) {
			e.printStackTrace();
		}finally{
			 DBUtils.close(null, stmt, conn);
		 }
		
	}
}
