package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.utils.PageUtil;

public interface ExamRuleDao {
	//分页+模糊查询 考试规则
    public int getTotalSize(Map filter);
    public List<ExamRule> findByPage(Map filter,PageUtil page);
    
    
    //查询考试规则
    public ExamRule getExamRuleById(int ruleId);
    
    //根据考试规则id 查询规则明细
    public List<ExamRuleDetail> findExamRuleDetail(int examruleId);
}
