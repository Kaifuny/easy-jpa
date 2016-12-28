package com.sbiger.qbe.group;

import com.sbiger.qbe.interfaces.AbstractSpecification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbiger on 2016-12-19.
 */
public class GroupBySpecification<T> extends AbstractSpecification<T> {
    private final String[] property;

    public GroupBySpecification(String... property) {
        this.property = property;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Expression<?>> list = new ArrayList<Expression<?>>();
        for (int i = 0; i < property.length; i++) {
            if (property[i] != null) {
                list.add(root.get(property[i].trim()));
            }
        }
        query.groupBy(list);
        return cb.conjunction();
    }
}
