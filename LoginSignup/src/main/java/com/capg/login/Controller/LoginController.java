package com.capg.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.login.exceptions.InvalidInputException;
import com.capg.login.Entity.UserBean;
import com.capg.login.Service.IUserService;

@RestController

public class LoginController {
	
	@Autowired
	IUserService service;

	@PostMapping("user/reg")
	public String addUsers(@RequestBody  UserBean bean) 
	{   
		UserBean bean1=service.addNewUser(bean);
		return "Hello " +bean1+"Sucessfully Registered";
	}

	@GetMapping("/adminlogin/{name}/{password}")   
	public String adminLogin(@PathVariable String name,@PathVariable String password) throws Exception
	{	
		if(name.equals("UrsulaCorbero")&&password.equals("Tokio"))
			return "Login Sucessful...!";
		else 
			return "Invalid name or password";
	}
		 
	@GetMapping("/userLogin/{name}/{password}")
	public String userLogin(@PathVariable String name,@PathVariable String password)throws InvalidInputException 
	{		
		List<UserBean> bean2= service.userLogin(name, password);	
		boolean flag=false;
		for(UserBean userbean: bean2) 
		{
			if(name==null||password==null) 
			{
				throw new InvalidInputException("name or password cannot be Empty");
			}
			else if(userbean.getUserName().equals(name.trim())&&userbean.getPassword().equals(password.trim())) 
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
			return("Login Sucessfully......!!!");
	
		return "Invalid name or password! Try Again...! If not a user please Register.";
	}
	
	@GetMapping("user/findall")    
	public List<UserBean> getall() 
	{
		List<UserBean> bean = service.getAll();
		return bean;
	}

}









































































/*@GetMapping("/Login1/{name}/{password}")
public String logg(@PathVariable String name,@PathVariable String password) {
	String been=service.loggs(name, password);
	
	return "Invalid name or password";

}*/