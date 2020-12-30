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
    	/*System.out.println("欢迎注册成为会员，请输入账户名");
    	String name=in.nextLine();
    	System.out.println("请输入密码");
    	String pass=in.nextLine();
    	Member  member=new Member();
    	member.setName(name); member.setPass(pass);
    	boolean result=memberDao.reg(member);
    	if(result){
    		System.out.println("恭喜你注册成功！");
    	}else{
    		System.out.println("系统出现故障，请重新注册！");
    	}*/
    	
    	System.out.println("欢迎登录系统，请输入账户名");
    	String name=in.nextLine();
    	System.out.println("请输入密码");
    	String pass=in.nextLine();
    	//Member  member=memberDao.login(name, pass);
    	Member  member=memberDao.relogin(name, pass);
    	if(member==null){
    		System.out.println("用户名或密码错误");
    	}else{
    		System.out.println("欢迎登录系统"+member);
    		System.out.println("是否修改密码:y是修改 ，不改按其他任意键");
    		String changPass=in.nextLine();
    		if("y".equals(changPass)){
    			System.out.println("请输入修改后的密码");
        		String repass=in.nextLine();
        		member.setPass(repass);
        		boolean result=memberDao.update(member);
        		if(result){
        			System.out.println("密码修改成功！");
        		}else{
        			System.out.println("密码修改失败！");
        		}
    		}
    		System.out.println("是否查看所有账户:y是 ，不查看按其他任意键");
    		String list=in.nextLine();
    		if("y".equals(list)){
    			List<Member> members=memberDao.findAll();
    			for(Member m:members){
    				System.out.println(m);
    			}
    		}
    		System.out.println("是否注销账户:y是 ，不注销按其他任意键");
    		String isOver=in.nextLine();
    		if("y".equals(isOver)){
    			boolean result=memberDao.delete(member.getId());
    			if(result){
        			System.out.println("注销成功！");
        		}else{
        			System.out.println("注销失败！");
        		}
    		}
    		
    		
    	}  
    	
	}
}
