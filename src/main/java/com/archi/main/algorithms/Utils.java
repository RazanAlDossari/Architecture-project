package com.archi.main.algorithms;

import com.archi.main.algorithms.data_model.QualityAttributePair;

import java.util.*;

public class Utils {


    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }

    public abstract class ListGroupBy<K, T> {

        public Map<K, List<T>> map(List<T> list) {
            Map<K, List<T> > map = new HashMap<K, List<T> >();
            for (T t : list) {
                K key = groupBy(t);
                List<T> innerList = map.containsKey(key) ? map.get(key) : new ArrayList<T>();
                innerList.add(t);
                map.put(key, innerList);
            }
            return map;
        }

        protected abstract K groupBy(T t);
    }

    public static List<QualityAttributePair> removeDuplicatesFromList(List<QualityAttributePair> qaList){
        Map<String, QualityAttributePair> map = new HashMap<String, QualityAttributePair>();
        List<QualityAttributePair> newQAList = new ArrayList<>();
        for(QualityAttributePair p:qaList){
            map.put(p.getQualityAttributeA(),p);
        }
        Iterator itr=map.keySet().iterator();
        while (itr.hasNext()) {
            String id =  itr.next().toString();
            newQAList.add((QualityAttributePair)map.get(id));
        }
        return newQAList;
    }
}