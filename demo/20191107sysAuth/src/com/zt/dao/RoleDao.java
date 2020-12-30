package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.Role;
import com.zt.util.PageUtil;

public interface RoleDao {
   public boolean addRole(Role role);
   
   public Role getRoleById(int roleId);
   
   /*·ÖÒ³+Ä£ºý²éÑ¯*/
   public int  getTotalSize(Map filter);
   public List<Role> finByPage(Map filter,PageUtil page);
}
