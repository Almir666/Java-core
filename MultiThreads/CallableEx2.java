package MultiThreads;

// Задача: ищем сумму числел от 1 до 1000000000(миллиард)
// Для этого будем использовать 10 потоков которые разделят между собой эту задачу

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx2 {
    // задаем число сумму которого мы хотим получить
    private static long value = 1000_000_000L;
    // здесь будем хранить итоговую сумму
    private static long sum = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // cоздаем ExecutorService на 10 потоков
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // создаем лист Future в котором будем хранить промежуточные результаты сложения от каждого потока
        List<Future<Long>> partSumList = new ArrayList<>();
        // Здесь мы делим наше число сумму которого хотим узнать на 10 что бы можно было вычислить from и to для каждого потока
        long valueDivBy10 = value / 10;

        for (int i = 0; i < 10; i++) {
            // тут десятую часть от нашего миллиарда умнрожаем на i(0) получаем 0 и прибавляем 1
            // получается для первого задания from будет 1, сложение начнется с 1
            // во второй итерации уже будет не 1 а 100000001 так как 100000000 умножится не на 0 а на 1 и + 1
            // и так далее
            long from = valueDivBy10 * i + 1;
            // тут же мы вычисляем границу диапозона 100000000 умножаем на 1, в след итерации на 2 и так далее
            long to = valueDivBy10 * (i + 1);
            // создаем нашу задачу, передаем в нее диапозон
            PartialWork task = new PartialWork(from, to);
            // Вызываем метод submit(), передаем в него нашу задачу и сразу сохраняем результат в объект Future
            Future<Long> futurePartSum = executorService.submit(task);
            // добавляем получившийся Future в наш список объектов Future
            partSumList.add(futurePartSum);
        }
        // в цикле просто суммируем все 10 промежуточных сумм и сохраняем в итоговой переменной
        for (Future<Long> part : partSumList) {
            sum += part.get();
        }
        // завершаем задачи
        executorService.shutdown();
        // Выводим результат
        System.out.println("Total sum: " + sum);
    }
}

// Создаем класс содержащий Long, имплеменитрующий коллабл
class PartialWork implements Callable<Long> {
    // from число с которого начинаем сложение(начало диапозона)
    long from;
    // to число до которого складываем включительно(конец диапозона)
    long to;
    // сумма сложения чисел этого потока
    long localSum;

    public PartialWork (long from, long to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public Long call() throws Exception {
        // передачем наш диапозон от from до to
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from: " + from + " to: " + to + " = " + localSum);
        // получаем ту часть суммы которую обрабатывает данный поток
        return localSum;
    }
}
