package com.zt.po;
/*
 * 题目类型对象   QuestionType
 *         1单选  2多选  3判断 4填空  5问答
 * */
public class QuestionType {
	private int id;
	private String name;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
