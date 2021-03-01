package com.game.bankline.entity.enums;

public enum TipoConta {
	DEBITO(1,"Debito"),
	CREDITO(2,"Credito");
	
	private Integer id;
	private String descricao;
	
	private TipoConta(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoConta toEnum(Integer id){
        if(id == null){
            return null;
        }

        for(TipoConta tipo : TipoConta.values()){
            if(id.equals(tipo.getId())){
                return tipo;
            }
        }

        throw new IllegalArgumentException("ID inválido: "+ id);
    }   
}
