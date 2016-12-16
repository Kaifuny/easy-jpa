package com.sbiger.qbe.criteria.is;

import com.sbiger.qbe.ExampleCriteria;
import com.sbiger.qbe.criteria.AbstractSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-14.
 */
public class IsTrueSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    private final ExampleCriteria.BooleanOperator type;

    public IsTrueSpecification(ExampleCriteria.BooleanOperator type, String property) {
        this.property = property;
        this.type = type;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.isTrue(root.get(property));
    }
}
