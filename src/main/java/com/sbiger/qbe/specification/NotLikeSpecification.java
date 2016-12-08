package com.sbiger.qbe.specification;

import com.sbiger.qbe.ExampleCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-06.
 */
public class NotLikeSpecification<T> extends AbstractSpecification<T>{
    private final String property;

    private final String value;

    private final ExampleCriteria.BooleanOperator type;

    public NotLikeSpecification(ExampleCriteria.BooleanOperator type, String property, String value) {
        this.type = type;
        this.property = property;
        this.value = value;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, String value, String field) {
        return null == value ? cb.isNull(root.get(field)) : cb.notLike(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery query, CriteriaBuilder cb) {
        return getPredicate(root, cb, value, property);
    }
}
