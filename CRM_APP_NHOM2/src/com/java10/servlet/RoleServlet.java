package com.java10.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.DTO.RoleDTO;
import com.java10.roleService.RoleService;
import com.java10.util.URL;
import com.java10.util.Path;

@WebServlet (urlPatterns = {

URL.ROLE_ADD,
URL.ROLE_LIST,
URL.ROLE_DELETE,
URL.ROLE_EDIT
})
public class RoleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RoleService    roleService;
	
	@Override
	public void init() throws ServletException {
		roleService = new RoleService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case URL.ROLE_ADD:
			req.getRequestDispatcher(Path.ROLE_ADD).forward(req, resp);
			break;
		case URL.ROLE_LIST:
			List<RoleDTO> listDto = roleService.getAll();
			req.setAttribute("role", listDto);
			req.getRequestDispatcher(Path.ROLE_LIST).forward(req, resp);
			break;
		case URL.ROLE_DELETE:
			roleService.delete(Integer.valueOf(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + URL.ROLE_LIST);
			break;
		case URL.ROLE_EDIT:
			var role = roleService.getRoleDTOByID(Integer.valueOf(req.getParameter("id")));
			req.setAttribute("roleEdit", role);
			req.getRequestDispatcher(Path.ROLE_EDIT).forward(req, resp);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoleDTO role = new RoleDTO(req.getParameter("name"),req.getParameter("description"));
		switch (req.getServletPath()) {
	
		case URL.ROLE_ADD: {
			roleService.insert(role);
			resp.sendRedirect(req.getContextPath() + URL.ROLE_LIST);
			break;
		}
		case URL.ROLE_EDIT:
			role.setId(Integer.valueOf(req.getParameter("id")));
			roleService.edit(role);
			resp.sendRedirect(req.getContextPath() + URL.ROLE_LIST);
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + req.getServletPath());
		}
	}
	
}
