package com.zt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.ExamRuleDao;
import com.zt.dao.QuestionDao;
import com.zt.dao.impl.ExamRuleDaoImpl;
import com.zt.dao.impl.QuestionDaoImpl;
import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.po.Question;
import com.zt.utils.PageUtil;
@WebServlet("/exam/examRule")
public class ExamServlet extends HttpServlet{
	private ExamRuleDao examRuleDao;
	private QuestionDao questionDao;
	public void init() throws ServletException {
		examRuleDao=new ExamRuleDaoImpl(); 
		questionDao=new QuestionDaoImpl();
	}
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String method=request.getParameter("method");
    	if("list".equals(method)){
    		list(request,response);
    	}
    	if("join".equals(method)){
    		join(request,response);
    	}
    	if("submit".equals(method)){
    		submit(request,response);
    	}
    	
    }
    protected void list(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	Map filter=new HashMap();
    	String subjectId=request.getParameter("subjectId");
    	if(subjectId!=null){
    		filter.put("subjectId", Integer.parseInt(subjectId));
    	}
    	int totalSize=examRuleDao.getTotalSize(filter);
    	PageUtil pageUtil=new PageUtil();
    	pageUtil.setPageSize(10);
    	int currPage=1;
    	pageUtil.setCurrPage(currPage);
    	pageUtil.setTotalSize(totalSize);
    	pageUtil.setTotalPage(totalSize);
    	List<ExamRule> rules=examRuleDao.findByPage(filter, pageUtil);
    	request.setAttribute("rules", rules);
    	request.setAttribute("pageUtil", pageUtil);
    	request.setAttribute("filter", filter);
    	request.getRequestDispatcher("rulesList.jsp").forward(request, response);
    }
    protected void join(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String ruleIdStr=request.getParameter("ruleId");
    	int ruleId=0;
    	if(ruleIdStr!=null&&!"".equals(ruleIdStr)){
    		ruleId=Integer.parseInt(ruleIdStr);
    	}
    	//根据规则id查询考试规则
    	ExamRule rule=examRuleDao.getExamRuleById(ruleId);
    	//根据考试规则查询明细
     List<ExamRuleDetail> details=
    	            examRuleDao.findExamRuleDetail(ruleId);
     //根据规则抽取题目并记录学生考试信息
     List<Question> questionList1=null; //单选
     List<Question> questionList2=null; //多选
     List<Question> questionList3=null; //填选
     List<Question> questionList4=null; //判断
     List<Question> questionList5=null; //问答
     int subjectId=rule.getSubjectId();
     int stuId=1; //session获取登录用户的ID
    
     for(ExamRuleDetail d:details){
    	 if(d.getTypeId()==1){
    		 questionList1= questionDao.getQuestionByRandom
    				 (subjectId,d.getTypeId(), d.getNum(), d.getScore()); 
    	    for(Question q:questionList1){
    	    	q.setScore(d.getScore());
    	    	q.setOptions(questionDao.getQuestionOption(q.getId()));
    	    }  
    	 }
    	 if(d.getTypeId()==2){
    		 questionList2= questionDao.getQuestionByRandom
    				 (subjectId,d.getTypeId(), d.getNum(), d.getScore()); 
    		 for(Question q:questionList2){
     	    	q.setScore(d.getScore());
     	    	q.setOptions(questionDao.getQuestionOption(q.getId()));
     	    } 
    	 }
    	 if(d.getTypeId()==3){
    		 questionList3= questionDao.getQuestionByRandom
    				 (subjectId,d.getTypeId(), d.getNum(), d.getScore()); 
    		 for(Question q:questionList3){
     	    	q.setScore(d.getScore());
     	    } 
    	 }
    	 if(d.getTypeId()==4){
    		 questionList4= questionDao.getQuestionByRandom
    				 (subjectId,d.getTypeId(), d.getNum(), d.getScore()); 
    		 for(Question q:questionList4){
     	    	q.setScore(d.getScore());
     	    } 
    	 }
    	 if(d.getTypeId()==5){
    		 questionList5= questionDao.getQuestionByRandom
    				 (subjectId,d.getTypeId(), d.getNum(), d.getScore()); 
    		 for(Question q:questionList5){
     	    	q.setScore(d.getScore());
     	    } 
    	 } 
     }
     List<Question> allQuestion=new ArrayList();
     if(questionList1!=null&&questionList1.size()>0){
    	 allQuestion.addAll(questionList1);
     }
     if(questionList2!=null&&questionList2.size()>0){
    	 allQuestion.addAll(questionList2);
     }
     if(questionList3!=null&&questionList3.size()>0){
    	 allQuestion.addAll(questionList3);
     }
     if(questionList4!=null&&questionList4.size()>0){
    	 allQuestion.addAll(questionList1);
     }
     if(questionList5!=null&&questionList5.size()>0){
    	 allQuestion.addAll(questionList5);
     } 
     boolean f= questionDao.addExam(ruleId, stuId,allQuestion);
     request.setAttribute("rule", rule);
     request.setAttribute("details", details);
     request.setAttribute("questionList1", questionList1);
     request.setAttribute("questionList2", questionList2);
     request.setAttribute("questionList3", questionList3);
     request.setAttribute("questionList4", questionList4);
     request.setAttribute("questionList5", questionList5);
     request.getRequestDispatcher("exam.jsp").forward(request, response);
    	
    }
    protected void submit(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String method=request.getParameter("method");
    	
    }
}
