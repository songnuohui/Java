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
		AddressBook book=new AddressBook("张菲","女","13199988888",
				"江西电信科技有限公司",dt);
		boolean f=dao.addAddressBook(book);
		if(f){
			System.out.println("添加成功！");
		}else{
			8System.out.println("添加失败！");
		}  */
		
	/*	AddressBook book=dao.getAddressBookById(2);
		System.out.println(book);
		book.setName("张珊珊");
		book.setTel("138686666655");
		boolean f=dao.updateAddressBook(book);
		if(f){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
		AddressBook book2=dao.getAddressBookById(2);
		System.out.println(book2);
		
		boolean f3=dao.delAddressBook(2);
		if(f3){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		} */
		
		Map filter=new HashMap();
		filter.put("name", "张");
		filter.put("sex", "女");
		filter.put("tel", "13");
		filter.put("company", "江西");
		List<AddressBook> books=dao.seachByFilter(filter);
		for(AddressBook book:books){
			System.out.println(book);
		}
		
	}

}
