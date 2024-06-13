package MultiThreads;

// У потока есть три состояния: new   runnable  terminated
// new это состояние когда поток был создан но еще не запустили метод start()
// runnable делится на два состояния: ready(ожидает своей очереди) и running(поток в состоянии работы)  
// terminated состояние когда поток завершил работу

public class ThreadsRunnableEx {
    // Метод main тоже в свою очередь является потоком
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        // Для запуска потока используем метод start() который в свою очередь вызывает метод run()
        thread1.start();
        // создавая new Thread() в его параметры передаем объект который имплементирует интерфейс Runnable
        new Thread(new MyThread2()).start();
        // Так же можно создать поток при помощи анонимного класса
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Сообщение из потока созданого при помощи анонимного класса");
            }
        }).start(); 
        // Так же можно записать код выше в виде лямбда выражения, обазятельно нужно не забыть вызвать метод start()
        new Thread(() -> System.out.println("Поток созданый с помощью анонимного класса записанный в виде лямбды")).start();
    }
}
// Вариант сохдания потока:
// наследуем наш класс от класса Thread и переопределяем метод run()
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
// Также мы можем имплементировать интерфейс Runnable в нем так же переопределяем метод run()
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            System.out.println(i);
        }
    }
}