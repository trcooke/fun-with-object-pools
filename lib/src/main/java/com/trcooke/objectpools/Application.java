package com.trcooke.objectpools;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.Scanner;

public class Application {

    public void start() {
        ObjectPool<Price> pricePool = new GenericObjectPool<>(new PriceFactory());
        Scanner in = new Scanner(System.in);
        in.next();
        System.out.println("App start");
        Price price = null;
        for (int i = 0; i < 1_000_000_000; i++) {
            try {
                price = pricePool.borrowObject();
                price.set(i + "." + i);
            } catch (Exception e) {
                //
            } finally {
                try {
                    pricePool.returnObject(price);
                } catch (Exception e) {
                    //
                }
            }
        }
        System.out.println("App finish");
        System.out.println(pricePool.getNumActive());
        System.out.println(pricePool.getNumIdle());
        in.next();
    }

    public static void main(String[] args) {
        new Application().start();
    }
}
