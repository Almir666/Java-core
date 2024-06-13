package Lambda;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionExample {
    // Создали метод который принимает лист обьектов и функциональный интерфейс Function
    // Function имеет метод R apply(T) которрый принимает обьект и возвращает обьект
    // В нашем случае принимает кошек и возвращает Double
    public static double avgSomething (ArrayList<Cat> list, Function<Cat, Double> func) {
        double result = 0;
        for (Cat cat : list) {
            result += func.apply(cat);
        }
        return result / list.size();
    }

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

        // Любой фунциональный интерфейс мы можем записать в выражение и присвоить ссылку для многократного использования
        Function<Cat, Double> fSpeed = cat -> cat.speed;
        Function<Cat, Double> fWeight = cat -> cat.weight;

        double avgSpeed = avgSomething(catList, fSpeed);
        double avgWeight = avgSomething(catList, fWeight);

        System.out.println("Средняя скорочть кошек: " + avgSpeed);
        System.out.println("Средний вес кошек: " + avgWeight);
    }
}

class Cat {
    String name;
    Double speed;
    Double weight;

    public Cat(String name, Double speed, Double weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Вес: " + weight + ", Скорость: " + speed + ", Имя " + name;
    }
}
