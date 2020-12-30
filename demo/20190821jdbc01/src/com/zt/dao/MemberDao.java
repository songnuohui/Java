package com.zt.dao;
import java.util.List;
import com.zt.po.Member;
/*
 * 定义Member对象操作的接口
 * 注册 登录  登录成功可以修改密码
 也可以查询所有其他账户 可以注销自身账户功能
 * */
public interface MemberDao {
  //注册
    public boolean reg(Member member);
    public boolean update(Member member);
    public boolean delete(int memberId);
    public Member login(String name,String pass);
    public Member relogin(String name,String pass);
    public List<Member> findAll();
    
}
