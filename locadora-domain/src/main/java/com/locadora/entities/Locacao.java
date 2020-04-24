package com.locadora.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.locadora.enumerators.StatusLocacao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "tb_locacao")
@SuppressWarnings("serial")
public class Locacao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locacao_id_generator")
	@SequenceGenerator(name = "locacao_id_generator", sequenceName = "locacao_id_seq", allocationSize = 1)
	@Column(name = "id_locacao", nullable = false)
	private Long id;

	@NotNull
	@JoinColumn(name = "id_filme", nullable = false, foreignKey = @ForeignKey(name = "fk_locacao_filme"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Filme filme;

	@NotNull
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_locacao_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@NotNull
	@Column(name = "dt_data_locacao", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataLocacao;

	@NotNull
	@Column(name = "dt_data_devolucao", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataDevolucao;

	@NotNull
	@Column(name = "en_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusLocacao status;

}
