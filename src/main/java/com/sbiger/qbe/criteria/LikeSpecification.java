package com.sbiger.qbe.criteria;

import com.sbiger.qbe.interfaces.AbstractSpecification;
import com.sbiger.qbe.interfaces.ExampleCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-06.
 */
public class LikeSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    private final String value;

    private final ExampleCriteria.BooleanOperator type;

    public LikeSpecification(ExampleCriteria.BooleanOperator type, String property, String value) {
        this.type = type;
        this.property = property;
        this.value = value;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, String field, String value) {
        return null == value ? cb.isNull(root.get(field)) : cb.like(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery query, CriteriaBuilder cb) {
        return getPredicate(root, cb, property, value);
    }
}
