package ua.dp.levelup.list.Home;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import static ua.dp.levelup.list.Home.HomeFilters.residentsComparator;
import static ua.dp.levelup.list.Home.HomeFilters.streetComparator;

/**
 * Created by unike on 09.02.2017.
 */
public class HomeTest {

    @Test
    public void testHashSet(){

        Set<Home> homes = new HashSet<>();
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "qw","asdf",14,90));
        homes.add(new Home(27, "qwe","asdfg",8,90));



        Set<Home> homes1 = new LinkedHashSet<>();
        homes1.add(new Home(27, "Harkov","Glinki",3,100));
        homes1.add(new Home(27, "Kiev","Harkovska",2,60));

        homes1.add(new Home(12, "Dnepr","Krasna",6,124));
        homes1.add(new Home(24, "Dnepr","Krasna",22,21));

        homes1.add(new Home(276, "Dneprodim","as",9,362));
        homes1.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes1.add(new Home(27, "qw","asdf",14,90));
        homes1.add(new Home(27, "qwe","asdfg",8,90));


        Set<Home> homes2 = new TreeSet<>(residentsComparator());
        homes2.add(new Home(27, "Harkov","Glinki",3,100));
        homes2.add(new Home(27, "Kiev","Harkovska",2,60));

        homes2.add(new Home(12, "Dnepr","Krasna",6,124));
        homes2.add(new Home(13, "Dnepr","Krasna",22,21));

        homes2.add(new Home(276, "Dneprodim","as",9,362));
        homes2.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes2.add(new Home(27, "ab","asdf",14,90));
        homes2.add(new Home(27, "bfg","asdfg",8,90));
        homes2.add(new Home(27, "cfg","asdfgf",9,89));
        homes2.add(new Home(27, "dsg","asdfgfg",10,79));

        //System.out.println(homes2);

        for (Home h : homes2){
            System.out.println(h.getHomeNumber()+" "+h.getCity()+" "+h.getStreet()+" "+h.getNumberOfFloors()+" "+h.getNumberOfResidents());
        }




    }

}