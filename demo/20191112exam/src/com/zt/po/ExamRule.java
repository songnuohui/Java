package com.zt.po;
/*
 * ���Թ������
 * */
public class ExamRule {
	private int id;
	private int subjectId;    //������Ŀid
	private String subjectName;  //������Ŀ����
	private String name;     //���Թ������� ���� java��һ�β���
	private int examTime;    //����ʱ��  45 90 60
	private double score;    //�Ծ��ܷ�
	private double point;   //��ѧ��  
	                    //������ܻ�ȡ ���ݳɼ�score%100*point
	private String status;  //״̬
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	

}
