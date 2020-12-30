package com.zt;
import java.sql.*;
public class TestJDBCInsert {
	private static final String className="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String user="scott";
	private static final String password="tiger";
	public static void main(String[] args) {	
		Connection conn=null;
		Statement stmt=null;
		try {
			//1������������
			Class.forName(className);
			//2:��ȡ���ݿ�����
			conn=DriverManager.getConnection(url, user, password);
			//3:��������ִ��sql���Ķ���
			stmt=conn.createStatement();
			//4:ִ��sql��䲢������
			String sql="insert into dept(deptno,dname,loc)"
					  + "values(80,'�з���','�����ϲ�')";			
			int num=stmt.executeUpdate(sql);
			//num����ֵ�����ܵ�Ӱ��ļ�¼����
			//jdbc�е��������Զ��ύ�� ���Բ���Ҫ�ֹ� commit
			if(num==1){
				System.out.println("����ɹ���");
			}else{
				System.out.println("���ʧ�ܣ�");
			}	
		 } catch(Exception e) {
			e.printStackTrace();
		}finally{
			 //5���ͷ���Դ  (����� rs -> stmt-> connection)
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
