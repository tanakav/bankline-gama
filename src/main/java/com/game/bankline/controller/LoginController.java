package com.game.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.CredenciaisDto;
import com.game.bankline.dto.SessaoDto;
import com.game.bankline.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public SessaoDto logar(@RequestBody CredenciaisDto credenciais) {
		return loginService.logar(credenciais);
	}

}
