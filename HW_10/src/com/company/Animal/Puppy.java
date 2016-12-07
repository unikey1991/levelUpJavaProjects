package com.company.Animal;

/**
 * Created by unike on 07.12.2016.
 */
public class Puppy extends Dog {

    int ageMonth;


    public Puppy(int weigth, String name, int ageMonth) {
        super(weigth, 0, name);
        this.ageMonth = ageMonth;
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Puppy puppy = (Puppy) o;

        return ageMonth == puppy.ageMonth;
    }



    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ageMonth;
        return result;
    }


    @Override
    public void run() {
        System.out.println("Щенок "+getName()+" бегает");
    }

    @Override
    public void jump() {
        System.out.println("Щенок "+getName()+" прыгает");
    }

    @Override
    public void barking() {
        System.out.println("Щенок "+getName()+" лает");
    }

    @Override
    public void bite() {
        System.out.println("Щенок "+getName()+" кусается");
    }
}
