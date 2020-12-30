package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.Auth;
import com.zt.util.PageUtil;

public interface AuthDao {
    public boolean addAuth(Auth auth);
    public boolean updateAuth(Auth auth);
    public Auth getAuthById(int authId);
    //根据级别获取模块
    public List<Auth> findByLeave(int leave);
    
    /*模糊查询分页*/
    public int getTotalSize(Map filter);
    public List<Auth> findByPage(Map filter,PageUtil page);
    
    /*根据角色id 查询角色拥有的权限列表*/
    public List<Auth> findAuthByRole(int roleId);
    
}
