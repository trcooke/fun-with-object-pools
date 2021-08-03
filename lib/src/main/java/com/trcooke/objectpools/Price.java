package com.trcooke.objectpools;

public class Price {
    private String wholePart = "0";
    private String decimalPart = "0";

    public String getPrice() {
        return wholePart + "." + decimalPart;
    }

    public void set(String price) {
        if (price.contains(".")) {
            wholePart = price.split("\\.")[0];
            decimalPart = price.split("\\.")[1];
        } else {
            wholePart = price;
            decimalPart = "0";
        }
    }
}
