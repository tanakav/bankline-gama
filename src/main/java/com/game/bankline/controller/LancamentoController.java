package com.game.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.LancamentoDto;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.entity.PlanoConta;
import com.game.bankline.repository.LancamentoRepository;
import com.game.bankline.repository.PlanoContaRepository;
import com.game.bankline.service.LancamentoService;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@GetMapping()
	public List<Lancamento> listarLancamentos(){
		return  lancamentoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<String> salvarLancamento(LancamentoDto lancamentoRequest){
		
		lancamentoService.salvarLancamento(lancamentoRequest);
		
		return ResponseEntity.status(201).body("Lancamento efetuado com sucesso");
		
	}
	
	@PostMapping("/planos-conta")
	public PlanoConta salvarPlanoConta(@RequestBody PlanoConta planoConta) {
		return planoContaRepository.save(planoConta);
	}
	
	@GetMapping("/planos-conta/{login}") 
	public List<PlanoConta> listarPlanosConta(@PathVariable(value="login") String login ){
		return planoContaRepository.findByLogin(login);
	}
}
