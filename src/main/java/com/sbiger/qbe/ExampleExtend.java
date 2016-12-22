package com.sbiger.qbe;

import javax.persistence.EntityManager;

/**
 * Created by sbiger on 2016-12-22.
 */
public class ExampleExtend<T> extends Example<T> {
    private EntityManager em;

    public ExampleExtend(EntityManager em) {
        this.em = em;
    }


}
