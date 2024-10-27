package MultiThreads;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        // Просто заменяем HashMap на ConcurrentHashMap и наши потоки смогут спокойно работать с коллекцией
        // если бы мы оставили просто HashMap то ловили бы ConcurrentModificationException
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + ": " + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
            map.put(6, "Six");
        };

        Thread thr1 = new Thread(runnable1);
        Thread thr2 = new Thread(runnable2);
        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();
        System.out.println(map);

        Enumeration<String> list = map.elements();
        
        for(int i = 0; i < 5; i++) {
            System.out.println(list.nextElement());
        }

        System.out.println(map.mappingCount());

        Collection<String> values = map.values();
        Object[] result = values.toArray();

        System.out.println("--------------");

        for(int i = 0; i < 5; i++) {
            System.out.println(result[i]);
        }
    }
}
