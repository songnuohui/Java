package com.zt.po;
  /*
   * User-->��Ӧ    t_user ��
   * 
   * ������-->��Ӧ    ���ֶ� 
   * */
public class User {
    private int  userId;   
    private String name;
    private String pass;
    private String status="1";  //1����  0����
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", pass=" + pass
				+ ", status=" + status + "]";
	}
    
    
}
