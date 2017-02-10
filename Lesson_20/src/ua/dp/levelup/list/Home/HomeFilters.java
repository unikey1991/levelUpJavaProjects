package ua.dp.levelup.list.Home;

import java.util.Comparator;

/**
 * Created by java on 10.02.2017.
 */
public class HomeFilters {


    public static Comparator<Home> streetComparator(){
        return new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHomeNumber(), h2.getHomeNumber());
                int cityNames =  h1.getCity().compareToIgnoreCase(h2.getCity());

                if (homeNumbers ==0 && cityNames == 0) return 0;
                else if (homeNumbers == 0) return cityNames;
                else return cityNames == 0 ? homeNumbers : cityNames;
            }
        };
    }

    //который будет сортировать дома по количеству жильцов
    public static Comparator<Home> residentsComparator(){
        return new Comparator<Home>() {
            @Override
            public int compare(Home h1, Home h2) {
                int homeNumbers = Integer.compare(h1.getHomeNumber(), h2.getHomeNumber());
                int homeResidents =  Integer.compare(h1.getNumberOfResidents(), h2.getNumberOfResidents());

                if (homeNumbers ==0 && homeResidents == 0) return 0;
                else if (homeNumbers == 0) return homeResidents;
                else return homeResidents == 0 ? homeNumbers : homeResidents;
            }
        };
    }
}
