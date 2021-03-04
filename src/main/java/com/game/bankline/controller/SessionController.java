package com.game.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.game.bankline.dto.CredenciaisDto;
import com.game.bankline.dto.SessaoDto;
import com.game.bankline.entity.Usuario;
import com.game.bankline.exceptions.SenhaInvalidaException;
import com.game.bankline.service.ContaService;
import com.game.bankline.service.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(value = "Session API REST")
public class SessionController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ContaService contaService;

    @PostMapping("/login")
    public ResponseEntity<SessaoDto> autenticar(@RequestBody CredenciaisDto credenciais) {
        try {
        	SessaoDto sessao =  usuarioService.autenticar(credenciais);

            return ResponseEntity.ok().body(sessao);

        } catch (UsernameNotFoundException | SenhaInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
    @PostMapping("/trocarsenha")
    public ResponseEntity<String> trocarSenha(@RequestBody CredenciaisDto credenciais) {
        try {
            Usuario usuario = new Usuario();
            usuario.setLogin(credenciais.getLogin());
            usuario.setSenha(credenciais.getSenha());

            usuarioService.changePassword(credenciais);

            return ResponseEntity.status(202).body("Senha alterada com sucesso");

        } catch (UsernameNotFoundException | SenhaInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}
