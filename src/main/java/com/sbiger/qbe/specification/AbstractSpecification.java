package com.sbiger.qbe.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by sbiger on 2016-11-25.
 */
public class AbstractSpecification<T> implements Specification<T> {
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return null;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
