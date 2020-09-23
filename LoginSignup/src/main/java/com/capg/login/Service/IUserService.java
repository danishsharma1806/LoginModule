package com.capg.login.Service;

import java.util.List;

import com.cap.login.exceptions.UserException;
import com.capg.login.Entity.UserBean;


public interface IUserService 
{	
	public UserBean addNewUser(UserBean bean) throws UserException;
	public List<UserBean> userLogin(String name, String password) throws UserException;
	public List<UserBean> getAll();
}
