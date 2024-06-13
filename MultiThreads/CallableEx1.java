package MultiThreads;

// Callable<T> как и Runnable представляет собой задание которое выполняется потоком
// Сallable мы можем использовать только с ExecutorService(ми) в то время как Runnable мы можем передвать в параметр new Thread(Runnable)
// если нужно что бы таск возвращал результат то используем Callable если нет то Runnable 

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx1 {
    static int factorialResult;
    public static void main(String[] args) {
        // Создаем синглТредЭкзекьютор для факториала нам хватит одного потока
        ExecutorService exServ = Executors.newSingleThreadExecutor();
        // Создаем экземпляр нашего класса Callable
        FactorialCallable factorial = new FactorialCallable(6);
        // Выполнем в нашем Экзекьюторе метод submit() который принимает задание в виде Callable
        // submit() это аналог метода execute()
        // так как Callable возвращает значение, инт в нашем случае то сразу присвоим результат к переменной future
        // типа Future<Integer>. Future<T> класс который хранит в себе значение нашего таска
        // Future<> называется так потому что он будет хранить результат выполнения задания в будущем когда работа завершится
        Future<Integer> future = exServ.submit(factorial);
        try {
            // isDone() возвращает boolean показывает завершил поток работу или нет
            System.out.println("Статус завершения работы потока: " + future.isDone());
            System.out.println("Ждем получения результата...");
            // метод get() позволяет нам получить значение из объекта Future<>
            // он блокирует поток в котором находится до завершения выполнения таска
            factorialResult = future.get();
            System.out.println("Результат получен:");
            System.out.println(factorialResult);
            System.out.println("Статус завершения работы потока: " + future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            // getCause() возвращает текст указаный в параметре Exception
            System.out.println(e.getCause());
        }
        finally {
            exServ.shutdown();
        }
    }
    
}

// Интерфейс Callable<T> похож на Runnable но он имеет return type, и может выбрасывать Exception
class FactorialCallable implements Callable<Integer> {
    int f;
    public FactorialCallable (int f) {
        this.f = f;
    }

    @Override
    // Он имеет единственный абстрактный метод - T call() throws Exception
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Вы ввели не корректное число, введите положительное целое число.");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            // усыпляем поток на одну секунду в каждой итерации для того что бы посмотреть как работает метод get()
            // в классе Future<>
            Thread.sleep(1000);
        }
        return result;
    }
}
