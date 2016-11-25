package com.sbiger.qbe;

import com.sbiger.qbe.specification.AbstractSpecification;
import com.sbiger.qbe.specification.EqualSpecification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbiger on 2016-11-24.
 */
public class Example<T> implements ExampleQuery, ExampleCriteria {
    private List<JoinClass> joinClassList;
    private List<AbstractSpecification> orClassList;
    private List<AbstractSpecification> andClassList;

    public Example(){
        this.joinClassList = new ArrayList<JoinClass>();
        this.orClassList = new ArrayList<AbstractSpecification>();
        this.andClassList = new ArrayList<AbstractSpecification>();
    }

    public static ExampleQuery create(){
        return new Example();
    }

    @Override
    public Example<T> join(Class c) {
        return innerJoin(c);
    }

    @Override
    public Example<T> innerJoin(Class c) {
        return join(c,JoinType.INNER);
    }

    @Override
    public Example<T> leftJoin(Class c) {
        return join(c, JoinType.LEFT);
    }

    @Override
    public Example<T> rightJoin(Class c) {
        return join(c, JoinType.RIGHT);
    }

    @Override
    public Example<T> join(Class c, JoinType type) {
        joinClassList.add(new JoinClass(c, type));
        return this;
    }

    @Override
    public ExampleCriteria<T> or() {
        return this;
    }

    @Override
    public ExampleCriteria equal(BooleanOperator type, Boolean condition, String property, Object... values) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new EqualSpecification(type, property, values));
            } else {
                andClassList.add(new EqualSpecification(type, property, values));
            }
        }
        return this;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }

    class JoinClass{
        JoinType type;
        Class c;
        public JoinClass(Class c, JoinType type) {
            this.type = type;
            this.c = c;
        }
        public JoinType getType() {return type;}
        public Class getC() {return c;}
    }
}
