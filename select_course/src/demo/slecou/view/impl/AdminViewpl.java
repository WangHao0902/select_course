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
		System.out.println("�������Ա�˺�");
		String adminName=input.next();
		System.out.println("��������");
		String password=input.next();
		//����DAOadmin�µ����ݿ��ѯ��¼����(��̬)
		AdminDAO adao = new AdminDAOpl();
		
		return adao.adminLogin(adminName, password);
	}
	

}
