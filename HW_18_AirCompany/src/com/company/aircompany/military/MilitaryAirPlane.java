package com.company.aircompany.military;

import com.company.aircompany.Airplane;

/**
 * Created by unike on 15.01.2017.
 */
public abstract class MilitaryAirPlane extends Airplane {

    private boolean stels;


    public MilitaryAirPlane(double MaxFlyRange, double maxSpeed, int numOfPasanger, double maxAltitude, double fuelConsumption, int carrying) {
        super(MaxFlyRange, maxSpeed, numOfPasanger, maxAltitude, fuelConsumption, carrying);
    }
}
