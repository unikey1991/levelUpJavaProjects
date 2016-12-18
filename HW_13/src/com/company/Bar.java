package com.company;

import com.company.Cocktails.Alcohol;
import com.company.Personal.Barman;
import com.company.Personal.Waiter;

/**
 * Created by unike on 18.12.2016.
 */
public class Bar {

    private Waiter waiter[] = new Waiter[3];
    private int curentWaitersNumber;
    private Barman barman[] = new Barman[5];
    private int curentBarmansNumber;
    private String barName;
    private static Alcohol alcohol[] = new Alcohol[10];
    private int curentAlcoholNumber;
    private int tips;
    ///////////////
    private Orders orders[];
    private int initialSize;
    private int size = 0;
    private float maxLoad = 0.8f;
    private float minLoad = 0.6f;
    private static final int MIN_SIZE = 10;
    //////////////

    public Bar(String barName) {
        this.initialSize = 10;
        this.barName = barName;
        this.orders = new Orders[initialSize];
    }
    //////////////////

    public void shareTip() {
        System.out.println(tips + " чаевых поделено на " + curentBarmansNumber + " барменов");
    }

    public void takeTips(int amount, int waiterId) {
        waiter[waiterId].takeTips(amount);
    }


    public void addPersonal(String name, int age, String exclusiveCoctail, String position, Bar bar) {
        switch (position) {
            case "бармен":
                if (curentBarmansNumber < this.barman.length) {
                    for (int i = 0; i < this.barman.length; i++) {
                        if (this.barman[i] == null) {
                            this.barman[i] = new Barman(name, age, exclusiveCoctail, bar);
                            System.out.println("Grac, " + name + " стал барменом под ид " + i);
                            curentBarmansNumber++;
                            break;
                        }
                    }
                } else System.out.println("штат барменов уже заполнен");
                break;
            case "официант":
                if (curentWaitersNumber < this.waiter.length) {
                    for (int i = 0; i < this.waiter.length; i++) {
                        if (this.waiter[i] == null) {
                            this.waiter[i] = new Waiter(name, age, bar);
                            System.out.println("Grac, " + name + " стал ошициантом под ид " + i);
                            curentWaitersNumber++;
                            break;
                        }
                    }
                } else System.out.println("штат официантов уже заполнен");
                break;
            default:
                System.out.println("неверная должность");
        }
    }

    public String delPersonal(String name, String position) {
        switch (position) {
            case "бармен":
                if (curentBarmansNumber > 0) {
                    for (int i = 0; i < barman.length && barman[i] != null; i++) {
                        if (barman[i].getName().equals(name)) {
                            this.barman[i] = null;
                            return name + " уволен(а)";
                        }
                    }
                    return "бармен с таким именем не найден";
                }
                return "алло, у нас и так нет барменов!";
            case "официант":
                if (curentWaitersNumber > 0) {
                    for (int i = 0; i < waiter.length && waiter[i] != null; i++) {
                        if (waiter[i].getName().equals(name)) {
                            this.waiter[i] = null;
                            return name + " уволен(а)";
                        }
                    }
                    return "официант с таким именем не найден";
                }
                return "алло, у нас и так нет барменов!";
            default:
                return "неверная должность";
        }
    }


    public void performeOrder(int barmanId, Bar bar) {
        barman[barmanId].performOrder();
    }


    /*Метод “пополнить склад” принимает объект с названием напитка и его количеством.
    Если такой напиток существует в баре, то его количество обновляется. Если нет, то добавляется новый объект.*/

    public void fillWarehouse(String alcoholName, int amount) {
        for (int i = 0; i < curentAlcoholNumber; i++) {
            if (alcohol[i] != null && alcohol[i].getName().equals(alcoholName)) {
                alcohol[i].setAmount(alcohol[i].getAmount() + amount);
                System.out.println("добавлено " + amount + " бутылок " + alcoholName);
                break;
            }
            if (i == curentAlcoholNumber - 1) {
                alcohol[curentAlcoholNumber++] = new Alcohol(alcoholName, amount);
                System.out.println(alcoholName + " добавлен в бар. " + amount + " бутылок");
                break;
            }
        }
        if (curentAlcoholNumber == 0) {
            alcohol[curentAlcoholNumber++] = new Alcohol(alcoholName, amount);
            System.out.println(alcoholName + " добавлен в бар. " + amount + " бутылок");
        }
        if (curentAlcoholNumber == alcohol.length)
            System.out.println("хватит, у нас и так разнообразие из " + curentAlcoholNumber + " напитков");
    }


    public void removeFromArrayStarting() {
        Orders buffer = orders[0];
        for (int i = 0; i < size; i++) {
            orders[i] = orders[i + 1];
        }
        orders[size - 1] = buffer;
        removeOrder();
    }

    public void removeOrder() {
        if (size > 0) {
            orders[--size] = null;
        }
        float curetLoad = (float) size / (float) initialSize;
        if (curetLoad <= minLoad && orders.length > MIN_SIZE) {
            initialSize = (int) (size * 1.5);
            Orders[] tmp = new Orders[initialSize];
            for (int i = 0; i < size; i++) {
                tmp[i] = orders[i];
            }
            orders = tmp;
        }
    }


    public void decreaseAlcoholAmount(String name, int amount) {
        for (int i = 0; i < curentAlcoholNumber; i++) {
            if (alcohol[i].getName().equals(name)) alcohol[i].setAmount(alcohol[i].getAmount() - amount);
        }
    }

    public void addOrder(int waiterID, String nameOfAlcohol, int amount) {
        waiter[waiterID].addOrder(nameOfAlcohol, amount);
    }


    //////////// getters & setters ///////////
    public Alcohol[] getAlcohol() {
        return alcohol;
    }

    public Orders[] getOrders() {
        return orders;
    }

    public int getTips() {
        return tips;
    }

    public int getOrdersAmount() {
        return size;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getSize() {
        return size;
    }

    public float getMaxLoad() {
        return maxLoad;
    }

    public int getCurentAlcoholNumber() {
        return curentAlcoholNumber;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }

    public void setOrder(Orders[] orders) {
        this.orders = orders;
    }

    public void setOrderByID(Orders orders, int id) {
        this.orders[id] = orders;
    }


}