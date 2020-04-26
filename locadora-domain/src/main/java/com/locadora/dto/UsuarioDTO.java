package com.locadora.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import com.locadora.enumerators.GeneroUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends BaseDTO {

	private Long id;
	private String nome;
	private GeneroUsuario sexo;
	private LocalDateTime dataNascimento;
	@CPF
	private String cpf;

}
