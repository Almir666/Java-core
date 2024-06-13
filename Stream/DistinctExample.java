package Stream;

import java.util.stream.Stream;

public class DistinctExample {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        // Метод distinct() возвращает стрим уникальных элементов
        // он Intermediate
        s1.distinct().forEach(System.out::println);
    }
}
