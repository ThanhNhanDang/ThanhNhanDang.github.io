package com.java10.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.util.*;

@WebServlet (urlPatterns = {URL.HOME,
							URL.AVATAR
			})

public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher(Path.HOME_PAGE).forward(req, resp);
	}
	
}
