package com.datarock;

import com.datarock.rules.IPricingRules;
import com.datarock.rules.PricingRules;

public class Main {

    public static void main(String[] args) {

        IPricingRules pricingRules = new PricingRules();
/* There could be more pricing rule logic adding here, for example
 * if(today == '25/11/2022') Checkout co = new Checkout(blackFridayPricingRules)
 * else Checkout co = new Checkout(pricingRules);
 *
 * */
        Checkout co = new Checkout(pricingRules);
        try{
            do{
                System.out.println("Please scan: ");
            } while(co.scan());
        }catch (NullPointerException e){
            System.out.println("wrong code");
        }
    }
}
