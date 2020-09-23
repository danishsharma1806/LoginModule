package com.capg.login.Dao;

import java.util.List;

import com.cap.login.exceptions.UserException;
//import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;

public interface IUserDao {
	
	public UserBean addNewUser(UserBean bean) throws UserException;
	public List<UserBean> userLogin(String name, String password) throws UserException;
	public List<UserBean> getAll();
	
}
