package demo.slecou.view.impl;

import java.util.Scanner;

import demo.slecou.dao.AdminDAO;
import demo.slecou.dao.impl.AdminDAOpl;
import demo.slecou.po.Admin;
import demo.slecou.view.AdminView;

public class AdminViewpl implements AdminView{
	private Scanner input = new Scanner(System.in);

	@Override
	public Admin adminLogin() {
		// TODO Auto-generated method stub
		System.out.println("输入管理员账号");
		String adminName=input.next();
		System.out.println("输入密码");
		String password=input.next();
		//调用DAOadmin下的数据库查询登录方法(多态)
		AdminDAO adao = new AdminDAOpl();
		
		return adao.adminLogin(adminName, password);
	}
	

}
