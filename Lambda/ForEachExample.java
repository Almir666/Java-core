package Lambda;

import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5); 

        // Метод forEach(Consumer c) принимает консьюмер и работает с ним
        list.forEach(el -> System.out.println(el * 2));
    }
}
