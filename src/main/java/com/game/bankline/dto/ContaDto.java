package com.game.bankline.dto;

import java.util.List;

import com.game.bankline.entity.Lancamento;

public class ContaDto {
	
	private Integer numero;
	private String tipo;
	private Double saldo;
	private List<Lancamento> lancamentos;
	
	public ContaDto() {}
	
	public ContaDto(Integer numero, String tipo, Double saldo, List<Lancamento> lancamentos) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.lancamentos = lancamentos;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	

}
