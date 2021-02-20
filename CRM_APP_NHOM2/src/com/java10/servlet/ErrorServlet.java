package com.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.util.URL;
import com.java10.util.Path;


@WebServlet(urlPatterns = {URL._403_ERROR, URL._404_ERROR})
public class ErrorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL._403_ERROR: {
			req.getRequestDispatcher(Path.ERROR_403).forward(req, resp);
			break;
		}
		case URL._404_ERROR:
			req.getRequestDispatcher(Path.ERROR_404).forward(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getContextPath());
		}
	
	}
}
