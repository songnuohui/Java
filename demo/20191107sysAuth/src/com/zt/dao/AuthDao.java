package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.Auth;
import com.zt.util.PageUtil;

public interface AuthDao {
    public boolean addAuth(Auth auth);
    public boolean updateAuth(Auth auth);
    public Auth getAuthById(int authId);
    //���ݼ����ȡģ��
    public List<Auth> findByLeave(int leave);
    
    /*ģ����ѯ��ҳ*/
    public int getTotalSize(Map filter);
    public List<Auth> findByPage(Map filter,PageUtil page);
    
    /*���ݽ�ɫid ��ѯ��ɫӵ�е�Ȩ���б�*/
    public List<Auth> findAuthByRole(int roleId);
    
}
