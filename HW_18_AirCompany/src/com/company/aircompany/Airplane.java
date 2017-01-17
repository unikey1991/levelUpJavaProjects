package com.company.aircompany;

/**
 * Created by unike on 15.01.2017.
 */
public abstract class Airplane {

/*Создать абстрактный класс Самолет и описать в нем общие свойства, которые присущи всем видам самолетов (не менее 5 свойств).
На основе абстрактного класса Самолет описать его абстрактных наследников: Пассажирский Самолет, Грузовой Самолет, Военный Самолет.
Присвоить каждому наследнику уникальное свойство (по желанию их может быть несколько).
На основе каждого вида самолета описать конечный класс наследник (минимум 2 реализации). Предусмотреть возможность установки разных значений свойств
для одной и той же реализации(например одна и та же модель самолета может иметь разные характеристики дальности полета).
*/


    private double MaxFlyRange;
    private double maxSpeed;
    private int numOfPasanger;
    private double maxAltitude;
    private double fuelConsumption;
    private int carrying;

    public Airplane(double MaxFlyRange, double maxSpeed, int numOfPasanger, double maxAltitude, double fuelConsumption, int carrying) {
        this.MaxFlyRange = MaxFlyRange;
        this.maxSpeed = maxSpeed;
        this.numOfPasanger = numOfPasanger;
        this.maxAltitude = maxAltitude;
        this.fuelConsumption = fuelConsumption;
        this.carrying = carrying;
    }

    public double getMaxFlyRange() {
        return MaxFlyRange;
    }

    public void setMaxFlyRange(double maxFlyRange) {
        this.MaxFlyRange = maxFlyRange;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumOfPasanger() {
        return numOfPasanger;
    }

    public void setNumOfPasanger(int numOfPasanger) {
        this.numOfPasanger = numOfPasanger;
    }

    public double getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(double maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "MaxFlyRange=" + MaxFlyRange +
                ", maxSpeed=" + maxSpeed +
                ", numOfPasanger=" + numOfPasanger +
                ", maxAltitude=" + maxAltitude +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
