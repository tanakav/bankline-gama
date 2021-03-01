package com.game.bankline.entity.enums;

public enum TipoContaEnum {
	DEBITO(1,"Debito"),
	CREDITO(2,"Credito");
	
	private Integer id;
	private String descricao;
	
	private TipoContaEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoContaEnum toEnum(Integer id){
        if(id == null){
            return null;
        }

        for(TipoContaEnum tipo : TipoContaEnum.values()){
            if(id.equals(tipo.getId())){
                return tipo;
            }
        }

        throw new IllegalArgumentException("ID inválido: "+ id);
    }   
}
