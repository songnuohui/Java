package com.zt.dao;
import java.util.*;

import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.po.Question;
import com.zt.po.QuestionOption;
public interface QuestionDao {
	//生成考试情况
	public boolean addExam(int examRuleId,int stuId,
			        List<Question> questions);
	
    //随机抽取题目方法 (科目 题型  数量);
	public List<Question> getQuestionByRandom
	(int subjectId,int questType,int num,double score);
	
	//根据题目查询题目选项
	public List<QuestionOption> getQuestionOption(int qestionId);
	
}
