package com.sbiger.qbe.specification;

import com.sbiger.qbe.ExampleCriteria;

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

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.le(root.get(property), number);
    }
}
