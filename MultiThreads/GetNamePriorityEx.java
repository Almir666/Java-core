package MultiThreads;

public class GetNamePriorityEx implements Runnable{
    @Override
    public void run() {
        // Thread имеет статический метод currentThread() который указывает на текущий поток
        // соответственно вызываться он должен из класса Thread
        // мтоды get/setPriority() работают с приоритетом потока. по умолчанию он равен 5, самый низкий 1, высокий 10
        // у приотритов есть константы   MIN/MAX/NORM_PRIPRITY которые задают приоритет 1/10/5 соответственно
        // они так же вызываются из класса Thread
        System.out.println("Метод run(). Имя потока: " + Thread.currentThread().getName() + ". Приоритет: " + Thread.currentThread().getPriority());
    }
    
    public static void main(String[] args) {
        new Thread(new GetNamePriorityEx()).start();
        MyThread thread = new MyThread();
        thread.setName("Мой поток");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        // Здесь отслеживаем поток метода мейн, метод currentThread будет указвать на поток main()
        System.out.println("Метод main(). Имя потока: " + Thread.currentThread().getName() + ". Приоритет: " + Thread.currentThread().getPriority());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Метод run(). Имя потока: " + Thread.currentThread().getName() + ". Приоритет: " + Thread.currentThread().getPriority());
    }
}

