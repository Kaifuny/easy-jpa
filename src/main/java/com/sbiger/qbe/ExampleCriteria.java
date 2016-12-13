package com.sbiger.qbe;

import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by sbiger on 2016-11-24.
 */
public interface ExampleCriteria<T> extends Specification {
    public static enum BooleanOperator {
        AND,
        OR;
        private BooleanOperator() {}
    }

//    ExampleCriteria<T> asc();

//    ExampleCriteria<T> desc();

//    ExampleCriteria<T> orderby();

//    ExampleCriteria<T> avg();

//    ExampleCriteria<T> sum();

//    ExampleCriteria<T> sumAsLong();

//    ExampleCriteria<T> sumAsDouble();

//    ExampleCriteria<T> max();

    ExampleCriteria<T> in(BooleanOperator type, Boolean condition, String property, Object[] value);
    ExampleCriteria<T> andIn(Boolean condition, String property, Object[] value);
    ExampleCriteria<T> orIn(Boolean condition, String property, Object[] value);
    ExampleCriteria<T> andIn(String property, Object[] value);
    ExampleCriteria<T> orIn(String property, Object[] value);

    ExampleCriteria<T> notIn(BooleanOperator type, Boolean condition, String property, Object[] value);
    ExampleCriteria<T> andNotIn(Boolean condition, String property, Object[] value);
    ExampleCriteria<T> orNotIn(Boolean condition, String property, Object[] value);
    ExampleCriteria<T> andNotIn(String property, Object[] value);
    ExampleCriteria<T> orNotIn(String property, Object[] value);

//    ExampleCriteria<T> greatest();

//    ExampleCriteria<T> least();

//    ExampleCriteria<T> count();

//    ExampleCriteria<T> countDistinct();

//    ExampleCriteria<T> exists();

//    ExampleCriteria<T> all();

//    ExampleCriteria<T> some();

//    ExampleCriteria<T> any();

//    ExampleCriteria<T> and();

//    ExampleCriteria<T> or();

//    ExampleCriteria<T> not();

//    ExampleCriteria<T> isTrue();

//    ExampleCriteria<T> isFalse();

//    ExampleCriteria<T> isNull();

//    ExampleCriteria<T> isNotNull();

    ExampleCriteria<T> equal(BooleanOperator type, Boolean condition, String property, Object value);
    ExampleCriteria<T> andEqual(Boolean condition, String property, Object value);
    ExampleCriteria<T> orEqual(Boolean condition, String property, Object value);
    ExampleCriteria<T> andEqual(String property, Object value);
    ExampleCriteria<T> orEqual(String property, Object value);

    ExampleCriteria<T> notEqual(BooleanOperator type, Boolean condition, String property, Object value);
    ExampleCriteria<T> andNotEqual(Boolean condition, String property, Object value);
    ExampleCriteria<T> orNotEqual(Boolean condition, String property, Object value);
    ExampleCriteria<T> andNotEqual(String property, Object value);
    ExampleCriteria<T> orNotEqual(String property, Object value);

