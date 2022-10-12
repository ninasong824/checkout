package com.datarock.constants;

import java.util.HashMap;
import java.util.Map;

public enum ProductEnum {
    IPAD("ipd","Super iPad", 549.99),
    MACBOOK("mbp","MacBook Pro",	1399.99),
    APPLE_TV("atv","Apple TV",109.50),
    VGA("vga","VGA adapter",	30.00);

    private static final Map<String, ProductEnum> BY_SKU = new HashMap<>();

    static {
        for (ProductEnum p : values()) {
            BY_SKU.put(p.sku, p);
        }
    }

    public final String sku;
    public final String name;
    public final Double price;

    private ProductEnum(String sku, String name, Double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public static ProductEnum valueOfSku(String sku) {
        return BY_SKU.get(sku);
    }
}
