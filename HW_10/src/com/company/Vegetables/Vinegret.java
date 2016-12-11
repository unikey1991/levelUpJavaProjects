package com.company.Vegetables;

import com.company.Vegetables.Alliums.Onion;
import com.company.Vegetables.Roots.Beetroot;
import com.company.Vegetables.Roots.Carrot;
import com.company.Vegetables.Tubers.Potato;

/**
 * Created by unike on 11.12.2016.
 */
public class Vinegret extends Salad {


    public Vinegret() {
        super("Vinegret", 4);
        vegetable[0] = new Potato(200);
        vegetable[1] = new Carrot(170);
        vegetable[2] = new Beetroot(300);
        vegetable[3] = new Onion(50);
    }



}
