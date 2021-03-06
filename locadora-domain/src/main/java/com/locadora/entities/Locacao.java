package com.locadora.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.enumerators.StatusLocacao;
import com.locadora.utils.Nomenclatura;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Nomenclatura.TABELA + "locacao")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Locacao implements Persistable<Long> {

	@Id
	@Column(name = Nomenclatura.CHAVE_PRIMARIA + "locacao", nullable = false)
	@SequenceGenerator(name = "locacao_id" + Nomenclatura.SEQUENCIA, sequenceName = "locacao_id" + Nomenclatura.SEQUENCIA, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locacao_id" + Nomenclatura.SEQUENCIA)
	private Long id;
	
	@Column(name = Nomenclatura.CHAVE_PRIMARIA + "locacao_principal", insertable = false, updatable = false)
	private Long locacaoPrincipal;

	@NotNull
	@JoinColumn(name = Nomenclatura.CHAVE_PRIMARIA + "filme", nullable = false, 
				foreignKey = @ForeignKey(name = Nomenclatura.CHAVE_SECUNDARIA + "locacao_filme"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Filme filme;

	@NotNull
	@JoinColumn(name = Nomenclatura.CHAVE_PRIMARIA + "usuario", nullable = false, 
				foreignKey = @ForeignKey(name = Nomenclatura.CHAVE_SECUNDARIA + "locacao_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@NotNull
	@Column(name = Nomenclatura.DATA_HORA + "data_locacao", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataLocacao;

	@Column(name = Nomenclatura.DATA_HORA + "data_devolucao")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDevolucao;

	@NotNull
	@Column(name = Nomenclatura.ENUM +"status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusLocacao status;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = Nomenclatura.CHAVE_PRIMARIA + "locacao_principal", columnDefinition = Nomenclatura.CHAVE_PRIMARIA + "locacao", 
				foreignKey = @ForeignKey(name = Nomenclatura.CHAVE_SECUNDARIA + "locacao_id_locacao"))
	private Set<Locacao> locacoes = new HashSet<>();

}
