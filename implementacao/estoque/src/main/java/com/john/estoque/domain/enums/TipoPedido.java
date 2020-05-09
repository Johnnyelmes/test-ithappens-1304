package com.john.estoque.domain.enums;

public enum TipoPedido {
	ENTRADA(1, "Entrada"),
	SAIDA(2, "Saida");

	private int cod;
	private String descricao;
	
	private TipoPedido(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPedido toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for(TipoPedido x : TipoPedido.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("id inválido: " + cod);
	}
	
	
}
