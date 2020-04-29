package com.locadora.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.locadora.enumerators.StatusLocacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoDTO extends BaseDTO {

	private Long id;
	private Long idFilme;
	private Long idUsuario;
	private Date dataLocacao;
	private Date dataDevolucao;
	private StatusLocacao status;
	private List<LocacaoDTO> locacoes = new ArrayList<>();

}
