package com.java10.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java10.DTO.UserDTO;
import com.java10.util.URL;

@WebFilter(urlPatterns = {"/*"})
public class CheckRoleFilter implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse respone = (HttpServletResponse)resp;
		String path = request.getServletPath();
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userAfterLogin");
		if(userDTO == null) {
			chain.doFilter(req, resp);
			
			return;
		}
		String roleName = userDTO.getRoleName();
		if( URL.ROLE_LIST.equals(path) && !roleName.equals("ROLE_ADMIN")) {
				respone.sendRedirect(request.getContextPath() + "/403");
				return;
		}
		if( URL.USER_ADD_PROJECT.equals(path) && !roleName.equals("ROLE_LEADER")) {
			respone.sendRedirect(request.getContextPath() + "/403");
			return;
		}
		chain.doFilter(req, resp);
		
	}
}
