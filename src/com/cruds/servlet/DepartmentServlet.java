package com.cruds.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Department;
import com.cruds.service.DepartmentService;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Department> dlist =  DepartmentService.getAll();
		request.setAttribute("DEPTLIST", dlist);
		
		
      RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/dept.jsp");
      rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		          //should be light and it is of request response
		HttpSession session = request.getSession(true);
		session.removeAttribute("MESSAGE");
		
		String action = request.getParameter("ACTION");
		
	//if i use action.equals("CREATE") ==> nullpointer	
		if("CREATE".equals(action))
		{
			String deptId = request.getParameter("deptId");
			String deptName = request.getParameter("deptName");
			//System.out.println(deptId);
			//System.out.println(deptName);
			
			if(DepartmentService.create(new Department(Integer.parseInt(deptId), deptName)))
			{
				session.setAttribute("MESSAGE", "Department created successfully");
			}
			else
			{
				session.setAttribute("MESSAGE", "Error while creating");
			}

		}
		else if("DELETE".equals(action))
		{
			String delDeptId = request.getParameter("delDeptId");
			//System.out.println("Action is deleted " + delDeptId );
			if(DepartmentService.delete(Integer.parseInt(delDeptId)))
			{
				session.setAttribute("MESSAGE", "Department deleted successfully");
			}
		}
		else if("UPDATE".equals(action))
		{
			String deptId = request.getParameter("deptId");
			String deptName = request.getParameter("deptName");
			//System.out.println("Action is updated to "+ deptName);
			if(DepartmentService.update(new Department(Integer.parseInt(deptId), deptName)));
			{
				session.setAttribute("MESSAGE", "Department updated successfully");
			}
		}
		
	/*	List<Department> dlist =  DepartmentService.getAll();
		request.setAttribute("DEPTLIST", dlist);

		RequestDispatcher rd =request.getRequestDispatcher("dept.jsp");
		rd.forward(request, response);*/
		
		response.sendRedirect("/webdemo/DepartmentServlet");//to avoid form submission
		
	}

}
