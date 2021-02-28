package com.game.bankline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.bankline.entity.PlanoConta;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer>{

	List<PlanoConta> findByLogin(String login);

	
}
