package Lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierExample {
    // Создаем метод котрый принимает Supplier и на его основе добавляет элементы в наш список
    public static ArrayList<Car> carCreater(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            al.add(carSupplier.get());
        }
        return al; 
    }

    public static void main(String[] args) {
        // Интерфейс Supplier(T t) ничего не принимает, и возвращает обьект
        // Имеет один метод T get();
        ArrayList<Car> cars = carCreater(() -> new Car("Nissan", "Black", 1.6));
        System.out.println(cars);
    }
}


class Car {
    String model;
    String color;
    Double engine;

    public Car(String model, String color, Double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ". Цвет: " + color + ". Двигатель: " + engine;
    }
    
}
