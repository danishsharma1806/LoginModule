package com.capg.login.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.login.Dao.UserDaoImpl;
import com.capg.login.Entity.UserBean;
import com.capg.login.Service.UserServiceImpl;
@SpringBootTest
class login {
	@Autowired
	UserServiceImpl service;
	@Autowired
	UserDaoImpl dao;
	static UserBean bean;

	@Test
	void testValdateUserName() {
		assertEquals(true, service.valdateUserName("DanishSharma"));		
	}

@Test
void testValidateUserPassword() {
	assertEquals(true, service.validateUserPassword("Danish@1234"));
}
@Test
	void testValidateUserEmail() {
	assertEquals(true, service.validateUserEmail("dan@gmail.com"));
	}

	@Test
	void testValidateUserPhoneNo() {
		assertEquals(true, service.validateUserPhoneNo(9827327306l));
	}
}
