package com.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java10.util.URL;
import com.java10.util.Path;
import com.java10.DTO.UserDTO;
import com.java10.userService.UserService;

@WebServlet(urlPatterns = {URL.LOGIN,
						 URL.LOGOUT
})
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.LOGIN:
			req.getRequestDispatcher(Path.LOGIN).forward(req, resp);
			break;
		case URL.LOGOUT:
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(req.getContextPath() + URL.LOGIN);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.LOGIN:
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			UserDTO userDTO = userService.login(email, password);
			if(userDTO == null) {
				req.setAttribute("messege", "Sai thông tin đăng nhập");
				req.getRequestDispatcher(Path.LOGIN).forward(req, resp);
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("userAfterLogin", userDTO);
				session.setMaxInactiveInterval(60);
				resp.sendRedirect(req.getContextPath() + URL.HOME);
			}
			break;
		}
	}
}
