package com.hit.eryi.infrastructure.persistence.domain;

import java.io.Serializable;


public interface BaseDomain<PK extends Serializable> extends Serializable {

    PK getId();

    void setId(PK id);
}
