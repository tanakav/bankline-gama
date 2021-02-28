package com.game.bankline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
	

}
