package com.company.DMDSoftSolutions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Company DMDSoftSolutions = new Company("DMDSoft-Solutions");
        DMDSoftSolutions.add("", "design", "0", "Alex", "Taylor", "2000");
        DMDSoftSolutions.add("", "design", "0", "Alex", "Taylor", "2000");
        DMDSoftSolutions.add("", "design", "1", "Alex1", "Taylor1", "2000");
        DMDSoftSolutions.add("", "design", "2", "Alex2", "Taylor2", "2000");
        DMDSoftSolutions.add("", "design", "3", "Alex3", "Taylor3", "2000");
        DMDSoftSolutions.add("", "management", "0", "Alex4", "Taylor3", "2000");
        DMDSoftSolutions.add("", "management", "1", "Alex5", "Taylor3", "2000");
        DMDSoftSolutions.add("", "management", "2", "Alex6", "Taylor3", "2000");
        DMDSoftSolutions.add("", "management", "3", "Alex7", "Taylor3", "2000");
        DMDSoftSolutions.add("", "management", "4", "Alex8", "Taylor3", "2000");
        DMDSoftSolutions.add("", "development", "0", "Alex40", "Taylor3", "2000");
        DMDSoftSolutions.add("", "development", "1", "Alex51", "Taylor3", "2000");
        DMDSoftSolutions.add("", "development", "2", "Alex62", "Taylor3", "2000");
        DMDSoftSolutions.add("", "development", "3", "Alex73", "Taylor3", "2000");
        DMDSoftSolutions.add("", "development", "4", "Alex84", "Taylor3", "2000");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        DMDSoftSolutions.getAll();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("write Help to view commands");

            String line = scanner.nextLine();

            if (line.startsWith("help")) {
                System.out.println("getAll   отобразить список департаментов");
                System.out.println("getIs [department name]   отобразить доступные ид сотрудников департамента");
                System.out.println("get [department name] [employee (id)]   отобразить данные сотрудника");
                System.out.println("add [department name] [employee (id)] [firstName] [lastName] [salary (amount)]   добавить нового сотрудника");
            }

            else if (line.split(" ")[0].equalsIgnoreCase("getAll")) {
                DMDSoftSolutions.getAll();
            }

            else if (line.split(" ")[0].equalsIgnoreCase("add")) {
                if (line.split(" ").length == 6 && line.split(" ")[2].matches("[0-9]+") && line.split(" ")[5].matches("[0-9]+")) {
                    DMDSoftSolutions.add(line.split(" "));
                } else System.out.println("Incorrect parameters for Add");
            }

            else if (line.split(" ")[0].equalsIgnoreCase("getIs")) {
                if (line.split(" ").length == 2) {
                    DMDSoftSolutions.getIs(line.split(" "));
                } else System.out.println("Incorrect parameters for GetIs");
            }

            else if (line.split(" ")[0].equalsIgnoreCase("get")) {
                if (line.split(" ").length == 3 && line.split(" ")[2].matches("[0-9]+")) {
                    DMDSoftSolutions.get(line.split(" "));
                } else System.out.println("Incorrect parameters for Get");
            }

        }




    }
}
