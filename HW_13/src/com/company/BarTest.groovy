package com.company

/**
 * Created by unike on 19.12.2016.
 */
class BarTest extends spock.lang.Specification {
    def "add&del barmen & waiter & return correct sum of personal of both types"() {
        given: "initialize bar"
        Bar bar = new Bar("123");

        when: "try to add one barman"
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)

        then: "check current array size"
        bar.getCurentBarmansNumber() == 1

        when: "try to add one waiter"
        bar.addPersonal("july", 23, "null", "официант", bar)

        then: "check current array size"
        bar.getCurentWaitersNumber() == 1

        when: "try to add more personal and return correct personal sum"
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("sergio", 21, "aa", "бармен", bar)
        bar.addPersonal("july", 23, "null", "официант", bar)
        bar.addPersonal("july", 23, "null", "официант", bar)
        bar.addPersonal("july", 23, "null", "официант", bar)
        bar.addPersonal("july", 23, "null", "официант", bar)

        then: "check current array size"
        bar.getCurentWaitersNumber() == 3
        bar.getCurentBarmansNumber() == 5

        when: "dell 2 barman & 1 waiter & return correct personal sum"
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("july", "официант")

        then: "check current arrays size"
        bar.getCurentBarmansNumber() == 3
        bar.getCurentWaitersNumber() == 2

        when: "dell personal more than exist & return correct personal sum"
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("sergio", "бармен")
        bar.delPersonal("july", "официант")
        bar.delPersonal("july", "официант")
        bar.delPersonal("july", "официант")

        then: "check current arrays size"
        bar.getCurentBarmansNumber() == 0;
        bar.getCurentBarmansNumber() == 0;

    }


    def "Take Tips & then Share tip may return correct string"() {
        given: "initialize bar & add waiter & barman"
        Bar bar = new Bar("123");
        bar.addPersonal("abc",1,"abc","официант", bar)
        bar.addPersonal("abcabc",1,"abcabc","бармен", bar)

        when: "take tips by waiter and check correct sum of tips"
        bar.takeTips(100, 0);

        then: "return correct tips sum"
        bar.getTips() == 100;

        when: "take more tips and check correct sum of tips"
        bar.takeTips(100, 0);
        bar.takeTips(100, 0);
        bar.takeTips(100, 0);

        then: "return correct tips sum"
        bar.getTips() == 400;

        when: "share tips & check tips sum"
        bar.shareTip();

        then: "return correct tips sum"
        bar.getTips() == 0;

    }


    def "FillWarehouse"() {

        given: "initialize bar & add waiter & barman"
        Bar bar = new Bar("123");

        when: "add alcohol and check correct array fill and amount"
        bar.fillWarehouse("pivo",5);
        bar.fillWarehouse("pivo",10);

        then: "return correct tips sum"
        bar.alcohol[0].amount == 15;
        bar.alcohol[0].name == "pivo";
        bar.alcohol[1] == null;

        when: "add new alcohol and check correct array fill and amount"
        bar.fillWarehouse("vino", 500)
        bar.fillWarehouse("vodka", 501)

        then: "return correct amount sum & check curentAlcoholNumber"
        bar.alcohol[0].amount == 15;
        bar.alcohol[0].name == "pivo";
        bar.alcohol[1].amount == 500;
        bar.alcohol[1].name == "vino";
        bar.alcohol[2].amount == 501;
        bar.alcohol[2].name == "vodka";
        bar.alcohol[3] == null;
        bar.curentAlcoholNumber == 3;

        when: "overfill alcohol without exceptions"
        for (int i = 1; i < bar.alcohol.length+1; i++){
            bar.fillWarehouse("a"+i,1);
        }

        then: "check array of alcohol has'n null & check curentAlcoholNumber"
        for (int i = 0; i < bar.alcohol.length; i++){
            bar.alcohol[i] != null;
        }
        bar.curentAlcoholNumber == 10;

    }

    def "AddOrder"() {
        given: "initialize bar & add waiter & barman"
        Bar bar = new Bar("123");
        bar.addPersonal("abc",1,"abc","официант", bar)
        bar.addPersonal("abcabc",1,"abcabc","бармен", bar)
        bar.fillWarehouse("pivo", 100)
        bar.fillWarehouse("vodka", 100)

        when: "add 2 order and perform 1 of it"
        bar.addOrder(0, "pivo", 1)
        bar.addOrder(0, "vodka", 2)
        bar.performeOrder(0,bar)

        then: "check array of order and alcohol amount"
        bar.orders[0].amount == 2
        bar.orders[0].title == "vodka"
        bar.orders[1] == null


    }




}
