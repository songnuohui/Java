package com.zt.dao;
import java.util.List;

import com.zt.po.AddressBook;
public interface AddressBookDao {
    public boolean addAddressBook(AddressBook book);
    public boolean updateAddressBook(AddressBook book);
    public boolean delAddressBook(int bookId);
    public AddressBook getAddressBookById(int bookId);
    public List<AddressBook> findAll();
    public AddressBook login(String name,String tel);
}
