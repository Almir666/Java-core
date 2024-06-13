package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// ExecutorService это класс для работы с пуллом потоков

public class ExecutorEx1 {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("main поток запущен");
        // Потоки рекомендуется создавать через ExecutorService например можно создать через метод newFixedThreadPool класса Executors
        // он может создавать фиксированное количество потоков
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // Метод execute() передает задание в thread pool где оно выполняется одним из потоков
            executorService.execute(new Runnable666());
        }
        // после выполнения метода sutdown() thread pool понимает что новых заданий не будет, и выполнив оставшиеся задания завершит работу 
        // без этого метода программа не завершится
        executorService.shutdown();
        // awaitTermination() похож на метод join(), он будет ждать указанное в параметрах время либо пока екзекьюторсервис не закончит свою работу
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("main поток завершен");

    }
}

class Runnable666 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}