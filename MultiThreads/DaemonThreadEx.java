package MultiThreads;

public class DaemonThreadEx {
    public static void main(String[] args) {
        System.out.println("Поток main начал свою работу");
        UserThread userThread = new UserThread();
        DaemonThread daemonThread = new DaemonThread();
        // Метод setDaemon(true) делает поток демоном, важно вызывать метод после создания потока но до его запуска
        daemonThread.setDaemon(true);
        userThread.setName("User Thread");
        daemonThread.setName("Daemon Thread");
        userThread.start();
        daemonThread.start();



        System.out.println("Поток main завершил работу");
    }
}

class UserThread extends Thread {
    @Override
    public void run() {
        // Метод isDaemon() проверяет является ли поток демоном
        System.out.println(Thread.currentThread().getName() + " is a daemon: " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is a daemon: " + isDaemon());
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}