package com.company.DMDSoftSolutions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Company DMDSoftSolutions = new Company("DMDSoft-Solutions");
        DMDSoftSolutions.add("design", "0", "Alex", "Taylor", "2000");
        DMDSoftSolutions.add("design", "0", "Alex", "Taylor", "2000");
        DMDSoftSolutions.add("design", "1", "Alex1", "Taylor1", "2000");
        DMDSoftSolutions.add("design", "2", "Alex2", "Taylor2", "2000");
        DMDSoftSolutions.add("design", "3", "Alex3", "Taylor3", "2000");
        DMDSoftSolutions.add("management", "0", "Alex4", "Taylor3", "2000");
        DMDSoftSolutions.add("management", "1", "Alex5", "Taylor3", "2000");
        DMDSoftSolutions.add("management", "2", "Alex6", "Taylor3", "2000");
        DMDSoftSolutions.add("management", "3", "Alex7", "Taylor3", "2000");
        DMDSoftSolutions.add("management", "4", "Alex8", "Taylor3", "2000");
        DMDSoftSolutions.add("development", "0", "Alex40", "Taylor3", "2000");
        DMDSoftSolutions.add("development", "1", "Alex51", "Taylor3", "2000");
        DMDSoftSolutions.add("development", "2", "Alex62", "Taylor3", "2000");
        DMDSoftSolutions.add("development", "3", "Alex73", "Taylor3", "2000");
        DMDSoftSolutions.add("development", "4", "Alex84", "Taylor3", "2000");

        DMDSoftSolutions.get("af",0);
        DMDSoftSolutions.get("design",90);
        DMDSoftSolutions.get("design",1);

        DMDSoftSolutions.getIs("design");
        DMDSoftSolutions.getIs("management");
        DMDSoftSolutions.getIs("development");

        DMDSoftSolutions.getAll();

        Scanner scanner = new Scanner(System.in);

        while (true){
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) break;

            if (line.startsWith("add")){
                DMDSoftSolutions.add(line.split(" "));
            }
        }
    }
}
