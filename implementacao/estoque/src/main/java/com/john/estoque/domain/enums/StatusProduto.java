package com.john.estoque.domain.enums;

public enum StatusProduto {

	ATIVO(1, "Ativo"),
	CANCELADDO(2, "Cancelado"),
	PROCESSADO(3, "Processado");
	
	private int cod;
	private String descricao;
	
	private StatusProduto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusProduto toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for(StatusProduto x : StatusProduto.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("id inválido: " + cod);
	}
	
}
