package com.company.Animal;

/**
 * Created by unike on 07.12.2016.
 */
public class Dog extends Animal {


    String name;


    public Dog(int weigth, int age, String name) {
        super("Dog", 4, weigth, age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void run() {
        System.out.println("Пес "+getName()+" бегает");
    }

    @Override
    void jump() {
        System.out.println("Пес "+getName()+" прыгает");
    }

    @Override
    void barking() {
        System.out.println("Пес "+getName()+" лает");
    }

    @Override
    void bite() {
        System.out.println("Пес "+getName()+" кусается");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dog dog = (Dog) o;

        return name != null ? name.equals(dog.name) : dog.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
