package com.cruds.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LifeCycleDemoServlet extends HttpServlet{
	          //lazy initialization / Loading
	public LifeCycleDemoServlet()
	{                    // 1. instantiation
		System.out.println("Inside Life Cycle Demo Servlet constructor");
	}
	
	@Override         //2.init method = initialize
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inside LC init method");
		super.init(config);
	}

	@Override     //once i stop ,it'll call destroy method
	public void destroy() {
		System.out.println("Inside LC Destroy method");
		super.destroy();
	}
	
	@Override       //service == doGet(),doPost()
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside LC get method");
		resp.setContentType("text/html");
		resp.getWriter().println("Hello life cycle servlet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside LC Post method");
		doGet(req, resp);
	}
	

}
