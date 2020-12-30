package com.zt.dao;
import java.util.List;
import java.util.Map;

import com.zt.po.AddressBook;
public interface AddressBookDao {
	//添加通讯录记录
    public boolean addAddressBook(AddressBook book);
    //根据id查询单条通讯录记录
    public AddressBook getAddressBookById(int id);
    //修改单条通讯录记录
    public boolean updateAddressBook(AddressBook book);
    //删除单条通讯录记录
    public boolean delAddressBook(int id);
    //查询所有通讯录记录
    public List<AddressBook> findAll();
    //根据选择条件模糊查询匹配的记录
    public List<AddressBook> seachByFilter(Map filter);
    //批量处理添加通讯录记录 
   public boolean addBatchAddressBook(List<AddressBook> books);
}
