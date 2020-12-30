package com.zt.util;
import java.sql.*;
/*
 * 数据库连接工具类
 * */
public class DBUtils {
   private static final String className="oracle.jdbc.driver.OracleDriver";
   private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
   private static final String user="scott";
   private static final String password="tiger";
   public static Connection getConnection(){
	   Connection conn=null;
	   try{
		   Class.forName(className);
		   conn=DriverManager.getConnection(url,user,password);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return conn;
   }
   public static  void close(ResultSet rs,Statement stmt,
		                     Connection conn){
	   try{
		   if(rs!=null){rs.close();}
		   if(stmt!=null){stmt.close();}
		   if(conn!=null){ conn.close();}
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
public static boolean executeUpdate(String sql,Object[]params){
	   boolean result=true;
	   Connection conn=null;
	   PreparedStatement psmt=null;
	   try{
		   conn=DBUtils.getConnection();
		   psmt=conn.prepareStatement(sql);
		   for(int i=0;i<params.length;i++){
			   psmt.setObject(i+1, params[i]);
		   }
		   psmt.executeUpdate();
	   }catch(Exception e){
		   e.printStackTrace();
		   result=false;
	   }finally{
		   DBUtils.close(null, psmt, conn);
	   } 
	   return result;
   }
}
