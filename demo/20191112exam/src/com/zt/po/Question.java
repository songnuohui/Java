package com.zt.po;

import java.util.List;

/*
 * Question ��Ŀ��
 * */
public class Question {
	private int id;
	private int subjectId;    //������Ŀid
	private int typeId;      //��Ŀ���� id
	private String title;     //��Ŀ����
	private String answer;   //��
	private String status;   //״̬
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
