package com.zt.po;
/*
 * 学生考试类
 * */
public class Exam {
	private int id;
	private int studentId;    //考生Id
	private int examRuleId;   //考试规则Id 考那套试卷
	private int examTime;    //考试实际用的时间
	private double score;   //考生成绩
	private double point;   //获得的学分
	private String status="0";  //试卷的状态  0 未批改  1已批改
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
