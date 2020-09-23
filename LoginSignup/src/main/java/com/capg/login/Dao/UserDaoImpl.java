package com.capg.login.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


//import com.capg.login.Entity.AdminLogin;
import com.capg.login.Entity.UserBean;


@Repository //database for creation 
@Transactional //declaring classes and subclasses
public class UserDaoImpl implements IUserDao
{ 
	
	@PersistenceContext
	EntityManager entityManager; 
		
	@Override
	public UserBean addNewUser(UserBean bean) 
	{
		entityManager.persist(bean); 
		return bean;
	}
	
	@Override
	public List<UserBean> userLogin(String name,String password) 
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
