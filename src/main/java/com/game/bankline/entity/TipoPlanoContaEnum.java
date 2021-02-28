package com.game.bankline.entity;

public enum TipoPlanoContaEnum {
	RECEITA(1,"Receita"),
	DESPESA(2,"Despesa"),
	TRANSFERENCIA(3,"Transferencia");
	
	private Integer id;
	private String descricao;
	
	private TipoPlanoContaEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}	
	
	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPlanoContaEnum toEnum(Integer id){
        if(id == null){
            return null;
        }

        for(TipoPlanoContaEnum tipo : TipoPlanoContaEnum.values()){
            if(id.equals(tipo.getId())){
                return tipo;
            }
        }

        throw new IllegalArgumentException("ID inválido: "+ id);
    }   
}
