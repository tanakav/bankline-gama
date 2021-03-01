package com.game.bankline.dto;

public class DashboardDto {
	
	private ContaDto contaDebito;
	
	private ContaDto contaCredito;
	
	public DashboardDto() {}

	public DashboardDto(ContaDto contaDebito, ContaDto contaCredito) {
		super();
		this.contaDebito = contaDebito;
		this.contaCredito = contaCredito;
	}

	public ContaDto getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(ContaDto contaDebito) {
		this.contaDebito = contaDebito;
	}

	public ContaDto getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(ContaDto contaCredito) {
		this.contaCredito = contaCredito;
	}
	
}
