package com.zt.po;
/*
 * ѧ��������ϸ��
 * */
public class ExamDetail {
	private int id;
	private int examId;        //����id
	private int questionId;    //��ȡ������Ŀid
	private String answer;     //��Ŀ����ȷ��
	private double score;      //��Ŀ�ķ���
	private String stuAnswer;  //������
	private double stuScore;    //������õķ���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}
	public double getStuScore() {
		return stuScore;
	}
	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}
	

}
