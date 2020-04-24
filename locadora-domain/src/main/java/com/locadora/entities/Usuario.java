package com.locadora.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.springframework.format.annotation.DateTimeFormat;

import com.locadora.enumerators.GeneroUsuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "usuario")
@SuppressWarnings("serial")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_id_sequence", allocationSize = 1)
	@Column(name = "id_usuario", nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@NotNull
	@Column(name = "en_sexo", nullable = false)
	@Enumerated(EnumType.STRING)
	private GeneroUsuario sexo;

	@NotNull
	@Column(name = "dt_data_nascimento", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dataNascimento;

	@NotNull
	@Column(name = "nm_cpf", nullable = false)
	private Long cpf;

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Locacao> locacoes = new HashSet<>();

}
