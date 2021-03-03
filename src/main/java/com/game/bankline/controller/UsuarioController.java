package com.game.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.UsuarioDto;
import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Usuario;
import com.game.bankline.service.ContaService;
import com.game.bankline.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(value="Usuario API REST")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping("{id}")
	@ApiOperation(value="Retorna o usuário pelo ID")
	public ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable Integer id){
		UsuarioDto responseData = new UsuarioDto();
        
        responseData = usuarioService.findUsuarioById(id);

        return ResponseEntity.ok().body(responseData);		
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody Usuario usuario){
		UsuarioDto responseData = new UsuarioDto();
		
		responseData = usuarioService.createUsuario(usuario);
		
		return ResponseEntity.status(201).body(responseData);
	}
	
	@GetMapping("/contas/{login}")
	public ResponseEntity<List<Conta>> buscarTodasContas(@PathVariable String login){
		
		return ResponseEntity.ok().body(contaService.buscarTodasContas(login));
	}

}
