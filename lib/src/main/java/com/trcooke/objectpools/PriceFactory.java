package com.trcooke.objectpools;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PriceFactory extends BasePooledObjectFactory<Price> {
    @Override
    public Price create() {
        return new Price();
    }

    @Override
    public PooledObject<Price> wrap(Price price) {
        return new DefaultPooledObject<>(price);
    }

    @Override
    public void passivateObject(final PooledObject<Price> price) {
        price.getObject().set("0.0");
    }
}
