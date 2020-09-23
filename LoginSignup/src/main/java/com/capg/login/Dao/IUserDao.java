package com.capg.login.Dao;

import java.util.List;

//import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;

public interface IUserDao {
	
	public UserBean addNewUser(UserBean bean);
	public List<UserBean> userLogin(String name, String password);
	public List<UserBean> getAll();
	
}
