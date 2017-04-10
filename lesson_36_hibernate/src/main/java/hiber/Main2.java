package hiber;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by unike on 09.04.2017.
 */
public class Main2 {

    public static void main(String[] args) {


        LinkedList<String> res = new LinkedList<>();
        res.add("misha");
        res.add("sergey");
        res.add("Valera");
        res.add("georgiy");
        res.add("alexey");
        res.add("Alexand");
        res.add("dimitriy");
        res.add("nikita");
        res.add("Nikitka");
        res.add("ioan");
        res.add("jacob");


        LinkedList<String> asdfasf = sort(res);
        System.out.println(asdfasf.toString());


    }


    public static LinkedList<String> sort(LinkedList<String> list) {
        LinkedList<String> result = new LinkedList<>();
        while (list.size()>0) {
            String tmp = list.get(0);
            for (int i = 1; i <= list.size()-1; i++) {
                if (list.size() < 2) break;
                for (int j = 0; j < list.get(i).toCharArray().length && j < tmp.toCharArray().length; j++) {
                    if (tmp.toLowerCase().toCharArray()[j] < list.get(i).toLowerCase().toCharArray()[j]) break;
                    if (tmp.toLowerCase().toCharArray()[j] == list.get(i).toLowerCase().toCharArray()[j]) continue;
                    if (tmp.toLowerCase().toCharArray()[j] > list.get(i).toLowerCase().toCharArray()[j]) tmp = list.get(i);
                }
            }
            result.add(tmp);
            list.remove(tmp);
        }
        return result;
    }
}
