package com.company.Personal;

import com.company.Bar;
import com.company.Exceptions.DrinkNotFoundException;
import com.company.Exceptions.OrderDrinkOverException;
import com.company.Orders;

/**
 * Created by unike on 18.12.2016.
 */
public class Waiter extends Personal {
    private Bar bar;


    public Waiter(String name, int age, Bar bar) {
        super(name, age);
        this.bar = bar;
    }


    public void addOrder(String nameOfAlcohol, int amount) throws DrinkNotFoundException, OrderDrinkOverException {
        for (int i = 0; i < bar.getCurentAlcoholNumber(); i++) {
            if (bar.getAlcohol()[i].getName().equals(nameOfAlcohol)) {
                if (bar.getAlcohol()[i].getAmount() < amount) throw new OrderDrinkOverException("Not correct value for order: "+amount+". Requested drink: "+nameOfAlcohol+" is over");
                    else {
                    float curentLoad = (float) bar.getSize() / (float) bar.getInitialSize();
                    if (curentLoad >= bar.getMaxLoad()) {
                        bar.setInitialSize((int) (bar.getSize() * 1.5));
                        Orders tmp[] = new Orders[bar.getInitialSize()];
                        for (int j = 0; j < bar.getSize(); j++) {
                            tmp[j] = bar.getOrders()[j];
                        }
                        bar.setOrder(tmp);
                    }
                    bar.setOrderByID(new Orders(nameOfAlcohol, amount), bar.getSize());
                    bar.setSize(bar.getSize() + 1);
                    bar.decreaseAlcoholAmount(nameOfAlcohol, amount);
                }
            }
            if (i == bar.getCurentAlcoholNumber()-1 && !bar.getAlcohol()[i].getName().equals(nameOfAlcohol)) throw new DrinkNotFoundException("Requested drink: "+nameOfAlcohol+" is not found");
        }
    }


    public void takeTips(int amount) {
        bar.setTips(bar.getTips() + amount);
    }


}
