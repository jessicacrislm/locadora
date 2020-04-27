package com.locadora.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.enumerators.GeneroUsuario;
import com.locadora.utils.Nomenclatura;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Nomenclatura.TABELA + "usuario")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario implements Persistable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario" + Nomenclatura.SEQUENCIA)
	@SequenceGenerator(name = "usuario" + Nomenclatura.SEQUENCIA, sequenceName = "usuario_id" + Nomenclatura.SEQUENCIA, allocationSize = 1)
	@Column(name = Nomenclatura.CHAVE_PRIMARIA +"usuario", nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = Nomenclatura.DESCRICAO +"nome", nullable = false)
	private String nome;

	@NotNull
	@Column(name = Nomenclatura.ENUM +"sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroUsuario sexo;

	@NotNull
	@Column(name = Nomenclatura.DATA_HORA +"data_nascimento", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@NotBlank
	@Size(min = 11, max = 18)
	@Column(name = Nomenclatura.DESCRICAO + "cpf", nullable = false)
	private String cpf;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Locacao> locacoes = new HashSet<>();

}
