package com.sbiger.qbe.sort;

import com.sbiger.qbe.AbstractSpecification;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbiger on 2016-12-16.
 */
public class DescSpecification<T> extends AbstractSpecification<T> {

    private final String[] property;

    public DescSpecification(String... property) {
        this.property = property;
    }

    @Override
    public Predicate toPredicate(From root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Order> list = new ArrayList<Order>();
        for (int i = 0; i < property.length; i++) {
            if (property[i] != null) {
                Order order = cb.desc(root.get(property[i].trim()));
                list.add(order);
            }
        }
        query.orderBy(list.stream().toArray(Order[]::new));
        return cb.conjunction();
    }
}
