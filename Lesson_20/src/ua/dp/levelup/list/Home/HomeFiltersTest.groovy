package ua.dp.levelup.list.Home

import spock.lang.Specification

import static ua.dp.levelup.list.Home.HomeFilters.cityComparator
import static ua.dp.levelup.list.Home.HomeFilters.homeNumberComparator
import static ua.dp.levelup.list.Home.HomeFilters.residentsComparator

/**
 * Created by unike on 13.02.2017.
 */
class HomeFiltersTest extends Specification {

    def "HashSet"() {

        given: "create new hash set"
        Set<Home> homes = new HashSet<>();


        when: "add new homes to hashSet"
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "Harkov","Glinki",14,90));
        homes.add(new Home(28, "Harkov","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));

        then: "check size"
        homes.size() == 8


    }

    def "LinkedHashSet "() {
        given: "create new linkedHashSet"
        Set<Home> homes = new LinkedHashSet<>();


        when: "add new homes to hashSet"
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "Harkov","Glinki",14,90));
        homes.add(new Home(28, "Harkov","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));

        then: "check size"
        homes.size() == 8
    }

    def "TreeSet CityComparator"() {

        given: "create new treeSet"
        Set<Home> homes = new TreeSet<>(cityComparator());


        when: "add new homes to hashSet"
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "Harkov","Glinki",14,90));
        homes.add(new Home(28, "Harkov","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));

        then: "check size"
        homes.size() == 8
        homes.toString() == "[Home{homeNumber=12, city='Dnepr', street='Krasna', numberOfFloors=6, numberOfResidents=124}\n" +
                ", Home{homeNumber=27, city='Dnepr', street='Glinki', numberOfFloors=8, numberOfResidents=90}\n" +
                ", Home{homeNumber=42, city='Dnepr', street='Krasna', numberOfFloors=22, numberOfResidents=21}\n" +
                ", Home{homeNumber=276, city='Dneprodim', street='as', numberOfFloors=9, numberOfResidents=362}\n" +
                ", Home{homeNumber=27, city='Harkov', street='Glinki', numberOfFloors=3, numberOfResidents=100}\n" +
                ", Home{homeNumber=28, city='Harkov', street='Glinki', numberOfFloors=8, numberOfResidents=90}\n" +
                ", Home{homeNumber=27, city='Kiev', street='Harkovska', numberOfFloors=2, numberOfResidents=60}\n" +
                ", Home{homeNumber=212, city='Novomoskovsk', street='asd', numberOfFloors=9, numberOfResidents=235}\n" +
                "]"


    }


    def "TreeSet HomeNumberComparator"() {

        given: "create new treeSet"
        Set<Home> homes = new TreeSet<>(homeNumberComparator());


        when: "add new homes to hashSet"
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "Harkov","Glinki",14,90));
        homes.add(new Home(28, "Harkov","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));

        then: "check size"
        homes.size() == 8
        homes.toString() == "[Home{homeNumber=12, city='Dnepr', street='Krasna', numberOfFloors=6, numberOfResidents=124}\n" +
                ", Home{homeNumber=27, city='Dnepr', street='Glinki', numberOfFloors=8, numberOfResidents=90}\n" +
                ", Home{homeNumber=27, city='Harkov', street='Glinki', numberOfFloors=3, numberOfResidents=100}\n" +
                ", Home{homeNumber=27, city='Kiev', street='Harkovska', numberOfFloors=2, numberOfResidents=60}\n" +
                ", Home{homeNumber=28, city='Harkov', street='Glinki', numberOfFloors=8, numberOfResidents=90}\n" +
                ", Home{homeNumber=42, city='Dnepr', street='Krasna', numberOfFloors=22, numberOfResidents=21}\n" +
                ", Home{homeNumber=212, city='Novomoskovsk', street='asd', numberOfFloors=9, numberOfResidents=235}\n" +
                ", Home{homeNumber=276, city='Dneprodim', street='as', numberOfFloors=9, numberOfResidents=362}\n" +
                "]"
    }

    def "TreeSet ResidentsComparator"() {

        given: "create new treeSet"
        Set<Home> homes = new TreeSet<>(residentsComparator());


        when: "add new homes to hashSet"
        homes.add(new Home(27, "Harkov","Glinki",3,100));
        homes.add(new Home(27, "Kiev","Harkovska",2,60));

        homes.add(new Home(12, "Dnepr","Krasna",6,124));
        homes.add(new Home(42, "Dnepr","Krasna",22,21));

        homes.add(new Home(276, "Dneprodim","as",9,362));
        homes.add(new Home(212, "Novomoskovsk","asd",9,235));

        homes.add(new Home(27, "Harkov","Glinki",14,90));
        homes.add(new Home(28, "Harkov","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));
        homes.add(new Home(27, "Dnepr","Glinki",8,90));

        then: "check size"
        homes.size() == 8
        homes.toString() == "[Home{homeNumber=42, city='Dnepr', street='Krasna', numberOfFloors=22, numberOfResidents=21}\n" +
                ", Home{homeNumber=27, city='Kiev', street='Harkovska', numberOfFloors=2, numberOfResidents=60}\n" +
                ", Home{homeNumber=27, city='Harkov', street='Glinki', numberOfFloors=14, numberOfResidents=90}\n" +
                ", Home{homeNumber=28, city='Harkov', street='Glinki', numberOfFloors=8, numberOfResidents=90}\n" +
                ", Home{homeNumber=27, city='Harkov', street='Glinki', numberOfFloors=3, numberOfResidents=100}\n" +
                ", Home{homeNumber=12, city='Dnepr', street='Krasna', numberOfFloors=6, numberOfResidents=124}\n" +
                ", Home{homeNumber=212, city='Novomoskovsk', street='asd', numberOfFloors=9, numberOfResidents=235}\n" +
                ", Home{homeNumber=276, city='Dneprodim', street='as', numberOfFloors=9, numberOfResidents=362}\n" +
                "]"
    }
}
