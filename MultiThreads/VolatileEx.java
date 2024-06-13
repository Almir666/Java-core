package MultiThreads;

public class VolatileEx extends Thread {
    // ключевое слово volatile оболзначает что значение переменной будет хранитсья не в кеше а в main memory по этому
    // потоки смогут с ней корректно работать
    // volatile справится со своей задачей только тогда когда тоолько один поток может менять значние переменной
    // остальные могут тоолько читать
    volatile boolean b = true;
    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Counter: " + counter);
    }
    public static void main(String[] args) throws InterruptedException{
        VolatileEx thread = new VolatileEx();
        System.out.println("Спим 2 секунды");
        thread.start();
        Thread.sleep(2000);
        thread.b = false;
        thread.join();
        System.out.println("End");
    }
}
