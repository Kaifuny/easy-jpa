package com.sbiger.qbe;

import com.sbiger.qbe.criteria.*;
import com.sbiger.qbe.criteria.custom.AndSpecification;
import com.sbiger.qbe.criteria.custom.OrSpecification;
import com.sbiger.qbe.criteria.is.IsFalseSpecification;
import com.sbiger.qbe.criteria.is.IsNotNullSpecification;
import com.sbiger.qbe.criteria.is.IsNullSpecification;
import com.sbiger.qbe.criteria.is.IsTrueSpecification;
import com.sbiger.qbe.criteria.sort.AscSpecification;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;

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
    private List<AbstractSpecification> orderClassList;

    public Example(){
        this.joinClassList = new ArrayList<JoinClass>();
        this.orClassList = new ArrayList<AbstractSpecification>();
        this.andClassList = new ArrayList<AbstractSpecification>();
        this.orderClassList = new ArrayList<AbstractSpecification>();
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
    public Example asc(String... properties) {
        for (int i = 0; i < properties.length; i++) {
            this.orderClassList.add(new AscSpecification(properties));
        }
        return this;
    }

    @Override
    public Example desc(String... properties) {
        this.orderClassList.add(new AscSpecification(properties));
        return this;
    }

    @Override
    public ExampleCriteria<T> or() {
        return this;
    }

    @Override
    public ExampleCriteria and(Specification specification) {
        if (specification instanceof Specification)
            andClassList.add(new AndSpecification(specification));
        return this;
    }

    @Override
    public ExampleCriteria or(Specification specification) {
        if (specification instanceof Specification)
            orClassList.add(new OrSpecification(specification));
        return this;
    }

    @Override
    public ExampleCriteria isTrue(BooleanOperator type, String property) {
        if (type.equals(BooleanOperator.OR)) {
            orClassList.add(new IsTrueSpecification(type, property));
        } else {
            andClassList.add(new IsTrueSpecification(type, property));
        }
        return this;
    }

    @Override
    public ExampleCriteria andIsTrue(String property) {
        return isTrue(BooleanOperator.AND, property);
    }

    @Override
    public ExampleCriteria orIsTrue(String property) {
        return isTrue(BooleanOperator.OR, property);
    }

    @Override
    public ExampleCriteria isFalse(BooleanOperator type, String property) {
        if (type.equals(BooleanOperator.OR)) {
            orClassList.add(new IsFalseSpecification(type, property));
        } else {
            andClassList.add(new IsFalseSpecification(type, property));
        }
        return this;
    }

    @Override
    public ExampleCriteria andIsFalse(String property) {
        return isFalse(BooleanOperator.AND, property);
    }

    @Override
    public ExampleCriteria orIsFalse(String property) {
        return isFalse(BooleanOperator.OR, property);
    }

    @Override
    public ExampleCriteria isNull(BooleanOperator type, String property) {
        if (type.equals(BooleanOperator.OR)) {
            orClassList.add(new IsNullSpecification(type, property));
        } else {
            andClassList.add(new IsNullSpecification(type, property));
        }
        return this;
    }

    @Override
    public ExampleCriteria andIsNull(String property) {
        return isNull(BooleanOperator.AND, property);
    }

    @Override
    public ExampleCriteria orIsNull(String property) {
        return isNull(BooleanOperator.OR, property);
    }

    @Override
    public ExampleCriteria isNotNull(BooleanOperator type, String property) {
        if (type.equals(BooleanOperator.OR)) {
            orClassList.add(new IsNotNullSpecification(type, property));
        } else {
            andClassList.add(new IsNotNullSpecification(type, property));
        }
        return this;
    }

    @Override
    public ExampleCriteria andIsNotNull(String property) {
        return isNotNull(BooleanOperator.AND, property);
    }

    @Override
    public ExampleCriteria orIsNotNull(String property) {
        return isNotNull(BooleanOperator.OR, property);
    }

    @Override
    public ExampleCriteria isEmpty(BooleanOperator type, String property) {
        return null;
    }

    @Override
    public ExampleCriteria andIsEmpty(String property) {
        return null;
    }

    @Override
    public ExampleCriteria orIsEmpty(String property) {
        return null;
    }

    @Override
    public ExampleCriteria isNotEmpty(BooleanOperator type, String property) {
        return null;
    }

    @Override
    public ExampleCriteria andIsNotEmpty(String property) {
        return null;
    }

    @Override
    public ExampleCriteria orIsNotEmpty(String property) {
        return null;
    }

    @Override
    public ExampleCriteria in(BooleanOperator type, Boolean condition, String property, Object[] values) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new InSpecification(type, property, values));
            } else {
                andClassList.add(new InSpecification(type, property, values));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andIn(Boolean condition, String property, Object[] values) {
        return in(BooleanOperator.AND, condition, property, values);
    }

    @Override
    public ExampleCriteria orIn(Boolean condition, String property, Object[] values) {
        return in(BooleanOperator.OR, condition, property, values);
    }

    @Override
    public ExampleCriteria andIn(String property, Object[] values) {
        return andIn(true, property, values);
    }

    @Override
    public ExampleCriteria orIn(String property, Object[] values) {
        return orIn(true, property, values);
    }

    @Override
    public ExampleCriteria notIn(BooleanOperator type, Boolean condition, String property, Object[] values) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new NotInSpecification(type, property, values));
            } else {
                andClassList.add(new NotInSpecification(type, property, values));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andNotIn(Boolean condition, String property, Object[] values) {
        return notIn(BooleanOperator.AND, condition, property, values);
    }

    @Override
    public ExampleCriteria orNotIn(Boolean condition, String property, Object[] values) {
        return notIn(BooleanOperator.OR, condition, property, values);
    }

    @Override
    public ExampleCriteria andNotIn(String property, Object[] values) {
        return andNotIn(true, property, values);
    }

    @Override
    public ExampleCriteria orNotIn(String property, Object[] values) {
        return orNotIn(true, property, values);
    }

    @Override
    public ExampleCriteria equal(BooleanOperator type, Boolean condition, String property, Object value) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new EqualSpecification(type, property, value));
            } else {
                andClassList.add(new EqualSpecification(type, property, value));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andEqual(Boolean condition, String property, Object value) {
        return equal(BooleanOperator.AND, condition, property, value);
    }

    @Override
    public ExampleCriteria orEqual(Boolean condition, String property, Object value) {
        return equal(BooleanOperator.OR, condition, property, value);
    }

    @Override
    public ExampleCriteria andEqual(String property, Object value) {
        return andEqual(true, property, value);
    }

    @Override
    public ExampleCriteria orEqual(String property, Object value) {
        return orEqual(true, property, value);
    }

    @Override
    public ExampleCriteria notEqual(BooleanOperator type, Boolean condition, String property, Object value) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new NotEqualSpecification(type, property, value));
            } else {
                andClassList.add(new NotEqualSpecification(type, property, value));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andNotEqual(Boolean condition, String property, Object value) {
        return notEqual(BooleanOperator.AND, condition, property, value);
    }

    @Override
    public ExampleCriteria orNotEqual(Boolean condition, String property, Object value) {
        return notEqual(BooleanOperator.OR, condition, property, value);
    }

    @Override
    public ExampleCriteria andNotEqual(String property, Object value) {
        return andNotEqual(true, property, value);
    }

    @Override
    public ExampleCriteria orNotEqual(String property, Object value) {
        return orNotEqual(true, property, value);
    }

    @Override
    public ExampleCriteria like(BooleanOperator type, Boolean condition, String property, String value) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new LikeSpecification(type, property, value));
            } else {
                andClassList.add(new LikeSpecification(type, property, value));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andLike(Boolean condition, String property, String value) {
        return like(BooleanOperator.AND, condition, property, value);
    }

    @Override
    public ExampleCriteria orLike(Boolean condition, String property, String value) {
        return like(BooleanOperator.OR, condition, property, value);
    }

    @Override
    public ExampleCriteria andLike(String property, String value) {
        return andLike(true, property, value);
    }

    @Override
    public ExampleCriteria orLike(String property, String value) {
        return orLike(true, property, value);
    }

    @Override
    public ExampleCriteria notLike(BooleanOperator type, Boolean condition, String property, String value) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new NotLikeSpecification(type, property, value));
            } else {
                andClassList.add(new NotLikeSpecification(type, property, value));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andNotLike(Boolean condition, String property, String value) {
        return notLike(BooleanOperator.AND, condition, property, value);
    }

    @Override
    public ExampleCriteria orNotLike(Boolean condition, String property, String value) {
        return notLike(BooleanOperator.OR, condition, property, value);
    }

    @Override
    public ExampleCriteria andNotLike(String property, String value) {
        return andNotLike(true, property, value);
    }

    @Override
    public ExampleCriteria orNotLike(String property, String value) {
        return orNotLike(true, property, value);
    }

    @Override
    public ExampleCriteria between(BooleanOperator type, Boolean condition, String property, Range range) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new BetweenSpecification(type, property, range));
            } else {
                andClassList.add(new BetweenSpecification(type, property, range));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andBetween(Boolean condition, String property, Range range) {
        return between(BooleanOperator.AND, condition, property, range);
    }

    @Override
    public ExampleCriteria orBetween(Boolean condition, String property, Range range) {
        return between(BooleanOperator.OR, condition, property, range);
    }

    @Override
    public ExampleCriteria andBetween(String property, Range range) {
        return andBetween(true, property, range);
    }

    @Override
    public ExampleCriteria orBetween(String property, Range range) {
        return orBetween(true, property, range);
    }

    @Override
    public ExampleCriteria greaterThan(BooleanOperator type, Boolean condition, String property, Number number) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new GtSpecification(type, property, number));
            } else {
                andClassList.add(new GtSpecification(type, property, number));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andGreaterThan(Boolean condition, String property, Number number) {
        return greaterThan(BooleanOperator.AND, condition, property, number);
    }

    @Override
    public ExampleCriteria orGreaterThan(Boolean condition, String property, Number number) {
        return greaterThan(BooleanOperator.OR, condition, property, number);
    }

    @Override
    public ExampleCriteria andGreaterThan(String property, Number number) {
        return andGreaterThan(true, property, number);
    }

    @Override
    public ExampleCriteria orGreaterThan(String property, Number number) {
        return orGreaterThan(true, property, number);
    }

    @Override
    public ExampleCriteria greaterThanOrEqualTo(BooleanOperator type, Boolean condition, String property, Number number) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new GeSpecification(type, property, number));
            } else {
                andClassList.add(new GeSpecification(type, property, number));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andGreaterThanOrEqualTo(Boolean condition, String property, Number number) {
        return greaterThanOrEqualTo(BooleanOperator.AND, condition, property, number);
    }

    @Override
    public ExampleCriteria orGreaterThanOrEqualTo(Boolean condition, String property, Number number) {
        return greaterThanOrEqualTo(BooleanOperator.OR, condition, property, number);
    }

    @Override
    public ExampleCriteria andGreaterThanOrEqualTo(String property, Number number) {
        return andGreaterThanOrEqualTo(true, property, number);
    }

    @Override
    public ExampleCriteria orGreaterThanOrEqualTo(String property, Number number) {
        return orGreaterThanOrEqualTo(true, property, number);
    }

    @Override
    public ExampleCriteria lessThan(BooleanOperator type, Boolean condition, String property, Number number) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new LtSpecification(type, property, number));
            } else {
                andClassList.add(new LtSpecification(type, property, number));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andLessThan(Boolean condition, String property, Number number) {
        return lessThan(BooleanOperator.AND, condition, property, number);
    }

    @Override
    public ExampleCriteria orLessThan(Boolean condition, String property, Number number) {
        return lessThan(BooleanOperator.OR, condition, property, number);
    }

    @Override
    public ExampleCriteria andLessThan(String property, Number number) {
        return andLessThan(true, property, number);
    }

    @Override
    public ExampleCriteria orLessThan(String property, Number number) {
        return orLessThan(true, property, number);
    }

    @Override
    public ExampleCriteria lessThanOrEqualTo(BooleanOperator type, Boolean condition, String property, Number number) {
        if (condition) {
            if (type.equals(BooleanOperator.OR)) {
                orClassList.add(new LeSpecification(type, property, number));
            } else {
                andClassList.add(new LeSpecification(type, property, number));
            }
        }
        return this;
    }

    @Override
    public ExampleCriteria andLessThanOrEqualTo(Boolean condition, String property, Number number) {
        return lessThanOrEqualTo(BooleanOperator.AND, condition, property, number);
    }

    @Override
    public ExampleCriteria orLessThanOrEqualTo(Boolean condition, String property, Number number) {
        return lessThanOrEqualTo(BooleanOperator.OR, condition, property, number);
    }

    @Override
    public ExampleCriteria andLessThanOrEqualTo(String property, Number number) {
        return andLessThanOrEqualTo(true, property, number);
    }

    @Override
    public ExampleCriteria orLessThanOrEqualTo(String property, Number number) {
        return orLessThanOrEqualTo(true, property, number);
    }

    @Override
    public ExampleCriteria gt(BooleanOperator type, Boolean condition, String property, Number number) {
        return greaterThan(type, condition, property, number);
    }

    @Override
    public ExampleCriteria andGt(Boolean condition, String property, Number number) {
        return andGreaterThan(condition, property, number);
    }

    @Override
    public ExampleCriteria orGt(Boolean condition, String property, Number number) {
        return orGreaterThan(condition, property, number);
    }

    @Override
    public ExampleCriteria andGt(String property, Number number) {
        return andGreaterThan(true, property, number);
    }

    @Override
    public ExampleCriteria orGt(String property, Number number) {
        return orGreaterThan(true, property, number);
    }

    @Override
    public ExampleCriteria ge(BooleanOperator type, Boolean condition, String property, Number number) {
        return greaterThanOrEqualTo(type, condition, property, number);
    }

    @Override
    public ExampleCriteria andGe(Boolean condition, String property, Number number) {
        return andGreaterThanOrEqualTo(condition, property, number);
    }

    @Override
    public ExampleCriteria orGe(Boolean condition, String property, Number number) {
        return orGreaterThanOrEqualTo(condition, property, number);
    }

    @Override
    public ExampleCriteria andGe(String property, Number number) {
        return andGreaterThanOrEqualTo(property, number);
    }

    @Override
    public ExampleCriteria orGe(String property, Number number) {
        return orGreaterThanOrEqualTo(property, number);
    }

    @Override
    public ExampleCriteria lt(BooleanOperator type, Boolean condition, String property, Number number) {
        return lessThan(type, condition, property, number);
    }

    @Override
    public ExampleCriteria andLt(Boolean condition, String property, Number number) {
        return andLessThan(condition, property, number);
    }

    @Override
    public ExampleCriteria orLt(Boolean condition, String property, Number number) {
        return orLessThan(condition, property, number);
    }

    @Override
    public ExampleCriteria andLt(String property, Number number) {
        return andLessThan(property, number);
    }

    @Override
    public ExampleCriteria orLt(String property, Number number) {
        return orLessThan(property, number);
    }

    @Override
    public ExampleCriteria le(BooleanOperator type, Boolean condition, String property, Number number) {
        return lessThanOrEqualTo(type, condition, property, number);
    }

    @Override
    public ExampleCriteria andLe(Boolean condition, String property, Number number) {
        return andLessThanOrEqualTo(condition, property, number);
    }

    @Override
    public ExampleCriteria orLe(Boolean condition, String property, Number number) {
        return orLessThanOrEqualTo(condition, property, number);
    }

    @Override
    public ExampleCriteria andLe(String property, Number number) {
        return andLessThanOrEqualTo(property, number);
    }

    @Override
    public ExampleCriteria orLe(String property, Number number) {
        return orLessThanOrEqualTo(property, number);
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
        From from = root;
        for (JoinClass c : joinClassList) {
            from = from.join(String.valueOf(c.getClassName()), c.getType());
        }

        final From finalFrom = from;
        Predicate[] ands = this.andClassList.stream()
                .map(spec -> spec.toPredicate(finalFrom, query, cb))
                .toArray(Predicate[]::new);

        Predicate[] ors = this.orClassList.stream()
                .map(spec -> spec.toPredicate(finalFrom, query, cb))
                .toArray(Predicate[]::new);

        this.orderClassList.stream()
                .map(spec -> spec.toPredicate(finalFrom, query, cb))
                .toArray(Predicate[]::new);
        return cb.or(cb.and(ands), cb.or(ors));
    }

    class JoinClass{
        JoinType type;
        String classname;
        public JoinClass(Class c, JoinType type) {
            this.type = type;
            this.classname = c.getName();
        }
        public JoinType getType() {return type;}
        public String getClassName() { return classname; }
    }
}
