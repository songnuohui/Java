package com.zt.dao;

import com.zt.po.User;

public interface UserDao {
   public User login(String name,String pass);
}
