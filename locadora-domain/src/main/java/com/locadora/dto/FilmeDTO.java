package com.locadora.dto;

import com.locadora.enumerators.GeneroFilme;
import com.locadora.enumerators.TipoFilme;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeDTO extends BaseDTO {
	
	private Long id;
	private String titulo;
	private GeneroFilme genero;
	private String diretor;
	private int anoLancamento;
	private int quantidade;
	private TipoFilme tipo;

}
