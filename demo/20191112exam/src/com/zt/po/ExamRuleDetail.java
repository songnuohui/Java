package com.zt.po;
/*
 * ���Թ�����ϸ ����
 * */
public class ExamRuleDetail {
	private int id;      
	private int examRuleId;   //���Թ���Id
	private int typeId;      //��Ŀ����Id
	private int num;        //��Ŀ����
	private double score;   //ÿ�����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExamRuleId() {
		return examRuleId;
	}
	public void setExamRuleId(int examRuleId) {
		this.examRuleId = examRuleId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	

}
