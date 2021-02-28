package com.game.bankline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByCpf(String cpf);
	
	Optional<Usuario> findByLogin(String login);

}
