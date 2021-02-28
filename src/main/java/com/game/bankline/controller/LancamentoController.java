package com.game.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.repository.LancamentoRepository;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoController {
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	
	@GetMapping()
	public List<Lancamento> listarLancamentos(){
		return  lancamentoRepository.findAll();
	}
	
	@PostMapping
	public Lancamento salvarLancamento(@RequestBody Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
}
