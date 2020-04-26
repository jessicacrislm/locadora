package com.locadora.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.utils.Nomenclatura;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<PK extends Serializable> implements Persistable<PK> {

	@CreatedBy
	@JsonIgnore
	@Column(name =  Nomenclatura.AUDITORIA + "criador", length = 100)
	protected String criador;
	
	@JsonIgnore
	@LastModifiedBy
	@Column(name =  Nomenclatura.AUDITORIA + "modificador", length = 100)
	private String modificador;

	@JsonIgnore
	@CreatedDate
	@Column(name =  Nomenclatura.AUDITORIA + "data_criacao")
	private LocalDateTime dataCriacao;
	
	@JsonIgnore
	@LastModifiedDate
	@Column(name =  Nomenclatura.AUDITORIA + "data_modificacao")
	private LocalDateTime dataModificacao;
	
	@Version
	@JsonIgnore
	@Column(name = Nomenclatura.VALOR + "versao")
	private Long versao;
	
}
