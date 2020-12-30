package com.zt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zt.dao.AddressBookDao;
import com.zt.dao.impl.AddressBookDaoImpl;
import com.zt.po.AddressBook;

public class TestMany {
    public static void main(String[] args) throws ParseException {
    	AddressBookDao dao=new AddressBookDaoImpl();
    	long n=System.currentTimeMillis();
    	for(int i=0;i<10000;i++){
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		Date dt=sdf.parse("1982-08-18");
    		AddressBook book=new AddressBook("张"+i,"女","1319998"+i,
    				"江西电信科技有限公司",dt);
    		boolean f=dao.addAddressBook(book);
    		
    	}
    	long n2=System.currentTimeMillis();
    	System.out.println(n2-n);  //205875
	}
}
