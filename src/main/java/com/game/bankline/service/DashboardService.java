package com.game.bankline.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bankline.dto.ContaDto;
import com.game.bankline.dto.DashboardDto;
import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Lancamento;
import com.game.bankline.entity.enums.TipoContaEnum;
import com.game.bankline.exceptions.ObjectNotFoundException;
import com.game.bankline.repository.ContaRepository;
import com.game.bankline.repository.LancamentoRepository;

@Service
public class DashboardService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired ContaRepository contaRepository;
	
	public DashboardDto getLancamentosDaConta(Integer numeroDaConta, Date dataInicial, Date dataFinal) {
		DashboardDto dashboardDto = new DashboardDto();
		
		if(contaRepository.findById(numeroDaConta).isPresent()) {
			ContaDto contaDebito = getLancamentoDaConta(numeroDaConta,TipoContaEnum.DEBITO.getId());
			
			
			
			
		}else {
			throw new ObjectNotFoundException("Conta de id "+numeroDaConta+" nao encontrada");
		}
		
		return dashboardDto;
	}
	
	public ContaDto getLancamentoDaConta(Integer numeroDaConta,Integer tipoDeConta) {
		ContaDto returnedContaDto = new ContaDto();
		Conta conta = contaRepository.findById(numeroDaConta).get();
		List<Lancamento> lancamentos = lancamentoRepository.findAllByConta(numeroDaConta);
		
		returnedContaDto.setNumero(conta.getId());
		returnedContaDto.setTipo(conta.getTipo().getDescricao());
		
		return returnedContaDto;		
	}

}
