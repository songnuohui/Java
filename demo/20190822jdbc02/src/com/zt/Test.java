package com.zt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zt.dao.AddressBookDao;
import com.zt.dao.impl.AddressBookDaoImpl;
import com.zt.po.AddressBook;

public class Test {
	public static void main(String[] args) throws ParseException {
		AddressBookDao dao=new AddressBookDaoImpl();
		/*	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=sdf.parse("1982-08-18");
		AddressBook book=new AddressBook("�ŷ�","Ů","13199988888",
				"�������ſƼ����޹�˾",dt);
		boolean f=dao.addAddressBook(book);
		if(f){
			System.out.println("��ӳɹ���");
		}else{
			8System.out.println("���ʧ�ܣ�");
		}  */
		
	/*	AddressBook book=dao.getAddressBookById(2);
		System.out.println(book);
		book.setName("��ɺɺ");
		book.setTel("138686666655");
		boolean f=dao.updateAddressBook(book);
		if(f){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
		AddressBook book2=dao.getAddressBookById(2);
		System.out.println(book2);
		
		boolean f3=dao.delAddressBook(2);
		if(f3){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		} */
		
		Map filter=new HashMap();
		filter.put("name", "��");
		filter.put("sex", "Ů");
		filter.put("tel", "13");
		filter.put("company", "����");
		List<AddressBook> books=dao.seachByFilter(filter);
		for(AddressBook book:books){
			System.out.println(book);
		}
		
	}

}
