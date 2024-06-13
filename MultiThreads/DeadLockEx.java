package MultiThreads;

public class DeadLockEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        TestThread1 thr1 = new TestThread1();
        TestThread2 thr2 = new TestThread2();
        thr1.start();
        thr2.start();
    }
    
}

class TestThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("TestThread1: попытка захватить монитор объекта lock1");
        synchronized(DeadLockEx.lock1) {
            System.out.println("TestThread1: монитор объекта lock1 захвачен");
            System.out.println("TestThread1: попытка захватить монитор объекта lock2");
            synchronized(DeadLockEx.lock2) {
                System.out.println("TestThread1: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
// Что бы избежать deadLock в данном случае нужно сделать порядок lock1 и lock2 одинаковыми в обоих классах
// то есть если в первом сначала захватывается lock1 а потом lock2, то и во втором классе нужно что бы перым захватывался lock1
class TestThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("TestThread2: попытка захватить монитор объекта lock2");
        synchronized(DeadLockEx.lock2) {
            System.out.println("TestThread2: монитор объекта lock1 захвачен");
            System.out.println("TestThread2 : попытка захватить монитор объекта lock2");
            synchronized(DeadLockEx.lock1) {
                System.out.println("TestThread2: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}