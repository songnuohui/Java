package com.zt.day3;

import java.util.List;

public interface UserDao {
   public boolean addUserBatch(List<User> user);
   public boolean delUserBatch(int[] usersId);
}
