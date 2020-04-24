package com.locadora.enumerators;

import java.math.BigDecimal;

public enum TipoFilme {

	LEGADO("Legado", TipoPreco.BASICO, TipoDuracao.CINCO_DIAS),
	NORMAL("Normal", TipoPreco.BASICO, TipoDuracao.TRES_DIAS),
	LANCAMENTO("Lançamento", TipoPreco.ESPECIAL, TipoDuracao.UM_DIA);

	private final String descricao;
	private final TipoPreco tipoPreco;
	private final TipoDuracao tipoDuracao;

	private TipoFilme(String descricao, TipoPreco preco, TipoDuracao dias) {
		this.descricao = descricao;
		this.tipoPreco = preco;
		this.tipoDuracao = dias;
	}

	public BigDecimal calculaPreco() {
		return this.getTipoPreco().getPreco().multiply(new BigDecimal(this.getTipoDuracao().getDias()));
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public TipoDuracao getTipoDuracao() {
		return tipoDuracao;
	}

}
