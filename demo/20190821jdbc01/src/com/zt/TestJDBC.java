package com.zt;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;
public class TestJDBC {
	public static void main(String[] args) {
		try {
			//1:����������
			OracleDriver driver=new OracleDriver();
			//2:ע��������
			DriverManager.registerDriver(driver);		
			//3����ȡ���ݿ�����
			 //java �������ݿ��ʱ�� �̶�ǩ��
			//  jdbc:���ݿ⳧����:@���ݿ��������ַ:�˿ں�:���ݿ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			Connection conn=DriverManager.getConnection
					          (url, "scott", "tiger");
			System.out.println(conn);
		 } catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
