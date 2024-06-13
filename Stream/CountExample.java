package Stream;

import java.util.stream.Stream;

public class CountExample {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        // Метод count() возвращает колличество элементов
        // он терминальный
        System.out.println(s1.count());
        // Если закоментировать верхнюю строку то мы сможем испозльзовать нижнюю для подсчета уникальных элементов
        // мы не можем использовать обе так как м не можем работать с уже ранее использованным стримом
        System.out.println(s1.distinct().count());
    }
}
