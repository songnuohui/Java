package com.zt.dao;
import java.util.List;
import java.util.Map;

import com.zt.po.AddressBook;
public interface AddressBookDao {
	//���ͨѶ¼��¼
    public boolean addAddressBook(AddressBook book);
    //����id��ѯ����ͨѶ¼��¼
    public AddressBook getAddressBookById(int id);
    //�޸ĵ���ͨѶ¼��¼
    public boolean updateAddressBook(AddressBook book);
    //ɾ������ͨѶ¼��¼
    public boolean delAddressBook(int id);
    //��ѯ����ͨѶ¼��¼
    public List<AddressBook> findAll();
    //����ѡ������ģ����ѯƥ��ļ�¼
    public List<AddressBook> seachByFilter(Map filter);
    //�����������ͨѶ¼��¼ 
   public boolean addBatchAddressBook(List<AddressBook> books);
}
