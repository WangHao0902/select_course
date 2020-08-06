package demo.slecou.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.slecou.dao.AdminDAO;
import demo.slecou.po.Admin;
import demo.slecou.util.BaseDAO;


public class AdminDAOpl extends BaseDAO implements AdminDAO{

	@Override
	public Admin adminLogin(String adminName, String password) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Admin admin=null;
		// TODO Auto-generated method stub
		String sql = "SELECT adminid, adminName, password FROM admin WHERE adminName=? AND password=?" ;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setString(1, adminName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminName(rs.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(null, pstmt, rs);
		}
		return admin;
	}
	
	
	
}
