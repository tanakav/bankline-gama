package com.game.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.UsuarioDto;
import com.game.bankline.entity.Usuario;
import com.game.bankline.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("{id}")
	public ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable Integer id){
		UsuarioDto responseData = new UsuarioDto();
        
        responseData = usuarioService.findUsuarioById(id);

        return ResponseEntity.ok().body(responseData);		
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> criarUsuario(@RequestBody Usuario usuario){
		UsuarioDto responseData = new UsuarioDto();
		
		responseData = usuarioService.createUsuario(usuario);
		
		return ResponseEntity.ok().body(responseData);
	}

}
