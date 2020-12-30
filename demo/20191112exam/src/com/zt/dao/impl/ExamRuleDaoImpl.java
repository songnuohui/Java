package com.zt.dao.impl;
import java.util.*;
import java.sql.*;

import com.zt.dao.ExamRuleDao;
import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.utils.DBUtils;
import com.zt.utils.PageUtil;

public class ExamRuleDaoImpl implements ExamRuleDao {
	//获得总记录数
	public int getTotalSize(Map filter) {
		String sql="select count(*) from t_examrule where 1=1";
		if(filter.get("subjectId")!=null){
			sql+=" and subjectId="+filter.get("subjectId");
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int size=0;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				size=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return size;
	}
	//分页+模糊查询
	@Override
	public List<ExamRule> findByPage(Map filter, PageUtil page) {
		List<ExamRule> rules=new ArrayList<ExamRule>();
		String sql="select r.*,rownum n,s.name sname from t_examrule r,t_subject s "
				+ "where r.subjectId=s.id and rownum<=?";
		if(filter.get("subjectId")!=null){
			sql+=" and r.subjectId="+filter.get("subjectId");
		}
		String newsql="select * from ("+sql+") where n>?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(newsql);
			pstmt.setInt(1, page.getCurrPage()*page.getPageSize());
			pstmt.setInt(2, (page.getCurrPage()-1)*page.getPageSize());
			rs=pstmt.executeQuery();
			while(rs.next()){
				ExamRule r=new ExamRule();
				r.setId(rs.getInt("id"));
				r.setSubjectId(rs.getInt("subjectId"));
				r.setName(rs.getString("name"));
				r.setExamTime(rs.getInt("examTime"));
			    r.setScore(rs.getDouble("score"));
			    r.setPoint(rs.getDouble("point"));
			    r.setStatus(rs.getString("status"));
			    r.setSubjectName(rs.getString("sname"));
			    rules.add(r);
			}	
		 }catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return rules;
	}
	//根据考试规则的id查询考试规则
	public ExamRule getExamRuleById(int ruleId){
		ExamRule rule=null;
		String sql="select * from t_examrule where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ruleId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				rule=new ExamRule();
				rule.setId(rs.getInt("id"));
				rule.setSubjectId(rs.getInt("subjectId"));
				rule.setName(rs.getString("name"));
				rule.setExamTime(rs.getInt("examTime"));
				rule.setScore(rs.getDouble("sumscore"));
				rule.setPoint(rs.getDouble("grade"));
				rule.setStatus(rs.getString("status"));
				rule.setSubjectName(rs.getString("sname"));
			}
		  }catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		}	
		return rule;
	}
	//
	public List<ExamRuleDetail> findExamRuleDetail(int examRuleId){
		List<ExamRuleDetail> details=new ArrayList<ExamRuleDetail>();
		String sql="select * from t_examruledetail "
				+ " where examRuleId=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, examRuleId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ExamRuleDetail d=new ExamRuleDetail();
				d.setId(rs.getInt("id"));
				d.setExamRuleId(examRuleId);
				d.setTypeId(rs.getInt("typeId"));
				d.setNum(rs.getInt("num"));
				d.setScore(rs.getDouble("score"));
				details.add(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		 }finally{
			DBUtils.close(rs, pstmt, conn);
		}
		return details;
	}
}
