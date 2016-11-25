package com.sbiger.qbe.specification;

import com.sbiger.qbe.ExampleCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by sbiger on 2016-11-25.
 */
public class EqualSpecification<T> extends AbstractSpecification implements Specification<T>{
    private final String property;

    private final Object value;

    private final ExampleCriteria.BooleanOperator type;

    public EqualSpecification(ExampleCriteria.BooleanOperator type, String property, Object value) {
        this.type = type;
        this.property = property;
        this.value = value;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, Object value, String field) {
        return null == value ? cb.isNull(root.get(field)) : cb.equal(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return  getPredicate(root, cb, value, property);
    }
}
