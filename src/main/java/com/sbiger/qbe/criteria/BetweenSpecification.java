package com.sbiger.qbe.criteria;

import com.sbiger.qbe.interfaces.AbstractSpecification;
import com.sbiger.qbe.interfaces.ExampleCriteria;
import org.springframework.data.domain.Range;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by sbiger on 2016-12-12.
 */
public class BetweenSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    private final Range range;

    private final ExampleCriteria.BooleanOperator type;

    public BetweenSpecification(ExampleCriteria.BooleanOperator type, String property, Range range) {
        this.type = type;
        this.property = property;
        this.range = range;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.between(root.get(property), range.getLowerBound(), range.getUpperBound());
    }
}
