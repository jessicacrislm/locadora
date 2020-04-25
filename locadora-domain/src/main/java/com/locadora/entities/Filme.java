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
import com.locadora.multitenancy.AbstractTenant;
import com.locadora.utils.Nomenclatura;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = Nomenclatura.TABELA + "filme")
@SuppressWarnings("serial")
public class Filme extends AbstractTenant<Long> implements Serializable {

	@Id
	@Column(name = Nomenclatura.CHAVE_PRIMARIA + "filme", nullable = false)
	@SequenceGenerator(name = "filme_id" + Nomenclatura.SEQUENCIA, sequenceName = "filme_id" + Nomenclatura.SEQUENCIA, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme_id" + Nomenclatura.SEQUENCIA)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name = Nomenclatura.DESCRICAO + "titulo", nullable = false)
	private String titulo;

	@NotNull
	@Column(name = Nomenclatura.ENUM + "genero", nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroFilme genero;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(name = Nomenclatura.DESCRICAO + "diretor", nullable = false)
	private String diretor;

	@Min(1970)
	@Column(name = Nomenclatura.DATA_HORA + "anoLancamento", columnDefinition = "smallint", nullable = false)
	private int anoLancamento;

	@Min(1)
	@Column(name = Nomenclatura.NUMERICO + "quantidade", columnDefinition = "smallint", nullable = false)
	private int quantidade;

	@NotNull
	@Column(name = Nomenclatura.ENUM + "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoFilme tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filme")
	private Set<Locacao> locacoes = new HashSet<>();
}
