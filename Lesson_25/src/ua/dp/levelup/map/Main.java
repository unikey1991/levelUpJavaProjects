package ua.dp.levelup.map;

import java.util.*;

/**
 * Created by java on 14.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Set<String>> map = new HashMap<>();
        while (scanner.hasNext()){
            String word = scanner.next();
            if (word.equalsIgnoreCase("exit")) break;
//            Integer count = map.get(word);
//            int value = null == count ? 0 : count;
//
//            map.put(word, value + 1);

            Set<String> set = map.get(word.length());

            if (set != null){
                set.add(word);
            } else {
                set = new HashSet<>();
                set.add(word);
                map.put(word.length(), set);
            }
        }

        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()){
            System.out.printf("Value= %s with size %d\n\r", entry.getValue(), entry.getKey());
        }

    }
}
