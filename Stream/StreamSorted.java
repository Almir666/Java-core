package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Бойчик", 125.5, 15.3);
        Cat cat2 = new Cat("Бойчик", 155.1, 18.1);
        Cat cat3 = new Cat("Бойчик", 80.7, 11.4);
        Cat cat4 = new Cat("Бойчик", 100.5, 12.5);
        Cat cat5 = new Cat("Бойчик", 170.9, 20.3);

        int[] arr = {12, 4, 5, 1, 78, 45, 33, 8, 56};

        // Метод sorted() сортирует наш стрим натуральным образом
        arr = Arrays.stream(arr).sorted().toArray();

        System.out.println(Arrays.toString(arr));

        List<Cat> cats = new ArrayList<>();
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat1);
        cats.add(cat4);
        cats.add(cat5);

        // Передали в метод sorted() компаратор и отсортировали кошек по весу
        // так как сам по себе класс кошек не подразумевает натуральной сортировки
        cats = cats.stream().sorted((c1, c2) -> c1.getWeight().compareTo(c2.getWeight())).collect(Collectors.toList());

        System.out.println(cats);
    }
}
