package com.game.bankline.dto;

import java.util.Date;

import com.game.bankline.entity.Conta;
import com.game.bankline.entity.Usuario;

public class SessaoDto {
	
	private Usuario usuario;
	
	private String token;
	
	private Date dataInicio;
	
	private Date dataFim;	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
