package com.cruds.service;

import java.util.List;

import com.cruds.db.DepartmentDAO;
import com.cruds.entity.Department;

public class DepartmentService {
	
	public static boolean update(Department d)
	{
		DepartmentDAO dao = new DepartmentDAO();
		return dao.update(d);
	}
	
	public static boolean delete(int deptId)
	{
		DepartmentDAO dao = new DepartmentDAO();
		return dao.delete(deptId);
	}
	
	public static List<Department> getAll()
	{
		DepartmentDAO dao = new DepartmentDAO();
		return dao.getAll();
	}
	
	public static boolean create(Department d)
	{
		DepartmentDAO dao = new DepartmentDAO();
		return dao.create(d);
	}

}
