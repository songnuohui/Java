package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.Emp;
import com.zt.utils.PageUtil;

public interface EmpDao {
   /*ģ����ѯ+��ҳ*/
	public int getTotalSize(Map filter);
	public List<Emp> findByPage(Map filter,PageUtil page);
	
	
}
