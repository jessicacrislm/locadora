package com.locadora.enumerators;

public enum TipoDuracao {
    UM_DIA("1 Dia", 1),
    TRES_DIAS("3 Dias", 3),
    CINCO_DIAS("5 Dias", 5);
	
	private final String descricao;
    private final long dias;
    
	private TipoDuracao(String descricao, long dias) {
		this.descricao = descricao;
		this.dias = dias;
	}

	public String getDescricao() {
		return descricao;
	}

	public long getDias() {
		return dias;
	}
    
}
