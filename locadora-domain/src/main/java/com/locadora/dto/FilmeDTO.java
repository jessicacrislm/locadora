package com.locadora.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeDTO extends BaseDTO {
	
	private Long id;
	private String titulo;
	private String genero;
	private String diretor;
	private int anoLancamento;
	private int quantidade;
	private String tipo;
	private List<LocacaoDTO> locacoes = new ArrayList<>();

}
