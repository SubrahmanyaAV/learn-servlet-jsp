package com.cruds.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Book;
import com.cruds.service.BookService;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> listbook = BookService.getAll();
		request.setAttribute("BOOKLIST", listbook);
		
		RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("MESSAGE");
		
		String action = request.getParameter("ACTION");
		
		if("CREATE".equals(action))
		{
			String bId = request.getParameter("bId");
			String bName = request.getParameter("bName");
			//System.out.println(bId);
			//System.out.println(bName);
			
			if(BookService.create(new Book(Integer.parseInt(bId), bName)))
			{
				session.setAttribute("MESSAGE", "Book created");
			}
			else
			{
				session.setAttribute("MESSAGE", "error while creating");
			}
		}
		else if("DELETE".equals(action))
		{
			String delBId = request.getParameter("delBId");
			System.out.println(delBId + "deleted");
		/*	if(BookService.delete(Integer.parseInt(delBId)))
			{
				session.setAttribute("MESSAGE", "Book deleted successfully");
			}*/
		}
		else if("UPDATE".equals(action))
		{
			String bId = request.getParameter("bId");
			String bName = request.getParameter("bName");
			System.out.println("Action is updated to "+ bName);
			if(BookService.update(new Book(Integer.parseInt(bId), bName)));
			{
				session.setAttribute("MESSAGE", "Book updated successfully");
			}
		}
		

		response.sendRedirect("/webdemo/BookServlet");
		
	}

}
