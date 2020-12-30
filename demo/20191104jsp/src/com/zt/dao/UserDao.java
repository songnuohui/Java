package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.User;
import com.zt.utils.PageUtil;

/*
 *UserDao ����� User����Ĳ����ķ��� 
 * */
public interface UserDao {
	//�û�ע��
   public boolean reg(String name,String pass);
   //�û���¼
   public User login(String name,String pass);
   
   //��ҳ��ѯ ����
   public int getToatalSize(Map filter);
   public List<User> findUserBypage(Map filter,
		                            PageUtil page); 
   /*�޸�*/
   public User getUserById(int userId);
   public boolean update(User user);
}
