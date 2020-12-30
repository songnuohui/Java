package com.zt;
import java.sql.*;
public class TestJDBCDelet {
	private static final String className="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String user="scott";
	private static final String password="tiger";
	public static void main(String[] args) {	
		Connection conn=null;
		Statement stmt=null;
		try {
			//1：加载驱动类
			Class.forName(className);
			//2:获取数据库连接
			conn=DriverManager.getConnection(url, user, password);
			//3:创建可以执行sql语句的对象
			stmt=conn.createStatement();
			//4:执行sql语句并处理结果
			String sql="delete from dept where deptno=80";			
			int num=stmt.executeUpdate(sql);
			//num返回值代表受到影响的记录条数
			//jdbc中的事务是自动提交的 所以不需要手工 commit
			if(num==1){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}	
		 } catch(Exception e) {
			e.printStackTrace();
		}finally{
			 //5：释放资源  (结果集 rs -> stmt-> connection)
			 try {
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
