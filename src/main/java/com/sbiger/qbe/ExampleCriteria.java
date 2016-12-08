package com.sbiger.qbe;

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

//    ExampleCriteria<T> in();

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

//    ExampleCriteria<T> greaterThan();

//    ExampleCriteria<T> greaterThanOrEqualTo();

//    ExampleCriteria<T> lessThan();

//    ExampleCriteria<T> lessThanOrEqualTo();

//    ExampleCriteria<T> between();

//    ExampleCriteria<T> gt();

//    ExampleCriteria<T> ge();

//    ExampleCriteria<T> lt();

//    ExampleCriteria<T> le();

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
    ExampleCriteria<T> andLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> orLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> andLike(BooleanOperator type, String property, String value);
    ExampleCriteria<T> orLike(BooleanOperator type, String property, String value);

    ExampleCriteria<T> notLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> andNotLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> orNotLike(BooleanOperator type, Boolean condition, String property, String value);
    ExampleCriteria<T> andNotLike(BooleanOperator type, String property, String value);
    ExampleCriteria<T> orNotLike(BooleanOperator type, String property, String value);

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