    ExampleCriteria<T> greaterThan(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andGreaterThan(Boolean condition, String property, Number number);
    ExampleCriteria<T> orGreaterThan(Boolean condition, String property, Number number);
    ExampleCriteria<T> andGreaterThan(String property, Number number);
    ExampleCriteria<T> orGreaterThan(String property, Number number);

    ExampleCriteria<T> greaterThanOrEqualTo(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andGreaterThanOrEqualTo(Boolean condition, String property, Number number);
    ExampleCriteria<T> orGreaterThanOrEqualTo(Boolean condition, String property, Number number);
    ExampleCriteria<T> andGreaterThanOrEqualTo(String property, Number number);
    ExampleCriteria<T> orGreaterThanOrEqualTo(String property, Number number);

    ExampleCriteria<T> lessThan(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andLessThan(Boolean condition, String property, Number number);
    ExampleCriteria<T> orLessThan(Boolean condition, String property, Number number);
    ExampleCriteria<T> andLessThan(String property, Number number);
    ExampleCriteria<T> orLessThan(String property, Number number);

    ExampleCriteria<T> lessThanOrEqualTo(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andLessThanOrEqualTo(Boolean condition, String property, Number number);
    ExampleCriteria<T> orLessThanOrEqualTo(Boolean condition, String property, Number number);
    ExampleCriteria<T> andLessThanOrEqualTo(String property, Number number);
    ExampleCriteria<T> orLessThanOrEqualTo(String property, Number number);

    ExampleCriteria<T> between(BooleanOperator type, Boolean condition, String property, Range range);
    ExampleCriteria<T> andBetween(Boolean condition, String property, Range range);
    ExampleCriteria<T> orBetween(Boolean condition, String property, Range range);
    ExampleCriteria<T> andBetween(String property, Range range);
    ExampleCriteria<T> orBetween(String property, Range range);

    ExampleCriteria<T> gt(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andGt(Boolean condition, String property, Number number);
    ExampleCriteria<T> orGt(Boolean condition, String property, Number number);
    ExampleCriteria<T> andGt(String property, Number number);
    ExampleCriteria<T> orGt(String property, Number number);

    ExampleCriteria<T> ge(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andGe(Boolean condition, String property, Number number);
    ExampleCriteria<T> orGe(Boolean condition, String property, Number number);
    ExampleCriteria<T> andGe(String property, Number number);
    ExampleCriteria<T> orGe(String property, Number number);

    ExampleCriteria<T> lt(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andLt(Boolean condition, String property, Number number);
    ExampleCriteria<T> orLt(Boolean condition, String property, Number number);
    ExampleCriteria<T> andLt(String property, Number number);
    ExampleCriteria<T> orLt(String property, Number number);

    ExampleCriteria<T> le(BooleanOperator type, Boolean condition, String property, Number number);
    ExampleCriteria<T> andLe(Boolean condition, String property, Number number);
    ExampleCriteria<T> orLe(Boolean condition, String property, Number number);
    ExampleCriteria<T> andLe(String property, Number number);
    ExampleCriteria<T> orLe(String property, Number number);

//    ExampleCriteria<T> neg();

//    ExampleCriteria<T> prod();

//    ExampleCriteria<T> diff();

//    ExampleCriteria<T> quot();

//    ExampleCriteria<T> mod();

//    ExampleCriteria<T> sqrt();

//    ExampleCriteria<T> toLong();

//    ExampleCriteria<T> toInteger();

//    ExampleCriteria<T> toFloat();

//    ExampleCriteria<T> toDouble();

//    ExampleCriteria<T> toBigDecimal();

//    ExampleCriteria<T> toBigInteger();

//    ExampleCriteria<T> isEmpty();

//    ExampleCriteria<T> isNotEmpty();

//    ExampleCriteria<T> size();

//    ExampleCriteria<T> isMember();

//    ExampleCriteria<T> isNotMember();

    ExampleCriteria<T> like(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> andLike(Boolean condition, String property, String value);
    ExampleCriteria<T> orLike(Boolean condition, String property, String value);
    ExampleCriteria<T> andLike(String property, String value);
    ExampleCriteria<T> orLike(String property, String value);

    ExampleCriteria<T> notLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> andNotLike(Boolean condition, String property, String value);
    ExampleCriteria<T> orNotLike(Boolean condition, String property, String value);
    ExampleCriteria<T> andNotLike(String property, String value);
    ExampleCriteria<T> orNotLike(String property, String value);

//    ExampleCriteria<T> concat();

//    ExampleCriteria<T> substring();

//    ExampleCriteria<T> trim();

//    ExampleCriteria<T> lower();

//    ExampleCriteria<T> upper();

//    ExampleCriteria<T> length();

//    ExampleCriteria<T> locate();

//    ExampleCriteria<T> currentDate();

//    ExampleCriteria<T> currentTimestamp();

//    ExampleCriteria<T> currentTime();

//    ExampleCriteria<T> coalesce();

//    ExampleCriteria<T> nullif();

//    ExampleCriteria<T> selectCase();
}
