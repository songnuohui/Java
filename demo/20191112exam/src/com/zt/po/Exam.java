package com.zt.po;
/*
 * ѧ��������
 * */
public class Exam {
	private int id;
	private int studentId;    //����Id
	private int examRuleId;   //���Թ���Id �������Ծ�
	private int examTime;    //����ʵ���õ�ʱ��
	private double score;   //�����ɼ�
	private double point;   //��õ�ѧ��
	private String status="0";  //�Ծ��״̬  0 δ����  1������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getExamRuleId() {
		return examRuleId;
	}
	public void setExamRuleId(int examRuleId) {
		this.examRuleId = examRuleId;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
