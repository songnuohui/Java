package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.utils.PageUtil;

public interface ExamRuleDao {
	//��ҳ+ģ����ѯ ���Թ���
    public int getTotalSize(Map filter);
    public List<ExamRule> findByPage(Map filter,PageUtil page);
    
    
    //��ѯ���Թ���
    public ExamRule getExamRuleById(int ruleId);
    
    //���ݿ��Թ���id ��ѯ������ϸ
    public List<ExamRuleDetail> findExamRuleDetail(int examruleId);
}
