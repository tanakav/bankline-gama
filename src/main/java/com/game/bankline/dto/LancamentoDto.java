package com.game.bankline.dto;

import java.sql.Date;

public class LancamentoDto {
	
	private Integer conta;
	
	private Date data;
	
	private String descricao;

	private Integer tipoPlanoConta;
	
	private Double valor;
	
	public LancamentoDto() {}

	public LancamentoDto(Integer conta, Date data, String descricao, Integer tipoPlanoConta, Double valor) {
		super();
		this.conta = conta;
		this.data = data;
		this.descricao = descricao;
		this.tipoPlanoConta = tipoPlanoConta;
		this.valor = valor;
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

	public Integer getTipoPlanoConta() {
		return tipoPlanoConta;
	}

	public void setTipoPlanoConta(Integer tipo) {
		this.tipoPlanoConta = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
