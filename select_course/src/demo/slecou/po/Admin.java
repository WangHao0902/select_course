package demo.slecou.po;

public class Admin {

	private Integer adminid;
	private String adminName;
	private String password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(Integer adminid, String adminName, String password) {
		super();
		this.adminid = adminid;
		this.adminName = adminName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "adminid=" + adminid + ", adminName=" + adminName + ", password=" + password ;
	}

	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
