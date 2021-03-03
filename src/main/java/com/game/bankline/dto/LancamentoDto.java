package com.game.bankline.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDto {
	
	private Integer conta;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
	
	private String descricao;
	
	private String contaDestino;

	private Integer planoConta;
	
	private Double valor;
	
	public LancamentoDto() {}

	public LancamentoDto(Integer conta, Date data, String descricao, Integer planoConta, Double valor) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}
	
	public LancamentoDto(Integer conta, Date data,String contaDestino, String descricao, Integer planoConta, Double valor) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.planoConta = planoConta;
		this.valor = valor;
	}
	
	

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Integer planoConta) {
		this.planoConta = planoConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
