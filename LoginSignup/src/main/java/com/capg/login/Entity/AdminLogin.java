package com.capg.login.Entity;


public class AdminLogin {

	private String adminName;

	private String adminpassword;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "AdminLogin [adminName=" + adminName + ", adminpassword=" + adminpassword + "]";
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	

}
