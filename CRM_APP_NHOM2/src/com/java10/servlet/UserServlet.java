package com.java10.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.DTO.UserDTO;
import com.java10.roleService.RoleService;
import com.java10.userService.UserService;
import com.java10.util.URL;
import com.java10.util.Path;


@WebServlet (urlPatterns = {
		URL.USER_ADD,
		URL.USER_LIST,
		URL.USER_DELETE,
		URL.USER_EDIT,
		URL.USER_PROFILE
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService    roleService;
	private UserService    userService;
	@Override
	public void init() throws ServletException {
		userService = new UserService();
		roleService = new RoleService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.USER_LIST:
			List<UserDTO> listUser = userService.getAllUser();
			req.setAttribute("user", listUser);
			req.getRequestDispatcher(Path.USER_LIST).forward(req, resp);
			break;
		case URL.USER_ADD:
			req.setAttribute("listNameRole", roleService.getAll());
			req.getRequestDispatcher(Path.USER_ADD).forward(req, resp);
			break;
		case URL.USER_EDIT:
			req.setAttribute("listNameRole", roleService.getAll());
			int idUser = Integer.valueOf(req.getParameter("id"));
			var user = userService.findUserById(idUser);
			req.setAttribute("userEdit", user);
			req.getRequestDispatcher(Path.USER_EDIT).forward(req, resp);
			break;
		case URL.USER_DELETE:
			userService.delete(Integer.valueOf(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + URL.USER_LIST);
			break;
		case URL.USER_PROFILE:
			req.getRequestDispatcher(Path.PROFILE).forward(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String avatarPath;
		if(req.getParameter("avatar") == "")
			avatarPath = "/static/assets/images/avatars/userDefault.png";
		else 
			avatarPath = req.getParameter("avatar");
		UserDTO user = new UserDTO(req.getParameter("email"), req.getParameter("password"),
				req.getParameter("fullname"),avatarPath);
	
		switch (req.getServletPath()) {
		case URL.USER_ADD:
			user.setRole_id(Integer.valueOf(req.getParameter("roleId")));
			userService.insert(user);
			resp.sendRedirect(req.getContextPath() + URL.USER_LIST);
			break;
			
		case URL.USER_EDIT:
			user.setRole_id(Integer.valueOf(req.getParameter("roleId")));
			user.setId(Integer.valueOf(req.getParameter("id")));
			userService.edit(user);
			resp.sendRedirect(req.getContextPath() + URL.USER_LIST);
			break;
		case URL.USER_PROFILE:
			req.setAttribute("listNameRole", roleService.getAll());
			int idUser = Integer.valueOf(req.getParameter("id"));
			var userDTO = userService.findUserById(idUser);
			req.setAttribute("userEdit", userDTO);
			req.getRequestDispatcher(Path.USER_EDIT).forward(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	
}
