package com.zt.po;
/*
 * ��Ŀѡ��
 * */
public class QuestionOption {
	private int id;
	private int questionId;    //������Ŀid
	private String content;   //ѡ������
	private String status;   //״̬
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
