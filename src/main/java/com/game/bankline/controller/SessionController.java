package com.game.bankline.controller;

import com.game.bankline.dto.CredenciaisDto;
import com.game.bankline.dto.UsuarioDto;
import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Usuario;
import com.game.bankline.exceptions.SenhaInvalidaException;
import com.game.bankline.security.JwtUtil;
import com.game.bankline.service.ContaService;
import com.game.bankline.service.UserDetailsServiceImpl;
import com.game.bankline.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
@Api(value = "Session API REST")
public class SessionController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ContaService contaService;

    @PostMapping("/login")
    public ResponseEntity<String> autenticar(@RequestBody CredenciaisDto credenciais) {
        try {
            Usuario usuario = new Usuario();
            usuario.setLogin(credenciais.getLogin());
            usuario.setSenha(credenciais.getSenha());

            String token = "Bearer" + usuarioService.autenticar(usuario);

            return ResponseEntity.ok().body(token);

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
