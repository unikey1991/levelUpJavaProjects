package com.company.aircompany.cargo;

import com.company.aircompany.Airplane;

/**
 * Created by unike on 15.01.2017.
 */
public abstract class CargoAirPlane extends Airplane {


    private int volumeOfCargoCompartment;


    public CargoAirPlane(double MaxFlyRange, double maxSpeed, int numOfPasanger, double maxAltitude, double fuelConsumption, int carrying) {
        super(MaxFlyRange, maxSpeed, numOfPasanger, maxAltitude, fuelConsumption, carrying);
    }
}
