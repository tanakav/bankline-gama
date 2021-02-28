package com.game.bankline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

}
