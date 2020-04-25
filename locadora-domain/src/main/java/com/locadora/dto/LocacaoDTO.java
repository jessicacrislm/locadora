package com.locadora.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoDTO extends BaseDTO {

	private Long id;
	private FilmeDTO filme;
	private UsuarioDTO usuario;
	private LocalDateTime dataLocacao;
	private LocalDateTime dataDevolucao;
	private String status;

}
