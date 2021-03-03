package com.game.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.dto.LancamentoDto;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.entity.PlanoConta;
import com.game.bankline.entity.enums.TipoMovimento;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.repository.ContaRepository;
import com.game.bankline.repository.LancamentoRepository;
import com.game.bankline.repository.PlanoContaRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	@Autowired
	private ContaService contaService;
	
	public Lancamento salvarLancamento(LancamentoDto lancamentoRequest) {
		Lancamento lancamento = new Lancamento();
				
		lancamento.setConta(lancamentoRequest.getConta());
		lancamento.setData(lancamentoRequest.getData());
		lancamento.setDescricao(lancamentoRequest.getDescricao());
		PlanoConta planoConta = getPlanoConta(lancamentoRequest.getPlanoConta());		
		lancamento.setPlanoConta(planoConta);
		lancamento.setTipo(planoConta.getTipoMovimento());
		lancamento.setValor(lancamentoRequest.getValor());
		Lancamento response = lancamentoRepository.save(lancamento);
		
		if(planoConta.getTipoMovimento().equals(TipoMovimento.RECEITA)) {
	
			contaService.creditarLancamentoNaConta( contaService.getContaById(lancamentoRequest.getConta()),lancamentoRequest.getValor());
		}else if(planoConta.getTipoMovimento().equals(TipoMovimento.DESPESA)) {
			contaService.debitarLancamentoDaConta(contaService.getContaById(lancamentoRequest.getConta()),lancamentoRequest.getValor());
		}else if(planoConta.getTipoMovimento().equals(TipoMovimento.TRANSFERENCIA)) {
			
			contaService.realizarTransferenciaEntreContas(
					contaService.getContaById(lancamentoRequest.getConta()),
					contaService.getContaByLogin(lancamentoRequest.getContaDestino()),
					lancamentoRequest.getValor());
		}
		
		return response;	
	}
	
	
	
	private PlanoConta getPlanoConta(Integer id) {
		PlanoConta planoConta = new PlanoConta();
		
		if(planoContaRepository.findById(id).isPresent()) {
			planoConta = planoContaRepository.findById(id).get();
		}else {
			throw new ObjectNotFoundException("Plano Conta de id "+id+" nao encontrado");
		}
		
		return planoConta;
		
	}
	
}
