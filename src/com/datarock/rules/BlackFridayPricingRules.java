package com.datarock.rules;

public class BlackFridayPricingRules implements IPricingRules {

    @Override
    public Double getTotal(int ipadQuan, int macbookQuan, int appleTVQuan, int vgaQuan) {
        //TODO could add black friday pricing rules, just adding this as example
        return 0.1;
    }
}
