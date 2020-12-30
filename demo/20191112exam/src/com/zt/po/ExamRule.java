package com.zt.po;
/*
 * 考试规则对象
 * */
public class ExamRule {
	private int id;
	private int subjectId;    //所属科目id
	private String subjectName;  //所属科目名称
	private String name;     //考试规则名称 比如 java第一次测试
	private int examTime;    //考试时长  45 90 60
	private double score;    //试卷总分
	private double point;   //总学分  
	                    //及格才能获取 根据成绩score%100*point
	private String status;  //状态
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
