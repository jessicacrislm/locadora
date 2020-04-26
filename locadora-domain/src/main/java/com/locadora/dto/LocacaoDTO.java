package com.locadora.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.locadora.enumerators.StatusLocacao;

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
	private StatusLocacao status;
	private List<LocacaoDTO> locacoes = new ArrayList<>();

}
