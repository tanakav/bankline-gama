package com.game.bankline.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
	
	List<Lancamento> findAllByContaAndDataBetween(Integer id, Date inicio, Date fim);
}
