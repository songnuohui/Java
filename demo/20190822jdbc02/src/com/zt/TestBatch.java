package com.zt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zt.dao.AddressBookDao;
import com.zt.dao.impl.AddressBookDaoImpl;
import com.zt.po.AddressBook;

public class TestBatch {
   public static void main(String[] args) throws ParseException {
		AddressBookDao dao=new AddressBookDaoImpl();
		long n=System.currentTimeMillis();
		List<AddressBook> books=new ArrayList();
		for(int i=0;i<100000;i++){
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		Date dt=sdf.parse("1982-08-18");
    		AddressBook book=new AddressBook("��"+i,"Ů","1319998"+i,
    				"�������ſƼ����޹�˾",dt);
    		books.add(book);
    	}
		dao.addBatchAddressBook(books);
		long n2=System.currentTimeMillis(); //205875
		System.out.println(n2-n);//1094
   }
}
