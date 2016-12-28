package com.sbiger.qbe.criteria;

import com.sbiger.qbe.interfaces.AbstractSpecification;
import com.sbiger.qbe.interfaces.ExampleCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-13.
 */
public class LeSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    private final Number number;

    private final ExampleCriteria.BooleanOperator type;

    public LeSpecification(ExampleCriteria.BooleanOperator type, String property, Number number) {
        this.property = property;
        this.number = number;
        this.type = type;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, String field, Number value) {
        return null == value ? cb.isNull(root.get(field)) : cb.le(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return getPredicate(root, cb, property, number);
    }
}
