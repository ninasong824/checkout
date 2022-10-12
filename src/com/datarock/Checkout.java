package com.datarock;

import com.datarock.constants.ProductEnum;
import com.datarock.rules.IPricingRules;

import java.util.Scanner;

public class Checkout {

    private IPricingRules pricingRules;

    private Scanner scanner  = new Scanner(System.in);

    //private ItemCounter itemCounter = new ItemCounter();

    private int ipadCounter = 0;
    private int macbookCounter = 0;
    private int appleTVCounter = 0;
    private int vgaCounter = 0;

    public Checkout(IPricingRules pricingRules){
        this.pricingRules = pricingRules;
    }

    public boolean scan(){
        String sku = scanner.nextLine();
        if ("pay".equalsIgnoreCase(sku)) {
            System.out.println("Total: $" + String.format("%,.2f", this.total()));
            resetCounter();
            System.out.println("Thank you!");
            return false;
        }
        switch (ProductEnum.valueOfSku(sku)){
            case IPAD:
                ipadCounter++;
                break;
            case MACBOOK:
                macbookCounter++;
                break;
            case APPLE_TV:
                appleTVCounter++;
                break;
            case VGA:
                vgaCounter++;
                break;
             default:

        }
        return true;
    }

    public Double total(){
        return pricingRules.getTotal(ipadCounter, macbookCounter, appleTVCounter, vgaCounter);
    }

    private void resetCounter(){
        ipadCounter = 0;
        macbookCounter = 0;
        appleTVCounter = 0;
        vgaCounter = 0;
    }


//The following code just for unit testing, could be refactored as ItemCounter which has these 4 counters
    public int getIpadCounter(){
        return ipadCounter;
    }

    public void setIpadCounter(int ipadCounter){
        this.ipadCounter = ipadCounter;
    }

    public int getMacbookCounter() {
        return macbookCounter;
    }

    public int getAppleTVCounter() {
        return appleTVCounter;
    }

    public int getVgaCounter() {
        return vgaCounter;
    }
}
