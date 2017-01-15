package com.company;

import com.company.aircompany.AirCompany;
import com.company.aircompany.Airplane;
import com.company.aircompany.cargo.Airbus_A380;
import com.company.aircompany.cargo.Ан_225;
import com.company.aircompany.military.Boeing_F_A_18E_F_SuperHornet;
import com.company.aircompany.military.Eurofighter_Typhoon;
import com.company.aircompany.passenger.Airbus_A319;
import com.company.aircompany.passenger.Boeing_747;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Airplane[] airplanes = {new Airbus_A380(2000,700, 10, 7000, 40,500),
                new Airbus_A319(2450,752, 64, 4801, 56,500),
                new Boeing_747(2417,507, 123, 6408, 140,500),
                new Eurofighter_Typhoon(2137,1200, 2, 9404, 47,500),
                new Boeing_F_A_18E_F_SuperHornet(904,700, 24, 8045, 70,500),
                new Ан_225(2768,307, 30, 7000, 150,500),
                new Airbus_A380(1075,704, 12, 5607, 43,500),
                new Airbus_A380(1806,700, 45, 5954, 41,500),
                new Boeing_747(4576,647, 145, 7406, 86,500),
                new Boeing_F_A_18E_F_SuperHornet(8504,4, 70, 12075, 34,500),
                new Airbus_A319(4505,600, 45, 5670, 47,500),
                new Airbus_A380(6754,700, 17, 5940, 46,500)};


        AirCompany airCompany = new AirCompany(airplanes);

        System.out.println("Total passengers: "+airCompany.calculateAirplaneMaxNumberOfPassenegers());
        System.out.println(Arrays.toString(airCompany.sortByMaxFlyRange()));
        System.out.println(Arrays.toString(airCompany.getAirplanesByFuelConsumptionRange(50,100)));

    }



}
