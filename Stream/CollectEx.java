package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectEx {
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
        // Метод collect(Collectors.groupingBy()) создает коллекции с ключем в нашем случае по скорости обьекта
        // у котов три разных скорочти в нашем случае 150 / 120 / 100
        // таким образом создается три колекции Map в которых ключем будет Double а значемнием весь объект целиком
        Map<Double, List<Cat>> map = catList.stream().map(c -> {c.setName(c.getName().toUpperCase());
                        return c;
        })
            .collect(Collectors.groupingBy(c -> c.getSpeed()));

        for(Map.Entry<Double, List<Cat>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
            // Метод collect(Collectors.partitioningBy()) разделяет на две коллекции, на ту что отвечает предикату и ту что нет
        // Map<Boolean, List<Cat>> map = catList.stream().collect(Collectors.partitioningBy(c -> c.getSpeed() > 120.5));

        //     for(Map.Entry<Boolean, List<Cat>> entry: map.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        // }
    }
}