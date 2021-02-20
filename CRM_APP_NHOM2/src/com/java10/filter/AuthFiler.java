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
@WebFilter(urlPatterns ="/*")
public class AuthFiler implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse respone = (HttpServletResponse)resp;
		String path = request.getServletPath();
		if(URL.LOGIN.equals(path))
				{
			chain.doFilter(req, resp);
			return;
		}
		
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userAfterLogin");
		if(userDTO == null) {
			respone.sendRedirect(request.getContextPath() + URL.LOGIN);
			return;
		}
		
		chain.doFilter(req, resp);
	}
}
