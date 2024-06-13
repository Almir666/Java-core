package MultiThreads;

public class SynchronizedEx {
    static int counter = 0;
    // Ключевое слово synchronized позволяет потокам работать с переменной синхронно(последовательно)
    public static synchronized void increment() {
        counter++;
    } 
    
    public static void main(String[] args) throws InterruptedException{
        Thread thr1 = new Thread(new R());
        Thread thr2 = new Thread(new R());
        Thread thr3 = new Thread(new R());

        thr1.start();
        thr2.start();
        thr3.start();
        thr1.join();
        thr2.join();
        thr3.join();
        System.out.println(SynchronizedEx.counter);
    }
}


class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynchronizedEx.increment();
        }
    }
}