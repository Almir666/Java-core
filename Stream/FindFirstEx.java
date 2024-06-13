package Stream;

import java.util.ArrayList;
import java.util.List;

public class FindFirstEx {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Бойчик", 150.0, 15.3);
        Cat cat2 = new Cat("Джоинт", 120.5, 18.1);
        Cat cat3 = new Cat("Том", 100.0, 11.4);
        Cat cat4 = new Cat("Джерри", 150.0, 12.5);
        Cat cat5 = new Cat("Георгий", 120.5, 20.3);

        List<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);

        Cat cat = catList.stream().map(c -> {
            c.setName(c.getName().toUpperCase());
            return c;
        })
        // Метод findFirst() возвращает первый элемент нашего стрима
        // он терминальный
        .filter(c -> c.getSpeed() > 120.5).findFirst().get();

        System.out.println(cat.getName());
    }
}
