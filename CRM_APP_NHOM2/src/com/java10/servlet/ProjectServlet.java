package com.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.util.Path;
import com.java10.util.URL;
@WebServlet(urlPatterns = URL.USER_ADD_PROJECT)
public class ProjectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.USER_ADD_PROJECT: {
			req.getRequestDispatcher(Path.ADD_PROJECT).forward(req, resp);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.USER_ADD_PROJECT: {
			String range = req.getParameter("range");
			String []strs = range.split(" to ");
			String star =strs[0];
			String end  =strs[1];
			
			
			System.out.println(star+end);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	
}
