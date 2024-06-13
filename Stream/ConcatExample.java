package Stream;

import java.util.stream.Stream;

public class ConcatExample {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s2 = Stream.of(6, 7, 8, 9, 10);
        // Метод concat() объединяет стримы, он не может быть использован в цепочке
        Stream<Integer> s3 = Stream.concat(s1, s2);
        s3.forEach(System.out::println);
    }
}
