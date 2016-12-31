package com.sbiger.qbe;

import javax.persistence.EntityManager;

/**
 * Created by sbiger on 2016-12-22.
 */
public class ExampleQuery<T> extends Example<T> {
    private EntityManager em;

    public ExampleQuery(EntityManager em) {
        this.em = em;
    }

    public ExampleQuery select() {
        return this;
    }
}
