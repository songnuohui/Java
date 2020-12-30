package com.zt.dao;

import java.util.List;
import java.util.Map;

import com.zt.po.User;
import com.zt.utils.PageUtil;

/*
 *UserDao 定义对 User对象的操作的方法 
 * */
public interface UserDao {
	//用户注册
   public boolean reg(String name,String pass);
   //用户登录
   public User login(String name,String pass);
   
   //分页查询 所有
   public int getToatalSize(Map filter);
   public List<User> findUserBypage(Map filter,
		                            PageUtil page); 
   /*修改*/
   public User getUserById(int userId);
   public boolean update(User user);
}
