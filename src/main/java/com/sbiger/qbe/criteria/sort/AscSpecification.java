package com.sbiger.qbe.criteria.sort;

import com.sbiger.qbe.criteria.AbstractSpecification;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbiger on 2016-12-16.
 */
public class AscSpecification<T> extends AbstractSpecification<T> {

    private final String[] property;

    public AscSpecification(String... property) {
        this.property = property;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Order> list = new ArrayList<Order>();
        for (int i = 0; i < property.length; i++) {
            if (property[i] != null) {
                Order order = cb.asc(root.get(property[i].trim()));
                list.add(order);
            }
        }
        query.orderBy(list.stream().toArray(Order[]::new));
        return cb.conjunction();
    }
}
