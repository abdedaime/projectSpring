package com.pfa.app.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IServiceUser;

/**
 * 
 * @author hicham-pc
 * 
 */
public class MySuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	private IServiceUser service;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());

		HttpSession session = request.getSession();
		Utilisateur   user=service.getUser(authentication.getName());
		session.setAttribute("access", user);
		if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("index.htm");
			return;
		}
		response.sendRedirect("addCv.htm");
	}

}
