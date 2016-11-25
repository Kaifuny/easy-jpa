package com.sbiger.qbe.specification;

import com.sbiger.qbe.ExampleCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Arrays;

/**
 * Created by sbiger on 2016-11-25.
 */
public class EqualSpecification<T> extends AbstractSpecification implements Specification<T>{
    private final String property;

    private final Object[] values;

    private final ExampleCriteria.BooleanOperator type;

    public EqualSpecification(ExampleCriteria.BooleanOperator type, String property, Object... values) {
        this.type = type;
        this.property = property;
        this.values = values;
    }

    private Predicate getPredicate(From root, CriteriaBuilder cb, Object value, String field) {
        return null == value ? cb.isNull(root.get(field)) : cb.equal(root.get(field), value);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (null == values)
            return cb.isNull(root.get(property));

        if (1 == values.length)
            return getPredicate(root, cb, values[0], property);

        if (type.equals(ExampleCriteria.BooleanOperator.OR)){

        }else{

        }
        return null;
    }
}
