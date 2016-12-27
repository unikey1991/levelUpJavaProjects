package com.company.Personal;

import com.company.Bar;
import com.company.Orders;

/**
 * Created by unike on 18.12.2016.
 */
public class Barman extends Personal {

    private String exclusiveCoctail;
    private Bar bar;


    public Barman(String name, int age, String exclusiveCoctail, Bar bar) {
        super(name, age);
        this.bar = bar;
        this.exclusiveCoctail = exclusiveCoctail;
    }

    public void performOrder() {
        if (bar.getOrdersAmount() > 0) {
            System.out.println("Заказ на " + bar.getOrders()[0].getAmount() + " бутылок напитка " + bar.getOrders()[0].getTitle() + " выполнен");
            bar.removeFromArrayStarting();
        } else System.out.println("Нет заказов");
    }
}
