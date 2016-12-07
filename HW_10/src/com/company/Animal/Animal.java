package com.company.Animal;

/**
 * Created by unike on 07.12.2016.
 */
public class Animal {
    String type;
    int numOfLegs;
    int weigth;
    int age;

    void run(){}

    void jump(){}

    void barking(){}

    void bite (){}

    public Animal(String type, int numOfLegs, int weigth, int age) {
        this.type = type;
        this.numOfLegs = numOfLegs;
        this.weigth = weigth;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (numOfLegs != animal.numOfLegs) return false;
        if (weigth != animal.weigth) return false;
        if (age != animal.age) return false;
        return type != null ? type.equals(animal.type) : animal.type == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + numOfLegs;
        result = 31 * result + weigth;
        result = 31 * result + age;
        return result;
    }
}


