package MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorEx2 {
    public static void main(String[] args) throws InterruptedException {
        // ScheduleExecutorService мы используем тогда когда хотим установить расписание на запуск потоков из пула
        ScheduledExecutorService scheduledEx = Executors.newScheduledThreadPool(1);

        // Метод schedule() выполняет задачи с переодичностью указаной в параметрах, 2 сек в нашем случае
        // scheduledEx.schedule(new Runnable777(), 2, TimeUnit.SECONDS);

        // scheduleAtFixedRate() принимает в себя задачу, время через которое выполнение запустится в первый раз
        // и периодичность с которой задачи будут выпоняться в дальнейшем
        // периодичность в 1 секунду в нашем случае проходит между началом выполнения задачи и налом выполнения следующей
        // если задача выполняется дольше одной секунды то сервис не ждет завершения предыдущей а начинает выполнение следующей
        // scheduledEx.scheduleAtFixedRate(new Runnable777(), 5, 1, TimeUnit.SECONDS);

        // scheduleWithFixedDelay() выполняет задания с периодичностью которая проходит между окончанием предыдущего задания
        // и началом полседующего
        scheduledEx.scheduleWithFixedDelay(new Runnable777(), 3, 1, TimeUnit.SECONDS);
        Thread.sleep(10000);
        scheduledEx.shutdown();

        // newCachedThreadPool() создает треды по мере необходимости, например если все текущие треды из пула заняты 
        // и приходит новое задание то Кешированный тредПулл создает новый поток и берет это задание
        // если в течении 60 секунд треду не поступает задание и он не используется то Кешированный тредПулл удалит этот тред
        @SuppressWarnings("unused")
        ExecutorService exService = Executors.newCachedThreadPool();
    }
}

class Runnable777 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins works");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        System.out.println(Thread.currentThread().getName() + " ends works");
    }
}