package com.game.bankline.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.entity.Conta;
import com.game.bankline.exceptions.ObjectNotFoundException;
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
	
	public Conta creditarLancamentoNaConta( Conta conta, Double valorTransferencia) {		
		conta.setSaldo(conta.getSaldo() + valorTransferencia);
		contaRepository.save(conta);
		return conta;
	}
	
	public Conta debitarLancamentoDaConta( Conta conta, Double valorASerDebitadoDaConta) {
		conta.setSaldo(conta.getSaldo() - valorASerDebitadoDaConta);
		contaRepository.save(conta);
		return conta;
	}
	
	public Conta getContaById(Integer id) {
		Conta conta = new Conta();
		try {
			conta = contaRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Conta com id "+id+" existe!");
		}
		return conta;
	}
	
	public Conta getContaByLogin(String login) {
		Conta conta = new Conta();
		try {
			conta = contaRepository.getFirstByNumero(login).get();
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Conta do login "+login+" nao encontrada!");
		}
		
		return conta;
	}

	public void realizarTransferenciaEntreContas(Conta contaOrigem, Conta contaDestino ,Double valor) {
		debitarLancamentoDaConta(contaOrigem, valor);
		creditarLancamentoNaConta(contaDestino, valor);
		
	}

}
