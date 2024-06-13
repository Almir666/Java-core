package MultiThreads;

import java.util.concurrent.CountDownLatch;

// СountDownLatch - это синхронизатор, позволяющий любому количеству потоков ждать пока не завершится
// определенное количество операций. В конструктор CountDownLatch нужно передавать количество операций,
// которые должны завершиться, что бы потоки продолжили свою работу. 

public class CountDownLatchEx {
    // Создали наш CountDownLatch, передае в него 3 операции
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    // Создаем сами операции, это будут просто статические методы в которых мы будем выводить текст
    // затем вызывать метод countDown(), он снижает количество счетчика на 1
    private static void marketStaffOnPlace() {
        try {
            Thread.sleep(2000);
            System.out.println("Персонал магазина явился в полном составе");
            // Из нашего статического CountDown Latch вызвали метод countDown() и снизили счетчик с 3 до 2
            countDownLatch.countDown();
            // getCount() выведет текущее значение счетчика
            System.out.println("Действий до открытия: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void everythingIsReady() {
        try {
            Thread.sleep(3000);
            System.out.println("Все работники готовы к открытию");
            countDownLatch.countDown();
            System.out.println("Действий до открытия: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void openMarket() {
        try {
            Thread.sleep(4000);
            System.out.println("Двери магазина открыты");
            countDownLatch.countDown();
            System.out.println("Действий до открытия: " + countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // Создаем покупателей, передаем мим в конструктор наш статический CountDownLatch
        new BioTrash("животное 1", countDownLatch);
        new BioTrash("животное 2", countDownLatch);
        new BioTrash("животное 3", countDownLatch);
        new BioTrash("животное 4", countDownLatch);
        new BioTrash("животное 5", countDownLatch);

        // вызываем 3 наших операции
        marketStaffOnPlace();
        everythingIsReady();
        openMarket(); 
    }
}

// Создаем класс поток в который будем передовать наш CountDownLatch
class BioTrash extends Thread {
    String name;
    CountDownLatch countDownLatch;

    public BioTrash(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }
    @Override
    public void run() {
        try {
            // метод await() блокирует поток пока счетчик CountDownLatch не станет равен 0. 
            countDownLatch.await();
            System.out.println(name + " приступило к закупкам...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}