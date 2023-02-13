package com.cruds.service;

import com.cruds.db.UserDAO;
import com.cruds.entity.User;

public class UserService {

	public static User authenticate(String userId,String pwd)
	{
		UserDAO dao = new UserDAO();
		return dao.authenticate(userId, pwd);
	}
	
	
}
