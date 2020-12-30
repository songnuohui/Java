package com.zt;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;
public class TestJDBC {
	public static void main(String[] args) {
		try {
			//1:加载驱动类
			OracleDriver driver=new OracleDriver();
			//2:注册驱动类
			DriverManager.registerDriver(driver);		
			//3：获取数据库连接
			 //java 访问数据库的时候 固定签名
			//  jdbc:数据库厂家名:@数据库服务器地址:端口号:数据库名
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			Connection conn=DriverManager.getConnection
					          (url, "scott", "tiger");
			System.out.println(conn);
		 } catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
