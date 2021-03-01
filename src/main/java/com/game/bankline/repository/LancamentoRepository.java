package com.game.bankline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
	
	List<Lancamento> findAllByConta(Integer id);
}
