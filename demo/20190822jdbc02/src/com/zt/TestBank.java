package com.zt;

import com.zt.dao.BankUserDao;
import com.zt.dao.impl.BankUserDaoImpl;

public class TestBank {
    public static void main(String[] args) {
    	BankUserDao dao= new BankUserDaoImpl();
    	boolean f=dao.changMoney(2, 1, 500);
    	System.out.println(f);
	}
}
