package com.game.bankline.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.game.bankline.dto.CredenciaisDto;
import com.game.bankline.dto.SessaoDto;
import com.game.bankline.entity.Usuario;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.exceptions.RequiredFieldsException;
import com.game.bankline.repository.UsuarioRepository;
import com.game.bankline.security.JwtUtil;

@Service
public class LoginService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder bCryptPassEncoder;
	
	public SessaoDto logar(CredenciaisDto credenciais) {
		
		if(credenciais.getLogin() == null || credenciais.getSenha() == null) {
			throw new RequiredFieldsException("Por favor preencher login e senha");
		}
		
		if(!usuarioRepository.findByLogin(credenciais.getLogin()).isPresent()) {
			throw new ObjectNotFoundException("Usuario de login "+credenciais.getLogin()+" nao encontrado");
		}
		
		Usuario usuario = usuarioRepository.findByLogin(credenciais.getLogin()).get();
		
		if(bCryptPassEncoder.matches(credenciais.getSenha(), usuario.getSenha())) {
			SessaoDto sessao = new SessaoDto();
			
			sessao.setUsuario(usuario);
			sessao.setToken(jwtUtil.generateToken(credenciais.getLogin()));
			sessao.setDataInicio(new Date(System.currentTimeMillis()));
			sessao.setDataFim(new Date(System.currentTimeMillis() + jwtUtil.getExpiration()));
			
			return sessao;
		}
		
		
		return null;
	}

}
