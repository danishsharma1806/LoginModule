package com.capg.login.Service;

import java.util.List;

import com.capg.login.Entity.UserBean;


public interface IUserService {
	
	
	public UserBean addNewUser(UserBean bean);
	public List<UserBean> userLogin(String name, String password);
	//public String loggs(String name,String password);
	public List<UserBean> getAll();
}
