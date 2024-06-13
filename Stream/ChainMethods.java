package Stream;

import java.util.Arrays;

public class ChainMethods {
    public static void main(String[] args) {
        int[] array = {3, 1, 8, 5, 9, 12, 4, 21, 81, 7, 18};
        // Методы в стримах можно вызывать по цепочке
        // в начале идут Intermediate методы и завершаются терминальным методом
        // без терминального метода отсальные не запустятся
        int result = Arrays.stream(array).filter(a -> a % 2 == 1).
                map(e -> {if (e % 3 == 0) {e = e/3;} return e;}).
                reduce((a, e) -> a + e).getAsInt();

        System.out.println(result);
    }
}
