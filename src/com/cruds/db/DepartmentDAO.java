package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.Department;

public class DepartmentDAO {
	
	public boolean update(Department d)
	{
		String sql = "update department set deptname=? where deptid=?";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDeptName());
			ps.setInt(2, d.getDeptId());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows > 0;
	}
	
	public boolean delete(int deptId)
	{
		String sql = "delete from department where deptid=?";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, deptId);
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows>0;
	}
	
	public List<Department> getAll()
	{
		String sql = "select deptid,deptname from department";
		List<Department> list = new ArrayList<Department>();
		Department d = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				d = new Department(rs.getInt(1), rs.getString(2));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean create(Department d)
	{
		String sql = "insert into department(deptid,deptname) values(?,?)";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, d.getDeptId());
			ps.setString(2, d.getDeptName());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
				
		return rows>0;		
	}

}
