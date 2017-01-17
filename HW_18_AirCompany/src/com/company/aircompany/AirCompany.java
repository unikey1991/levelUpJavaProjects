package com.company.aircompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by unike on 15.01.2017.
 */

/*Создать класс Авиакомпании.
Описать в нем метод подсчета общей вместимости и грузоподъемности.
Описать метод сортировки самолетов компании по дальности полета.
Описать метод поиска самолетов по заданному диапазону параметров расхода топлива.
*/
public class AirCompany {

    private Airplane[] airplanes;

    public AirCompany(Airplane[] airplanes){this.airplanes = airplanes;}

    public int calculateAirplaneCarrying(){
        int totalCarrying = 0;

        for (Airplane a: airplanes){
            totalCarrying += a.getCarrying();
        }
        return totalCarrying;
    }

    public int calculateAirplaneMaxNumberOfPassenegers(){
        int totalNumOfPassengers = 0;

        for (Airplane a:airplanes) {
            totalNumOfPassengers += a.getNumOfPasanger();
        }
        return totalNumOfPassengers;
    }

    public Airplane[] sortByMaxFlyRange(){
        Airplane[] airpln = new Airplane[airplanes.length];
        System.arraycopy(airplanes, 0,airpln, 0, airplanes.length);
        Arrays.sort(airpln, new Comparator<Airplane>() {
            @Override
            public int compare(Airplane o1, Airplane o2) {
                return Double.compare(o1.getMaxFlyRange(), o2.getMaxFlyRange());
            }
        });
        return airpln;
    }

    public Airplane[] getAirplanesByFuelConsumptionRange(int from, int to){
        List<Airplane> airList = new ArrayList<>();
        for (Airplane a:airplanes) {
            if (a.getFuelConsumption() <= to && a.getFuelConsumption() >= from){
                airList.add(a);
            }
        }
        return airList.toArray(new Airplane[1]);
    }


}
