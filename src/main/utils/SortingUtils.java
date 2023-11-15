package main.utils;

import java.util.*;

public class SortingUtils {
    public static HashMap<Integer, Float> sortByValue(HashMap<Integer, Float> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Float> > list =
                new LinkedList<Map.Entry<Integer, Float> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Float> >() {
            public int compare(Map.Entry<Integer, Float> o1,
                               Map.Entry<Integer, Float> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap 
        HashMap<Integer, Float> temp = new LinkedHashMap<Integer, Float>();
        for (Map.Entry<Integer, Float> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
