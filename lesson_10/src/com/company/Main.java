package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {



Country country1 = new Country("Ukraine",5);
Country country2 = new Country("Ukraine",5);

        System.out.println(country1.equals(country2));
        System.out.println(country1 == country2);



    }
}