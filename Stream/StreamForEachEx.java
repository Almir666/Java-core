package Stream;

import java.util.Arrays;

public class StreamForEachEx {
    // forEach в stream() возвращает void по этому его нельзя преобразовать в коллекцию

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 0, 6, 8, 9};

        // Этот forEach(Consumer t) принимает консумер, тут мы умножаем каждый элемент на себя
        Arrays.stream(arr).forEach(e -> {e *= e; System.out.print(e + " ");});
        System.out.println();

        // Тут мы просто выводим имеющиеся элементы на экран
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println();

        // Это метод референс, тут мы даем ссылку на метод println который находится в System.out
        // до :: мы указываем класс после указываем метод
        // так можно делать с любым методом
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();

        // Используем кастомный метод
        Arrays.stream(arr).forEach(TestForEach::change);

    }
}

class TestForEach {
    public static void change(int a) {
        System.out.print(a + 5 + " ");
    }
}