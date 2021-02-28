package com.game.bankline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_plano_conta")
public class PlanoConta {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String descricao;
	
	private String login;
	
	private boolean padrao;
	
	private Integer tipoMovimento;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isPadrao() {
		return padrao;
	}

	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}

	public TipoPlanoContaEnum getTipoMovimento() {
		return TipoPlanoContaEnum.toEnum(tipoMovimento);
	}

	public void setTipoMovimento(TipoPlanoContaEnum tipoMovimento) {
		this.tipoMovimento = tipoMovimento.getId();
	}
	
	

}
