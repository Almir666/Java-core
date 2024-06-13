package MultiThreads;

public class SleepJoinEx {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable run = new MyRunnable();
        Thread thread1 = new Thread(run);
        thread1.start();
        // Метод join() заставлет дожидаться завершения работы потока, 
        // и только после завершения текущего потока поток метода мейн продолжит свою работу
        // он так же выбрасывает InterruptedException
        // в его параметры можно передать милисекунды, по истечению этого времени поток мейн перестает ждать, либо поток завершится раньше сам
        thread1.join();
        // Без метода join() поток мет ода мейн будет завершаться раньше и End будет идти впереди перечисления а не в конце
        // так как метотд main не спит 1 сек в отличие от MyRunnable

        // метод getState() показывает состояние потока, в данному случае будет terminated так как поток завершил свою работу
        System.out.println(thread1.getState());
        System.out.println("End");
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                // метод sleep() останавливает поток на указанное время(в милисекундах) он выбрасывает InterruptedException
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}