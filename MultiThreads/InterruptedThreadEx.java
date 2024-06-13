package MultiThreads;

public class InterruptedThreadEx {
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException{
        System.out.println("main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        thread.sleep(2000);
        // Метод interrupt() останавливает поток
        thread.interrupt();
        thread.join();
        System.out.println("main ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            // isInterrupted() проверяет хотят ли прервать наш поток
            if(isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Пороверка состояния процесса прошла успешно. Завершаем поток");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum+= Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна. Завершаем его");
                System.out.println(sqrtSum);
                return;
            }
            
        }
        System.out.println(sqrtSum);
    }
}