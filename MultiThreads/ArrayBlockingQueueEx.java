package MultiThreads;

import java.util.concurrent.ArrayBlockingQueue;

// ArrayBlockingQueue это потокобезопасная очередь с ограниченым размером
// обычно одни потоки добавляют элементы в конец очереди а другие извлекают их из конца 
// в нашем примере мы будем добавлять числа в очередь размером 4 и сразу же извлекать 

public class ArrayBlockingQueueEx {
    public static void main(String[] args) {
        // Для синхронизированной очереди нужно указывать размерность
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);


        // Producer
        // продюсер будет добавлять число в очередь каджые 3 секунды
        new Thread( () -> {
            int i = 0;
            while (true) {
                try {
                    // put() добавляет элемент в конец очереди
                    // если очередь полная то он будет ждать освобождения очереди
                    queue.put(++i);
                    System.out.println("Producer добавил число: " + i + " " + queue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();;

        // Consumer
        // консумер будет извлекать число из очереди каждые 9 секунд
        new Thread( () -> {
            while (true) {
                try {
                    // take() извлекает первый элемент из очереди
                    // если очередь пустая он будет ждат ьпоявления элемента в очереди и потом извлекать
                    Integer j = queue.take();
                    System.out.println("Consumer извлек число: " + j + " " + queue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
