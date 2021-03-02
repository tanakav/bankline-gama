package com.game.bankline.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.bankline.dto.CredenciaisDto;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	private JwtUtil jwtUtil;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(
			HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException{
		
		try {
			CredenciaisDto credenciais = new ObjectMapper().readValue(request.getInputStream(),CredenciaisDto.class);
			UsernamePasswordAuthenticationToken authToken = 
					new UsernamePasswordAuthenticationToken(credenciais.getLogin(),credenciais.getSenha(), new ArrayList<>());
			
			Authentication auth = authenticationManager.authenticate(authToken);
			
			return auth;
			
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException{
		String login = ((UserDetailsModel) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToke(login);
		response.addHeader("Authorization", "Bearer " + token);
	}

}
