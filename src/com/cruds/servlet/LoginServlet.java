package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.User;
import com.cruds.service.UserService;

/**
 * Servlet implementation class LoginServel
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		RequestDispatcher rd = null;
		
		User user = UserService.authenticate(userId, pwd);
		
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("USER", user);
			rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		}
		else 
		{
			request.setAttribute("ERROR", "Invalid user credentials");
			rd = request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}

}
