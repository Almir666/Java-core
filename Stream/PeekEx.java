package Stream;

import java.util.stream.Stream;

public class PeekEx {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        // Метод peek() как и forEach() принимает consumer но возварщает не void а стрим
        // по этому он intermediate метод
        // с помощью него можно посмотреть что происхродит на разных этапах нашего метод чейнинга
        System.out.println(s1.distinct().peek(System.out::println).count());
    }
}
