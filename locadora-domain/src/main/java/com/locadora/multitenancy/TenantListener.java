package com.locadora.multitenancy;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class TenantListener {

	@PrePersist
    @PreUpdate
    @PreRemove
    @SuppressWarnings("rawtypes")
    public void setTenant(Object object) {
        if(object instanceof AbstractTenant){
            ((AbstractTenant) object).setTenant(TenantContext.get());
        }
    }

}
