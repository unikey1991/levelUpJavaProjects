package com.company;

import com.company.Cocktails.Alcohol;
import com.company.Exceptions.DrinkNotFoundException;
import com.company.Exceptions.NegativeTipsException;
import com.company.Exceptions.NotExistBarException;
import com.company.Exceptions.OrderDrinkOverException;
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*1) У бара должен быть метод getDrinkCount, который возвращает кол-во запасов по заданному названию напитка,
    в случае если напиток закончился или не существует необходимо возвращать значение -1.*/

    public int getDrinkCount(String alcoholName){
        for (int i =0; i< curentAlcoholNumber; i++){
            if (alcoholName.equals(alcohol[i].getName())) return alcohol[i].getAmount();
        }
        return -1;
    }

    /*2) У бара необходимо объявить метод getDrinkByName, который вернет объект напитка.
    В случае если напиток неьбыл найден, необходимо возрващать null. Bar*/

    public Alcohol getDrinkByName(String alcoholName){
        for (int i =0; i< curentAlcoholNumber; i++){
            if (alcoholName.equals(alcohol[i].getName())) return alcohol[i];
        }
        return null;
    }

    /*3) При создании нового сотрудника бара необходимо проверять у него принадлежность к бару.
    Тоесть, если объект бара переданный в конструкторе сотрудника окажется null необходимо выбросить исключение NotExistBarException.
    При этом исключение должно информировать о некорректно заданом значении бара. Пример : For creating new employee was passed not.*/

    public void addPersonal(String name, int age, String exclusiveCoctail, String position, Bar bar) throws NotExistBarException {
        if (null == bar) throw new NotExistBarException("For creating new employee was passed not");
        switch (position) {
            case "бармен":
                if (curentBarmansNumber < this.barman.length) {
                    for (int i = 0; i < this.barman.length; i++) {
                        if (this.barman[i] == null) {
                            this.barman[i] = new Barman(name, age, exclusiveCoctail, bar);
                            System.out.println("Grac, " + name + " стал барменом под ид " + i);
                            this.curentBarmansNumber++;
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
                            System.out.println("Grac, " + name + " стал официантом под ид " + i);
                            this.curentWaitersNumber++;
                            break;
                        }
                    }
                } else System.out.println("штат официантов уже заполнен");
                break;
            default:
                System.out.println("неверная должность");
                break;
        }
    }


    public void shareTip() {
        System.out.println(tips + " чаевых поделено на " + curentBarmansNumber + " барменов");
        setTips(0);
    }



    /*6) Добавить в метод получения чаевых, официантом, проверку на положительное значение.
    В случае если значение чаевых было переданно не корректно нужно сгенерировать исключение NegativeTipsException.
    При этом исключение должно информировать о некорректно заданом значении чаевых.
    Пример: Tips couldn't be negative. Passed value is: -25.*/

    public void takeTips(int amount, int waiterId) throws NegativeTipsException {
        if (amount < 0) throw new NegativeTipsException("Tips couldn't negative. Passed value is: "+amount);
        if (null != waiter[waiterId]) waiter[waiterId].takeTips(amount);
        else System.out.println("Not found waiter with id "+waiterId);
    }




    public void delPersonal(String name, String position) {
        switch (position) {
            case "бармен":
                if (curentBarmansNumber > 0) {
                    for (int i = 0; i < barman.length; i++) {
                        if (barman[i] != null && barman[i].getName().equals(name)) {
                            this.barman[i] = null;
                            this.curentBarmansNumber--;
                            System.out.println(name + " уволен(а)");
                            break;
                        }
                    }
                    break;
                } else System.out.println("алло, у нас и так нет барменов!");
                break;
            case "официант":
                if (curentWaitersNumber > 0) {
                    for (int i = 0; i < waiter.length; i++) {
                        if (waiter[i] != null && waiter[i].getName().equals(name)) {
                            this.waiter[i] = null;
                            this.curentWaitersNumber--;
                            System.out.println(name + " уволен(а)");
                            break;
                        }
                    }
                    break;
                } else System.out.println("алло, у нас и так нет барменов!");
                break;
            default:
                System.out.println("неверная должность");
                break;
        }
    }


    public void performeOrder(int barmanId, Bar bar) {
        if (barman[barmanId] != null) barman[barmanId].performOrder();
        else System.out.println("нет барменов под ид " + barmanId);
    }


    /*Метод “пополнить склад” принимает объект с названием напитка и его количеством.
    Если такой напиток существует в баре, то его количество обновляется. Если нет, то добавляется новый объект.*/

    public void fillWarehouse(String alcoholName, int amount, double volume, int cost) {
        for (int i = 0; i < curentAlcoholNumber && curentAlcoholNumber != alcohol.length; i++) {
            if (alcohol[i] != null && alcohol[i].getName().equals(alcoholName)) {
                alcohol[i].setAmount(alcohol[i].getAmount() + amount);
                System.out.println("добавлено " + amount + " бутылок " + alcoholName);
                break;
            }
            if (i == curentAlcoholNumber - 1) {
                alcohol[curentAlcoholNumber++] = new Alcohol(alcoholName, amount, volume, cost);
                System.out.println(alcoholName + " добавлен в бар. " + amount + " бутылок");
                break;
            }
        }
        if (curentAlcoholNumber == 0) {
            alcohol[curentAlcoholNumber++] = new Alcohol(alcoholName, amount, volume, cost);
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


/*После того как бармен выполнил заказ необходимо вычесть заданное кол-во напитков из запаса бара. В случае если запасы закончились нужно удалить напиток из бара.*/
    public void decreaseAlcoholAmount(String name, int amount) {
        for (int i = 0; i < curentAlcoholNumber; i++) {
            if (alcohol[i].getName().equals(name)) {
                alcohol[i].setAmount(alcohol[i].getAmount() - amount);
                if (alcohol[i].getAmount() == 0) {
                    for (int j = i; j < curentAlcoholNumber-1; j++){
                        alcohol[j] = alcohol[j+1];
                    }
                    alcohol[curentAlcoholNumber-1] = null;
                }
            }
        }
    }

    public void addOrder(int waiterID, String nameOfAlcohol, int amount) throws DrinkNotFoundException, OrderDrinkOverException {
        if (waiter[waiterID] != null) waiter[waiterID].addOrder(nameOfAlcohol, amount);
        else System.out.println("нет официантов под ИД " + waiterID);
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

    public int getCurentWaitersNumber() {
        return curentWaitersNumber;
    }

    public int getCurentBarmansNumber() {
        return curentBarmansNumber;
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
