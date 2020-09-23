package com.capg.login.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_login")
public class UserBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	
	@NotEmpty(message = "Please provide a name")
	@Size(min=8 ,max=30)
	private String userName;
	
	@NotEmpty(message = "Please provide a password")  
	private String password;
	
	@NotEmpty(message = "Please provide a phone number")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String userPhone;
	
	
	@NotEmpty(message = "Please provide an Email")
	@Email
	private String userEmail;
	
	public int getUserId() 
	{
		return userId;              
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() 
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() 
	{
		return "UserBean [userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (password == null) 
		{
			if (other.password != null)
				return false;
		} 
		else if (!password.equals(other.password))
			return false;
		if (userEmail == null) 
		{
			if (other.userEmail != null)
				return false;
		}
		else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) 
		{
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPhone == null) 
		{
			if (other.userPhone != null)
				return false;
		} 
		else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}
		
	}

	

