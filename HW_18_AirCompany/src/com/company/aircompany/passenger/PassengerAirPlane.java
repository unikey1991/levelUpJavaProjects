package com.company.aircompany.passenger;

import com.company.aircompany.Airplane;

/**
 * Created by unike on 15.01.2017.
 */
public abstract class PassengerAirPlane extends Airplane {

public boolean haveFirstClass;
public boolean haveEconomClass;
public boolean haveBusinessClass;


    public PassengerAirPlane(double MaxFlyRange, double maxSpeed, int numOfPasanger, double maxAltitude, double fuelConsumption, int carrying) {
        super(MaxFlyRange, maxSpeed, numOfPasanger, maxAltitude, fuelConsumption, carrying);
    }
}
