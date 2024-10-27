package MultiThreads;


public class SynchronizedBlockEx {
    // Создаем объект класса Object как объект по которому мы будем синхронизироваться
    static final Object lock = new Object();

    // Здесь мы видим пример работы синхронизированного блока который синхронизируется по одному объекту
    void mobileCall() {
        // в параметр synchronized передаем наш объхект по которому должна быть синхронизация
        synchronized(lock) {
        System.out.println("Mobile call start");
        try {
        Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mobile call end");
    }
}
    // Все эти три метода будут синхронизироватьяс по объекту lock
    void telegramCall() {
        synchronized(lock) {
        System.out.println("Telegram call start");
        try {
        Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Telegram call end");
    }
}
    // Тогда их работа будет синхронной
    void whatsappCall() {
        synchronized(lock) {
        System.out.println("WhatsApp call start");
        try {
        Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WhatsApp call end");
    }
}
    public static void main(String[] args) {
        // MyRunnableSynch runnable = new MyRunnableSynch();
        // Thread thr1 = new Thread(runnable);
        // Thread thr2 = new Thread(runnable);
        // Thread thr3 = new Thread(runnable);
        // thr1.start();
        // thr2.start();
        // thr3.start();
        System.out.println("------------------------------------");

        // теперь наши потоки синхронизированы по одному классу и все будет выполняться последовательно
        // что нам и требуется
        Thread mThread1 = new Thread(new RunnableImplMobile());
        Thread mThread2 = new Thread(new RunnableImplTelegram());
        Thread mThread3 = new Thread(new RunnableImplWhatsApp());
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }
}

class Counter {
    volatile static int counter = 0;
}

class MyRunnableSynch implements Runnable {
    public void doWork() {
        // Синхронизированный блок, в synchronized передаем параметр ссылку на наш обьект чей монитор мы будем использовать
        // Если мы передаем ссылку на дркугой объект то после него ставим .class(SynchronizedBlockEx.class)
        synchronized(this) {
            Counter.counter++;
            System.out.print(Counter.counter + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork();
        }        
    }
}

// Создаем классы которые будут имплементировать раннабл и в них вызываем наши методы звонков
class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new SynchronizedBlockEx().mobileCall();
    }
}
class RunnableImplTelegram implements Runnable {
    @Override
    public void run() {
        new SynchronizedBlockEx().telegramCall();
    }
}
class RunnableImplWhatsApp implements Runnable {
    @Override
    public void run() {
        new SynchronizedBlockEx().whatsappCall();
    }
}


