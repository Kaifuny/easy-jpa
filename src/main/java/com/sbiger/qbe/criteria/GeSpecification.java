package com.sbiger.qbe.criteria;

import com.sbiger.qbe.ExampleCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-13.
 */
public class GeSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    private final Number number;

    private final ExampleCriteria.BooleanOperator type;

    public GeSpecification(ExampleCriteria.BooleanOperator type, String property, Number number) {
        this.property = property;
        this.number = number;
        this.type = type;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, String field, Number value) {
        return null == value ? cb.isNull(root.get(field)) : cb.ge(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return getPredicate(root, cb, property, number);
    }
}
