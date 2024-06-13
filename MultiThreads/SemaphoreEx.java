package MultiThreads;

// Semaphore это синхронизатор, позволяющий ограничить доступ к ресурсу.
// В его конструктор мы передаем количество потоков, которым Semaphore будет разрешать
// одновременно использовать этот ресурс.

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Лука", callBox);
        new Person("Георгий", callBox);
        new Person("Рузанна", callBox);
        new Person("Александр", callBox);
        new Person("Артем", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore semaphore;

    public Person (String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start();
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " ждет доступ к телефону...");
            // Метод acquire() пытается получить разрешение у Semaphore, он блокирует поток до тех пора пока ресурс не станет доступен
            // после получения доступа счетчик Semaphore уменьшается на 1
            semaphore.acquire();
            System.out.println(name + " получил(а) доступ к телефону.");
            sleep(3000);
            System.out.println(name + " завершил(а) звонок.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Метод release() освобождает разрешение у Semaphore и каунт разрешений увеличивается на 1 
            // release() обязательно пишем в блоке finally потому что если произойдет Exception нам необходимо будет освободить доступ к ресурсу
            semaphore.release();
        }
    }

}