package MultiThreads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class LockReentrantLock {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.MobileCall();
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.WhatsAppCall();
            }
        });

        Thread thr3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.TelegramCall();
            }
        });

        thr1.start();
        thr2.start();
        thr3.start();
    }
}

class Call {
    // ReentrantLock() работает так же как synchronized но его нужно всегда закрывать с блоке finally
    private Lock lock = new ReentrantLock();

    void MobileCall() {
        lock.lock();
        try {
            System.out.println("Mobile call start");
            Thread.sleep(3000);
            System.out.println("Mobile call end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // unlock() всегда нужно писать в блоке файнали для того что бы поток обязательно закрылся что бы не случилось
        finally {
            lock.unlock();
        }
    }

    void WhatsAppCall() {
        lock.lock();
        try {
            System.out.println("Whats app call start");
            Thread.sleep(4000);
            System.out.println("Whats app call end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    void TelegramCall() {
        lock.lock();
        try {
            System.out.println("Telegram call start");
            Thread.sleep(5000);
            System.out.println("Telegram app call end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}