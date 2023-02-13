package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.entity.User;

public class UserDAO {

	public User authenticate(String userId,String pwd)
	{
		String sql = "select role from users where userid=? and password=?";
		User user = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				user = new User(userId, rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;	
	}
	
}
