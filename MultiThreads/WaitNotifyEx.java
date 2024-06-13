package MultiThreads;

// В этом примере рассматриваем wait() и notify()

public class WaitNotifyEx {
    public static void main(String[] args) {
        // Создаем объект маркета который будем передавать в продюсер и консьюмер
        Market market = new Market();
        // В продюсе ри консьюмер переда нодин и тот же маркет по этому они будут синхронизированы по нему
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thr1 = new Thread(producer);
        Thread thr2 = new Thread(consumer);

        thr1.start();
        thr2.start();
    }
}

// Создаем класс маркет который будет содержать 5 товаров на прилавке, если количество товаров от 1 до 5 их можно покупать
// всего товаров может быть произведено 10, наша задача сделать так что бы если количество товаров больше 1 они продавались, если меньше то
// ждем пока появятся новые
class Market {
    private int productCount = 0;
    // Создаем синхпонизированный метод в нем мы определяем, если товаров нет то применяем wait() и ждем пока не добавтся новые 
    // освобождая монитор
    public synchronized void getProduct() {
        while (productCount < 1) {
            try {
                // wait() освободит монитор и будет ждать
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Если же продуктов больше чем 1 то мы извлекаем один продукт и затем вызовем метод notify()
        productCount--;
        System.out.println("Покупатель приобрел 1 товар");
        System.out.println("Количество товара в магазине: " + productCount);
        // notify() оповестит что монитор свободет и его можно захватывать
        notify();
    }
    // Здесь все как в предыдущем методе но наоборот, если продуктов больше 5 мы вызываем wait()
    public synchronized void putProduct() {
        while (productCount >=5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // если продуктов меньше 5 то добаволяем один и вызываем notify()
        productCount++;
        System.out.println("Производитель дробавил 1 товар");
        System.out.println("Количество товара в магазине: " + productCount);
        notify();
    }
}

class Producer implements Runnable {
    //  Создаем два раннабл класса с методоами которые будут добавлять и потреблять товары 10 раз
    // В них создаем экземпляр маркета по которому мы будем синхронизироваться
    Market market;
    public Producer(Market market) {
        this.market = market;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putProduct();
        }
    }
}

class Consumer implements Runnable {
    Market market;
    public Consumer(Market market) {
        this.market = market;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getProduct();
        }
    }
}