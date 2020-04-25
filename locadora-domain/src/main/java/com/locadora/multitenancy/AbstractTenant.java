package com.locadora.multitenancy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import com.locadora.entities.AuditableEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FilterDef(name = AbstractTenant.TENANT_FILTER, parameters = { @ParamDef(name = "tenant", type = "string") })
@Filter(name = AbstractTenant.TENANT_FILTER, condition = AbstractTenant.TENANT_PARAM + " = :"
		+ AbstractTenant.TENANT_PARAM)
@EntityListeners(TenantListener.class)
public abstract class AbstractTenant<PK extends Serializable> extends AuditableEntity<PK> {
	
	public static final String TENANT_PARAM = "tenant";
	public static final String TENANT_FILTER 	= "tenantFilter";
	
	@NotBlank
	@Column(name = "tenant", length = 255, nullable = false)
    private String tenant;

}
