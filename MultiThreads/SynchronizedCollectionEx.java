package MultiThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Synchronized collections это обычные колекции котрые мы оборачиваем специальной оберткой позволяющей
// синхронизировать нашу колекцию(synchronized view)

public class SynchronizedCollectionEx {
    public static void main(String[] args) throws InterruptedException {
        // Ex1 --------------------------------------------------------------------------------------
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            source.add(i);
        }

        // Collections.synchronizedList это такой же List как из пакета util только синхронизированый
        // в него мы передаем ArrayList()<>
        List<Integer> synchList = Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> {synchList.addAll(source);};

        Thread thr1 = new Thread(runnable);
        Thread thr2 = new Thread(runnable);

        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();
        System.out.println(synchList);
        // Ex1 ----------------------------------------------------------------------------------------

        //Ex2 -----------------------------------------------------------------------------------------

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add(i);
        }

        List<Integer> synchronizedArr = Collections.synchronizedList(arr);

        Runnable run1 = () -> {
            // В этом примере мы используем итератор
            // Важно запомнить что при использовании итератора нужно оборачивать его в синхронизированный блок!
            // иначе будет вылетать Exception
            synchronized(synchronizedArr) {
            Iterator<Integer> iterator = synchronizedArr.iterator();
            while(iterator.hasNext()) {
            System.out.println(iterator.next());
            }
        }
        };
        Runnable run2 = () -> synchronizedArr.remove(10);

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizedArr);
    }
}
