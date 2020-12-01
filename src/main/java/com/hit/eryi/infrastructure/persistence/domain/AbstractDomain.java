package com.hit.eryi.infrastructure.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.io.Serializable;


public class AbstractDomain<PK extends Serializable> implements BaseDomain<PK> {

    private static final long serialVersionUID = -8938494590149271148L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private PK id;

    @Override
    public PK getId() {
        return id;
    }

    @Override
    public void setId(PK id) {
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractDomain> T id(PK id) {
        this.id = id;
        return (T) this;
    }
}
