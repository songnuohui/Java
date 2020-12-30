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
    		//1:加载驱动类
			Class.forName(className);
			//2:获取数据库连接
			 conn=DriverManager.
					   getConnection(url, user, password);
			//3:创建一个可以执行sql语句的对象 Statement
			 stmt=conn.createStatement();
			//4:执行sql 并处理结果
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
			 //5：释放资源  (结果集 rs -> stmt-> connection)
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
