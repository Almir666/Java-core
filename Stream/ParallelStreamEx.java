package Stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamEx {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10345);
        list.add(666);
        list.add(12);
        list.add(0);
        list.add(13560);
        // parallelStream() разделяет задачу между ядрами компьютера что бы решить ее быстрее
        // его можно использовать когда в задаче очень большое колличество элементов
        // но важно что бы последовательност ьэлементов не влияла на результат операции
        // например операцию сложения или умножения мы можем решить с его помощью а вот деление не получится 
        int result = list.parallelStream().reduce((a,e) -> a + e).get();
        System.out.println(result);
    }
}
