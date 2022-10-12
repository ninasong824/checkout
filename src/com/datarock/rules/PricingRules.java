package com.datarock.rules;

import com.datarock.constants.ProductEnum;

public class PricingRules implements IPricingRules {

    @Override
    public Double getTotal(int ipadQuan, int macbookQuan, int appleTVQuan, int vgaQuan){
        double ipadTotal = ipadQuan> 4 ? 499.99 * ipadQuan : ProductEnum.IPAD.price * ipadQuan;

        double macbookTotal = macbookQuan * ProductEnum.MACBOOK.price;

        double appleTVTotal = ((appleTVQuan/3)*2 + appleTVQuan%3) * ProductEnum.APPLE_TV.price;

        double vgaTotal = vgaQuan > macbookQuan ? (vgaQuan - macbookQuan) * ProductEnum.VGA.price : 0.00;

        return ipadTotal + macbookTotal + appleTVTotal + vgaTotal;
    }

}
