package com.zt.po;
/*
 * 考试规则明细 对象
 * */
public class ExamRuleDetail {
	private int id;      
	private int examRuleId;   //考试规则Id
	private int typeId;      //题目类型Id
	private int num;        //题目数量
	private double score;   //每题分数
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
