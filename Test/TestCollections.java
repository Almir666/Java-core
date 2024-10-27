package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class TestCollections {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println();

        list.add(666);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Object cloun = list.clone();
        LinkedList<Integer> finalCloun = (LinkedList<Integer>) cloun;

        System.out.println(finalCloun.size());
        System.out.println(finalCloun);
        System.out.println();

        finalCloun.pop();
        System.out.println(list);
        System.out.println(finalCloun);

        list.add(1, null);

        System.out.println(list.size());
        System.out.println(list);
        
        Stack<Integer> steeek = new Stack<>();
        steeek.push(3);
        steeek.push(2);
        steeek.push(4);
        steeek.push(null);
        steeek.push(null);
        steeek.push(34);

        System.out.println(steeek.search(null));
    
        TreeMap<String,Integer> treeMap = new TreeMap<>();

        treeMap.put("First", 1);
        treeMap.put("Second", 2);
        treeMap.put("Last", 3);

        treeMap.replace("First", 4);

        System.out.println(treeMap);


        int index = 118 % (16 -1);

        System.out.println(index);

        Integer result = list.stream().findAny().get();
        System.out.println(result);
        double num = 2.;
        System.out.println(num);
    }
}

