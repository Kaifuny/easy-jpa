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

//    CriteriaExample<T> asc();

//    CriteriaExample<T> desc();

//    CriteriaExample<T> orderby();

//    CriteriaExample<T> avg();

//    CriteriaExample<T> sum();

//    CriteriaExample<T> sumAsLong();

//    CriteriaExample<T> sumAsDouble();

//    CriteriaExample<T> max();

//    CriteriaExample<T> in();

//    CriteriaExample<T> greatest();

//    CriteriaExample<T> least();

//    CriteriaExample<T> count();

//    CriteriaExample<T> countDistinct();

//    CriteriaExample<T> exists();

//    CriteriaExample<T> all();

//    CriteriaExample<T> some();

//    CriteriaExample<T> any();

//    CriteriaExample<T> and();

//    CriteriaExample<T> or();

//    CriteriaExample<T> not();

//    CriteriaExample<T> isTrue();

//    CriteriaExample<T> isFalse();

//    CriteriaExample<T> isNull();

//    CriteriaExample<T> isNotNull();

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

//    CriteriaExample<T> greaterThan();

//    CriteriaExample<T> greaterThanOrEqualTo();

//    CriteriaExample<T> lessThan();

//    CriteriaExample<T> lessThanOrEqualTo();

//    CriteriaExample<T> between();

//    CriteriaExample<T> gt();

//    CriteriaExample<T> ge();

//    CriteriaExample<T> lt();

//    CriteriaExample<T> le();

//    CriteriaExample<T> neg();

//    CriteriaExample<T> prod();

//    CriteriaExample<T> diff();

//    CriteriaExample<T> quot();

//    CriteriaExample<T> mod();

//    CriteriaExample<T> sqrt();

//    CriteriaExample<T> toLong();

//    CriteriaExample<T> toInteger();

//    CriteriaExample<T> toFloat();

//    CriteriaExample<T> toDouble();

//    CriteriaExample<T> toBigDecimal();

//    CriteriaExample<T> toBigInteger();

//    CriteriaExample<T> isEmpty();

//    CriteriaExample<T> isNotEmpty();

//    CriteriaExample<T> size();

//    CriteriaExample<T> isMember();

//    CriteriaExample<T> isNotMember();

//    CriteriaExample<T> like();

//    CriteriaExample<T> notLike();

//    CriteriaExample<T> concat();

//    CriteriaExample<T> substring();

//    CriteriaExample<T> trim();

//    CriteriaExample<T> lower();

//    CriteriaExample<T> upper();

//    CriteriaExample<T> length();

//    CriteriaExample<T> locate();

//    CriteriaExample<T> currentDate();

//    CriteriaExample<T> currentTimestamp();

//    CriteriaExample<T> currentTime();

//    CriteriaExample<T> coalesce();

//    CriteriaExample<T> nullif();

//    CriteriaExample<T> selectCase();
}
