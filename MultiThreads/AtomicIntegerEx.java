package MultiThreads;

import java.util.concurrent.atomic.AtomicInteger;

// AtomicInteger это класс позволяющий проводить атомарные операции с int

public class AtomicIntegerEx {
    // Передаем в параметры new AtomicInteger значение, по умолчанию оно равно 0
    static AtomicInteger count = new AtomicInteger(0);

    // Тут мы могли бы сделать метод synchronized но альтернативный вариант просто использовать AtomicInteger
    // вроде как он менее затратный по ресурсам
    public static void increment() {
        // incrementAndGet() увеличивает инкремент на 1 и возвращает его
        count.incrementAndGet();
        // addAndGet() увеличивает число на заданное в параметре значение
        // если ввести отрицательное значение то число из параметра будет вычетаться
        count.addAndGet(2);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thr1 = new Thread(new MyRunnable333());
        Thread thr2 = new Thread(new MyRunnable333());
        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();
        System.out.println(count);
    }
}

class MyRunnable333 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            AtomicIntegerEx.increment();
        } 
    }
}