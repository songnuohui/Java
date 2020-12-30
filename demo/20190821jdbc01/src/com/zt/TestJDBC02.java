package com.zt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC02 {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String name="scott";
	private static final String pass="tiger";
   public static void main(String[] args) {
	   try {
		   // 1:加载驱动类
		Class.forName(driver);
		//2:获取数据库连接
		Connection conn=DriverManager.
				        getConnection(url, name,pass);
		System.out.println(conn);
	    }catch(Exception e) {
		   e.printStackTrace();
	    } 
}
}
