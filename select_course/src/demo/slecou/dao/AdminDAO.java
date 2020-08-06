package demo.slecou.dao;

import demo.slecou.po.Admin;

public interface AdminDAO {
	
	public Admin adminLogin(String adminName,String password);
	
}
