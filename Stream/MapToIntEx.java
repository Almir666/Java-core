package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntEx {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Бойчик", 150.0, 15.3);
        Cat cat2 = new Cat("Джоинт", 120.0, 18.1);
        Cat cat3 = new Cat("Том", 100.0, 11.4);
        Cat cat4 = new Cat("Джерри", 150.0, 12.5);
        Cat cat5 = new Cat("Георгий", 120.0, 20.3);
        Cat cat6 = new Cat("Ластецкий", 150.0, 20.3);

        List<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);
        catList.add(cat6);
        // Метод mapToInt преобразует поток в Integer, здесь же мы используем метод boxed() 
        // он нужен что бы преобразовать int в Integer
        // это intermediate метод
        List<Integer> intList = catList.stream().mapToInt(c -> c.getSpeed().intValue()).boxed().collect(Collectors.toList());
        // У int стрима который возвращается от mapToInt есть несколько методов для раблты с числами sum() average() min() max()
        Double sum = catList.stream().mapToDouble(c -> c.getSpeed()).sum();
        // метод average() возвращает OptionalDouble по этому его нужно конвертировать в Double с помощью метода getAsDouble()
        Double avg = catList.stream().mapToDouble(c -> c.getSpeed()).average().getAsDouble();
        System.out.println(sum);
        System.out.println(avg);
        System.out.println(intList);
    }
}
