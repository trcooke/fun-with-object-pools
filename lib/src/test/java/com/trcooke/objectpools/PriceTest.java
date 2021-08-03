package com.trcooke.objectpools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void setWholeNumber() {
        Price price = new Price();
        price.set("7");
        assertEquals("7.0", price.getPrice());
    }

    @Test
    void setDecimalNumber() {
        Price price = new Price();
        price.set("8.50");
        assertEquals("8.50", price.getPrice());
    }

    @Test
    void assignNewValue() {
        Price price = new Price();
        price.set("3.99");
        price.set("10.50");
        assertEquals("10.50", price.getPrice());
    }
}