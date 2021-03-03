package com.game.bankline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.entity.Conta;
import com.game.bankline.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criarConta(Conta conta) {
		return contaRepository.save(conta);
	}
	
	public List<Conta> buscarTodasContas(String login){
		return contaRepository.findByNumero(login);
	}

}
