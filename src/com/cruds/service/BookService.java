package com.cruds.service;

import java.util.List;

import com.cruds.db.BookDAO;
import com.cruds.entity.Book;

public class BookService {
	
	public static boolean update(Book b)
	{
		BookDAO dao = new BookDAO();
		return dao.update(b);
	}
	
	public static boolean delete(int bid)
	{
		BookDAO dao = new BookDAO();
		return dao.delete(bid);
	}
	public static List<Book> getAll()
	{
		BookDAO dao = new BookDAO();
		return dao.getAll();
	}
	
	public static boolean create(Book b)
	{
		BookDAO dao = new BookDAO();
		return dao.create(b);
	}

}
