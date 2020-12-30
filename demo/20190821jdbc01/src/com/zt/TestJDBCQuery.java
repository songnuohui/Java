package com.zt;
import java.sql.*;
public class TestJDBCQuery {
	private static final String className="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String user="scott";
	private static final String password="tiger";
      public static void main(String[] args) {
    	  Connection conn=null;
    	  Statement stmt=null;
    	  ResultSet rs=null;
    	 try {
    		//1:����������
			Class.forName(className);
			//2:��ȡ���ݿ�����
			 conn=DriverManager.
					   getConnection(url, user, password);
			//3:����һ������ִ��sql���Ķ��� Statement
			 stmt=conn.createStatement();
			//4:ִ��sql ��������
			String sql="select * from dept";
			 rs=stmt.executeQuery(sql);
			while(rs.next()){
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				System.out.println(deptno+","+dname+","+loc);
			}
					
		  } catch (Exception e) {
			e.printStackTrace();
		 }finally{
			 //5���ͷ���Դ  (����� rs -> stmt-> connection)
			 try {
				 if(rs!=null){
					 rs.close();
				 }
				 if(stmt!=null){
					 stmt.close();
				 }
				 if(conn!=null){
					 conn.close();
				 }
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		 }
	}
}
