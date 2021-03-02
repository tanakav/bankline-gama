package com.game.bankline.entity.enums;

public enum TipoPerfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	USUARIO(2,"ROLE_USUARIO");
	
	private Integer id;
	private String descricao;
	
	private TipoPerfil(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPerfil toEnum(Integer id){
        if(id == null){
            return null;
        }

        for(TipoPerfil tipo : TipoPerfil.values()){
            if(id.equals(tipo.getId())){
                return tipo;
            }
        }

        throw new IllegalArgumentException("ID inválido: "+ id);
    }   

}
