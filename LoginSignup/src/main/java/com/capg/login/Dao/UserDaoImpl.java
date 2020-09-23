package com.capg.login.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cap.login.exceptions.UserException;
//import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;


@Repository //database for creation 
@Transactional //declaring classes and subclasses
public class UserDaoImpl implements IUserDao
{ 
	
	@PersistenceContext
	EntityManager entityManager; 
		
	@Override
	public UserBean addNewUser(UserBean bean) throws UserException
	{
		String regexUsername="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		String regexPassword="[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		String regexEmail="[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
		if(bean == null)
			throw new UserException("user cannont be null");
		else if(!bean.getUserName().matches(regexUsername)) 
			throw new UserException("Username should contain atleast 8 alphanumeric characters");
		else if(!bean.getPassword().matches(regexPassword)) 
			throw new UserException("Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
		else if(!bean.getUserEmail().matches(regexEmail)) 
			throw new UserException("Email Id NOT valid");
		else if(bean.getUserPhone().length()<10 && bean.getUserPhone().charAt(0)==0) 
			throw new UserException("Phone number should be of 10 digits");
		
		entityManager.persist(bean); 
		return bean;
	}
	
	@Override
	public List<UserBean> userLogin(String name,String password) throws UserException
	{
		TypedQuery<UserBean> query=entityManager.createQuery(" from UserBean", UserBean.class);	
		return query.getResultList();
	}

	@Override
	public List<UserBean> getAll() 
	{
		TypedQuery<UserBean> query = entityManager.createQuery("from UserBean", UserBean.class);
		return query.getResultList();
	}
}
