package com.zt.po;

import java.util.List;

/*
 * Question 题目类
 * */
public class Question {
	private int id;
	private int subjectId;    //所属科目id
	private int typeId;      //题目类型 id
	private String title;     //题目主题
	private String answer;   //答案
	private String status;   //状态
	private double score;
	private List<QuestionOption> options;
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
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public List<QuestionOption> getOptions() {
		return options;
	}
	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}
	
}
