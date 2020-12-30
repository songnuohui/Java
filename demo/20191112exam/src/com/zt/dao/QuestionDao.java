package com.zt.dao;
import java.util.*;

import com.zt.po.ExamRule;
import com.zt.po.ExamRuleDetail;
import com.zt.po.Question;
import com.zt.po.QuestionOption;
public interface QuestionDao {
	//���ɿ������
	public boolean addExam(int examRuleId,int stuId,
			        List<Question> questions);
	
    //�����ȡ��Ŀ���� (��Ŀ ����  ����);
	public List<Question> getQuestionByRandom
	(int subjectId,int questType,int num,double score);
	
	//������Ŀ��ѯ��Ŀѡ��
	public List<QuestionOption> getQuestionOption(int qestionId);
	
}
