package MultiThreads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {
        // Это синхронизированный ArrayList
        // Он создает копию для работы при каждой операции изменения
        // по этому его лучше использоват ьесли требуется синхронизация ArrayList при не больших 
        // количествах изменений и больших количествах чтения 
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("Six");
        };

        Thread thr1 = new Thread(runnable1);
        Thread thr2 = new Thread(runnable2);
        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();
        System.out.println(list);
    }
}
