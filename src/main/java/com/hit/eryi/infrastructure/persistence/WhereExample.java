package com.hit.eryi.infrastructure.persistence;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author sunzhichao
 * @since 18/4/17
 */
public class WhereExample extends Example {

    public WhereExample(Class<?> entityClass) {
        super(entityClass);
    }

    public WhereExample andEqualTo(String property, Object value) {
        List<Criteria> criteriaList = super.oredCriteria;
        if (criteriaList == null || criteriaList.size() == 0) {
            super.createCriteria();
        }
        Criteria criteria = super.oredCriteria.get(0);
        criteria.andEqualTo(property, value);
        return this;
    }

}
