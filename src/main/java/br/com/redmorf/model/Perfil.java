package br.com.redmorf.model;

public enum Perfil {
	
	ADMIN("Administrador"),
	ATENDENTE("Atendente");
	
	private String descricao;
	
	private Perfil(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}

}
