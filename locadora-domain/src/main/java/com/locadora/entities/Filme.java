package com.locadora.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.locadora.enumerators.GeneroFilme;
import com.locadora.enumerators.TipoFilme;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "tb_filme")
@SuppressWarnings("serial")
public class Filme implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme_id_generator")
	@SequenceGenerator(name = "filme_id_generator", sequenceName = "filme_id_seq", allocationSize = 1)
	@Column(name = "id_filme", nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name = "titulo", nullable = false)
	private String titulo;

	@NotNull
	@Column(name = "genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroFilme genero;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name = "diretor", nullable = false)
	private String diretor;

	@Min(1970)
	@Column(name = "anoLancamento", columnDefinition = "smallint", nullable = false)
	private int anoLancamento;

	@Min(1)
	@Column(name = "quantidade", columnDefinition = "smallint", nullable = false)
	private int quantidade;

	@NotNull
	@Column(name = "en_tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoFilme tipo;

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filme")
	private Set<Locacao> locacoes = new HashSet<>();
}
