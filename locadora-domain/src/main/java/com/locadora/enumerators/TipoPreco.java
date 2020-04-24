package com.locadora.enumerators;

import java.math.BigDecimal;

public enum TipoPreco {
	BASICO("Básico", new BigDecimal(4)), 
	ESPECIAL("Especial", new BigDecimal(4));

	private final String descricao;
	private final BigDecimal preco;

	private TipoPreco(String descricao, BigDecimal preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

}
