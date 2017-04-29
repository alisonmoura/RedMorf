package br.com.redmorf.model;

public enum Status {
	
	CONCLUIDO("Conclúdo"),
	EM_CANCELAMENTO("Em cancelamento"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private Status(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return this.descricao;
	}

}
