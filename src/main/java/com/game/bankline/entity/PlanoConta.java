package com.game.bankline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_conta")
public class PlanoConta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String descricao;
	
	private String login;
	
	private boolean padrao;
	
	private String tipoMovimento;

}
