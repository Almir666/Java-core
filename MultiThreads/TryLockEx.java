package MultiThreads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

// Здесь мы рассматриваем метод у класса Lock - tryLock()
public class TryLockEx {
    public static void main(String[] args) throws InterruptedException{
        Lock lock = new ReentrantLock();
        new UserBankomat("Лука", lock);
        new UserBankomat("Георгий", lock);
        new UserBankomat("Евгений", lock);
        Thread.sleep(3000);
        new UserBankomat("Артем", lock);
        new UserBankomat("Александр", lock);
        
    }
}

class UserBankomat extends Thread {
    String name;
    private Lock lock;

    public UserBankomat (String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        // tryLock() возвращает boolean так что будем использовать его в блоке иф элс
        // Трай лок работает так: если монитор свободен и поток захватил его то выполняется тот код который мы пытаемся выполнить
        // если же поток закрыт то мы выполняем другой код
        if(lock.tryLock()) {
            // основной код выполнения 
        try {
            System.out.println(name + " занял(а) банкомат");
            Thread.sleep(3000);
            System.out.println(name + " завершил(а) пользование");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        }
        else {
            // альтернативный код выполнения
            System.out.println(name + " не захотел ждать и ушел");
        }
    }
}
