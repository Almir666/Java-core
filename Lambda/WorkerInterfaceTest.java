package Lambda;

import java.util.Arrays;
import java.util.List;

public class WorkerInterfaceTest {

    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }
    public static void main(String[] args) {
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
               System.out.println("Worker вызван через анонимный класс");
            }
        });

        execute(() -> System.out.println("Worker вызван через Lambda"));


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();

        new Thread(() -> System.out.println("Hello from thread")).start();


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(i -> System.out.println(i));

        list.forEach(System.out::print);
        System.out.println();


        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        for(Integer n : list1) {
        int x = n * n;
        System.out.println(x);
        }

        list1.stream().map((x) -> x * x).forEach(System.out::println);

       
    }
}
