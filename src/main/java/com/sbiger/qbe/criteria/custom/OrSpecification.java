package com.sbiger.qbe.criteria.custom;

import com.sbiger.qbe.interfaces.AbstractSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by sbiger on 2016-12-15.
 */
public class OrSpecification<T> extends AbstractSpecification<T> {
    private Specification specification;

    public OrSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return specification.toPredicate((Root) root, query, cb);
    }
}
