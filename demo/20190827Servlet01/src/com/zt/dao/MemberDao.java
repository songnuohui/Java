package com.zt.dao;
import java.util.List;

import com.zt.po.Member;
public interface MemberDao {
   public Member login(String name,String pass);
   public List<Member> findAll();
}
