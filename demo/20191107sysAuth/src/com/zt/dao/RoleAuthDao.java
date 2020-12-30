package com.zt.dao;
import java.util.List;
import com.zt.po.RoleAuth;
public interface RoleAuthDao {
 public boolean roleGrant(int roleId,int auths[]);
 public List<RoleAuth> findAuthByRole(int roleId);
}
