package com.zt;
import java.util.List;
import java.util.Scanner;

import com.zt.dao.MemberDao;
import com.zt.dao.impl.MemberDaoImpl;
import com.zt.po.Member;

public class Test {
    public static void main(String[] args) {
    	MemberDao memberDao=new MemberDaoImpl();
    	Scanner in =new Scanner(System.in);
    	/*System.out.println("��ӭע���Ϊ��Ա���������˻���");
    	String name=in.nextLine();
    	System.out.println("����������");
    	String pass=in.nextLine();
    	Member  member=new Member();
    	member.setName(name); member.setPass(pass);
    	boolean result=memberDao.reg(member);
    	if(result){
    		System.out.println("��ϲ��ע��ɹ���");
    	}else{
    		System.out.println("ϵͳ���ֹ��ϣ�������ע�ᣡ");
    	}*/
    	
    	System.out.println("��ӭ��¼ϵͳ���������˻���");
    	String name=in.nextLine();
    	System.out.println("����������");
    	String pass=in.nextLine();
    	//Member  member=memberDao.login(name, pass);
    	Member  member=memberDao.relogin(name, pass);
    	if(member==null){
    		System.out.println("�û������������");
    	}else{
    		System.out.println("��ӭ��¼ϵͳ"+member);
    		System.out.println("�Ƿ��޸�����:y���޸� �����İ����������");
    		String changPass=in.nextLine();
    		if("y".equals(changPass)){
    			System.out.println("�������޸ĺ������");
        		String repass=in.nextLine();
        		member.setPass(repass);
        		boolean result=memberDao.update(member);
        		if(result){
        			System.out.println("�����޸ĳɹ���");
        		}else{
        			System.out.println("�����޸�ʧ�ܣ�");
        		}
    		}
    		System.out.println("�Ƿ�鿴�����˻�:y�� �����鿴�����������");
    		String list=in.nextLine();
    		if("y".equals(list)){
    			List<Member> members=memberDao.findAll();
    			for(Member m:members){
    				System.out.println(m);
    			}
    		}
    		System.out.println("�Ƿ�ע���˻�:y�� ����ע�������������");
    		String isOver=in.nextLine();
    		if("y".equals(isOver)){
    			boolean result=memberDao.delete(member.getId());
    			if(result){
        			System.out.println("ע���ɹ���");
        		}else{
        			System.out.println("ע��ʧ�ܣ�");
        		}
    		}
    		
    		
    	}  
    	
	}
}
