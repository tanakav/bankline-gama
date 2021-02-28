package com.game.bankline.dto;

public class UsuarioDto {
	
	private String nome;
	
	private String login;	
	
	public UsuarioDto() {}

	public UsuarioDto(String nome, String login) {
		super();
		this.nome = nome;
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}	
	

}
