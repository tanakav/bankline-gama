package com.game.bankline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	Optional<Conta> findByNumeroAndTipoConta(String numeroDaConta, Integer tipoMovimento);
	
	List<Conta> findAllByNumero(String numeroDaConta);
	
	Optional<Conta> getFirstByNumero(String login);

}
