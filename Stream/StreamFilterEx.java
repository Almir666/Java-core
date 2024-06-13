package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterEx {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Бойчик", 125.5, 15.3);
        Cat cat2 = new Cat("Бойчик", 155.1, 18.1);
        Cat cat3 = new Cat("Бойчик", 80.7, 11.4);
        Cat cat4 = new Cat("Бойчик", 100.5, 12.5);
        Cat cat5 = new Cat("Бойчик", 170.9, 20.3);

        ArrayList<Cat> catList = new ArrayList<>();
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);

        // метод filter() принимает предикат, работает так же как map()
        List<Cat> newCat = catList.stream().filter(cat -> cat.getSpeed() > 110.0 && cat.getWeight() < 20.0).collect(Collectors.toList());

        System.out.println(newCat);

        // Так же можно создавать стрим с нуля
        Stream<Cat> myStream = Stream.of(cat1, cat2, cat3);
        myStream.filter(c -> c.getSpeed() > 100.0);
    }
}

class Cat {
    private String name;
    private Double speed;
    private Double weight;

    public Cat(String name, Double speed, Double weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public Double getSpeed() {
        return speed;
    }
    public Double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSpeed(Double speed) {
        this.speed = speed;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Вес: " + weight + ", Скорость: " + speed + ", Имя " + name;
    }
}
