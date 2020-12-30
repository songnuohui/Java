package com.zt.dao;
import java.util.List;
import com.zt.po.Member;
/*
 * ����Member��������Ľӿ�
 * ע�� ��¼  ��¼�ɹ������޸�����
 Ҳ���Բ�ѯ���������˻� ����ע�������˻�����
 * */
public interface MemberDao {
  //ע��
    public boolean reg(Member member);
    public boolean update(Member member);
    public boolean delete(int memberId);
    public Member login(String name,String pass);
    public Member relogin(String name,String pass);
    public List<Member> findAll();
    
}
