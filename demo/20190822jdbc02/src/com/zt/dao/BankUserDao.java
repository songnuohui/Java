package com.zt.dao;

public interface BankUserDao {
   public boolean changMoney(int fromId,int toId,double money);
}
