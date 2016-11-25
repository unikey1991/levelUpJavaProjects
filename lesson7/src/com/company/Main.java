package com.company;

public class Main {

    public static void main(String[] args) {
	int a = 2 + 2;
        switch (a) {
            case 3: System.out.println("malovato"); break;
            case 4: System.out.println("v tochku"); break;
            case 5: System.out.println("dofiga"); break;
            default: System.out.println("4et ne to");
        }

        int dayNumber = 1;
        String a1 = null;
        switch (dayNumber){
            case 1: a1 = "понедельник"; break;
            case 2: a1 = "вт"; break;
            case 3: a1 = "ср"; break;
            case 4: a1 = "чт"; break;
            case 5: a1 = "пт"; break;
            case 6: a1 = "сб"; break;
            case 7: a1 = "вс"; break;
            default:System.out.println("ne to");
        }
        System.out.println(a1);

        int numOfCard = 1;
        String a2 = null;
        switch (numOfCard){
            case 1: a2 = "piki"; break;
            case 2: a2 = "masti"; break;
            case 3: a2 = "bybni"; break;
            case 4: a2 = "chervi"; break;
            default:System.out.println("ne to");
        }
        System.out.println(a2);
        String email = "denis.kivalov@gmail.com";
        System.out.println(email.length());
        System.out.println(email.indexOf("@"));
        System.out.println(email.substring(0,email.indexOf("@")));

        System.out.println(email.toCharArray());

        System.out.println(email.replace('d','p'));

        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }

        






    }

}
