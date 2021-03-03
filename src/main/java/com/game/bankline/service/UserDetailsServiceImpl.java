package com.game.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.game.bankline.entity.Usuario;
import com.game.bankline.repository.UsuarioRepository;
import com.game.bankline.security.UserDetailsModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(usuarioRepository.findByLogin(username).isPresent()) {
			
			Usuario usuario = usuarioRepository.findByLogin(username).get();
			return new UserDetailsModel(usuario.getId(),usuario.getLogin(),usuario.getSenha(),usuario.getPerfis());
			
		}else {
			throw new UsernameNotFoundException(username);
		}
		
		
	}

}
