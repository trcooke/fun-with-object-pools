package com.trcooke.objectpools;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PricePoolTest {

    @Test
    void borrowFreshObject() throws Exception {
        ObjectPool<Price> pricePool = new GenericObjectPool<>(new PriceFactory());
        Price price;
        price = pricePool.borrowObject();
        assertEquals("0.0", price.getPrice());
    }

    @Test
    void returnObjectResetsObject() throws Exception {
        ObjectPool<Price> pricePool = new GenericObjectPool<>(new PriceFactory());
        Price price;
        price = pricePool.borrowObject();
        price.set("5.50");
        pricePool.returnObject(price);
        price = pricePool.borrowObject();
        assertEquals("0.0", price.getPrice());
    }

    @Test
    void carefulWithSharingObjectReferences() throws Exception {
        ObjectPool<Price> pricePool = new GenericObjectPool<>(new PriceFactory());
        Price price;
        Price price2;
        price = pricePool.borrowObject();
        price.set("1.50");
        assertEquals("1.50", price.getPrice());
        pricePool.returnObject(price);
        price2 = pricePool.borrowObject();
        price2.set("3.20");
        assertEquals("3.20", price2.getPrice());
        // Watch out. We've now got two references to the single pooled object.
        assertEquals("3.20", price.getPrice());
    }
}
