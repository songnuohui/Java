package com.zt.po;

/*
 * javaBean  �����淶��
 *     1����������˽��  ������ ���ϱ�ʶ���Ĺ淶 ��С�շ�����
 *     2��Ϊ���������ṩget/set����
 *     3���ṩĬ�Ϲ�����
 * */
public class Dept {
	private int deptNo;
	private String dname;
	private String loc;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
