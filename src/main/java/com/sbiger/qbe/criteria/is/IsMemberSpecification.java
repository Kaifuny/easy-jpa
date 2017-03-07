package com.sbiger.qbe.criteria.is;

import com.sbiger.qbe.interfaces.AbstractSpecification;
import com.sbiger.qbe.interfaces.ExampleCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;

/**
 * Created by zhangkf02 on 2017/3/7.
 */
public class IsMemberSpecification<T>  extends AbstractSpecification<T> {
    private final String property;
    private final Object object;

    private final ExampleCriteria.BooleanOperator type;

    public IsMemberSpecification(ExampleCriteria.BooleanOperator type, String property, Object object) {
        this.property = property;
        this.type = type;
        this.object = object;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.isMember(object, root.get(property));
    }
}
