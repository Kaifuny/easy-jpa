package com.sbiger.qbe.criteria.custom;

import com.sbiger.qbe.AbstractSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by sbiger on 2016-12-15.
 */
public class AndSpecification<T> extends AbstractSpecification<T> {
    private Specification specification;

    public AndSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return specification.toPredicate((Root) root, query, cb);
    }
}
