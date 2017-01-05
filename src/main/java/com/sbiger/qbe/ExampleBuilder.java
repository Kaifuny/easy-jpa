package com.sbiger.qbe;

import javax.persistence.EntityManager;

/**
 * Created by sbiger on 2016-12-21.
 */
public class ExampleBuilder {
    public static Example create() {
        return new Example();
    }

    public static ExampleQuery create(EntityManager em) {
        return new ExampleQuery(em);
    }
}
