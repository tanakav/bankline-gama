package com.game.bankline.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer conta;
	
	private Date data;
	
	private String descricao;	
	
	private PlanoConta planoConta;
	
	private String tipo;
	
	private Double valor;

}
