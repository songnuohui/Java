package com.zt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zt.dao.QuestionDao;
import com.zt.po.ExamRuleDetail;
import com.zt.po.Question;
import com.zt.po.QuestionOption;
import com.zt.utils.DBUtils;

public class QuestionDaoImpl implements QuestionDao {
	//生成考试情况
	public boolean addExam(int examRuleId,int stuId,List<Question> questions){
		 String sql="insert into t_exam(id,studentId,"
			   		+ "examRuleId,score,point,examtime,status) "
			   		+ "values(seq_exam.nextval,"
			   		+ "?,?,0,0,0,'0')";	
		 
		 String sql3="insert into t_examdetail(id,examId,"
			   		+ "questionId,answer,score,stuAnswer,"
			   		+ "stuScore) values(seq_examdetail.nextval,"
			   		+ "seq_exam.currval,?,?,?,null,0)";
			  
		 boolean result=true;
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 try{
			 conn=DBUtils.getConnection();
			 conn.setAutoCommit(false);
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, stuId); 
			 pstmt.setInt(2,examRuleId);
			 pstmt.executeUpdate();  
			 
			pstmt=conn.prepareStatement(sql3);
			for(Question quest:questions){
					pstmt.setInt(1, quest.getId());
					   pstmt.setString(2, quest.getAnswer());
					   pstmt.setDouble(3,quest.getScore());
					   pstmt.addBatch();
			    }
				   pstmt.executeBatch();
				   conn.commit();
		 }catch(Exception e){
			 try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			 e.printStackTrace();
		 }finally{
			 if(conn!=null){
				  try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
			 DBUtils.close(null, pstmt, conn);
		 } 
		 return result;
	}
	//随机抽取题目方法 (科目 题型  数量);
	public List<Question> getQuestionByRandom(int subjectId, int questType,
			int num,double score) {
		String sql="select * from "
				    + " (select * from t_question "
				    + "where subjectId=? and  "
				    + "typeId=? order by dbms_random.random)"
				   + " where rownum<=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Question> questions=new ArrayList<Question>();
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, subjectId);
			pstmt.setInt(2, questType);
			pstmt.setInt(3, num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Question q=new Question();
				q.setId(rs.getInt("id"));
				q.setSubjectId(rs.getInt("subjectId"));
				q.setTypeId(rs.getInt("typeId"));
				q.setTitle(rs.getString("title"));
				q.setAnswer(rs.getString("answer"));
				q.setStatus(rs.getString("status"));
				q.setScore(score);
				questions.add(q);
			}  
		  }catch(Exception e){
			
			e.printStackTrace();
		  }finally{ 
			DBUtils.close(rs, pstmt, conn);
		  }	
		return questions;
	}
	//根据题目查询题目选项
	public List<QuestionOption> getQuestionOption(int qestionId){
		List<QuestionOption> options=new ArrayList<QuestionOption>();
		String sql="select * from t_questionoption where questionId=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, qestionId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				QuestionOption o=new QuestionOption();
				o.setId(rs.getInt("id"));
				o.setQuestionId(qestionId);
				o.setContent(rs.getString("content"));
				options.add(o);
			}
           }catch(Exception e){
			e.printStackTrace();
		  }finally{ 
			DBUtils.close(rs, pstmt, conn);
		  }	
		return options;
	}

}
